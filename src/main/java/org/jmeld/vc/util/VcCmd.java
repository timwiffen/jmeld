package org.jmeld.vc.util;

import org.jmeld.util.*;

import java.io.*;
import java.util.*;

public abstract class VcCmd<T>
{
  // Class variables:
  static private boolean debug = true;

  // Instance variables:
  private Result result;
  private T resultData;
  private File workingDirectory;

  public void initWorkingDirectory(File file)
  {
    file = file.getAbsoluteFile();

    if(!file.isDirectory())
    {
      file = file.getParentFile();
    }

    if(file.isDirectory())
    {
      workingDirectory = file;
    }
    else
    {
      workingDirectory = null;
    }
  }

  public void execute(String... command)
  {
    setResult(_execute(command));
  }

  private final Result _execute(String... command)
  {
    ProcessBuilder pb;
    Process p;
    BufferedReader br;
    InputStream is;
    int count;
    ByteArrayOutputStream baos;
    String text;
    StringBuilder errorText;
    byte[] data;

    try
    {
      pb = new ProcessBuilder(command);
      if(workingDirectory != null)
      {
        pb = pb.directory(workingDirectory);
        System.out.println("wd=" + workingDirectory);
      }

      System.out.println("wd2=" + pb.directory());
      p = pb.start();

      debug("execute: " + Arrays.asList(command));

      data = new byte[4096];

      baos = new ByteArrayOutputStream();
      is = new BufferedInputStream(p.getInputStream());
      while ((count = is.read(data, 0, data.length)) != -1)
      {
        baos.write(data, 0, count);
      }
      is.close();

      p.waitFor();

      debug("  exitValue = " + p.exitValue());
      if (p.exitValue() != 0)
      {
        errorText = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        while ((text = br.readLine()) != null)
        {
          errorText.append(text);
        }
        br.close();
        return Result.FALSE(errorText.toString() + " (exitvalue="
                            + p.exitValue() + ")");
      }

      build(baos.toByteArray());
      baos.close();
      baos = null;
    }
    catch (Exception ex)
    {
      result = Result.FALSE(ex.getMessage(), ex);
      baos = null;
      return result;
    }

    return Result.TRUE();
  }

  protected abstract void build(byte[] data);

  public void printError()
  {
    System.out.println(result.getDescription());
    if (result.hasException())
    {
      result.getException().printStackTrace();
    }
  }

  public Result getResult()
  {
    return result;
  }

  protected void setResult(Result result)
  {
    this.result = result;
  }

  protected void setResultData(T resultData)
  {
    this.resultData = resultData;
  }

  public T getResultData()
  {
    return resultData;
  }

  private void debug(String text)
  {
    if(debug)
    {
      System.out.println(text);
    }
  }
}
