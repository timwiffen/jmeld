package org.jmeld.ui.util;

import com.jgoodies.looks.plastic.*;
import com.jgoodies.looks.plastic.theme.*;
import com.jidesoft.plaf.*;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

import org.jmeld.settings.*;
import org.jmeld.*;
import org.jmeld.util.*;

public class LookAndFeelManager
{
  // Class variables:
  private static LookAndFeelManager instance = new LookAndFeelManager();

  private LookAndFeelManager()
  {
    init();
  }

  public static LookAndFeelManager getInstance()
  {
    return instance;
  }

  private void init()
  {
    try
    {
      PlasticLookAndFeel.setTabStyle(PlasticLookAndFeel.TAB_STYLE_METAL_VALUE);
      System.setProperty(PlasticLookAndFeel.DEFAULT_THEME_KEY, "MySkyBluer");

      UIManager.installLookAndFeel("JGoodies Plastic 3D",
        "com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void install()
  {
    String version;
    Plastic3DLookAndFeel plastic;
    String lookAndFeelName;
    String lookAndFeelClassName;
    Component root;

    try
    {
      lookAndFeelClassName = getDefaultLookAndFeelClassName();

      // Try the preferred look and feel:
      lookAndFeelName = JMeldSettings.getInstance().getEditor()
          .getLookAndFeelName();
      for (UIManager.LookAndFeelInfo info : UIManager
          .getInstalledLookAndFeels())
      {
        if (ObjectUtil.equals(info.getName(), lookAndFeelName))
        {
          lookAndFeelClassName = info.getClassName();
          break;
        }
      }

      UIManager.setLookAndFeel(lookAndFeelClassName);
      LookAndFeelFactory.installJideExtension();

      root = SwingUtilities.getRoot(JMeld.getJMeldPanel());
      if (root != null)
      {
        SwingUtilities.updateComponentTreeUI(root);
      }
    }
    catch (Exception e)
    {
    }
  }

  public String getInstalledLookAndFeelName()
  {
    LookAndFeel lf;

    lf = UIManager.getLookAndFeel();

    // WATCH OUT: 
    //   The lookandfeel can be registered in the UIManager with a different
    //   name than the lookAndFeel.getName() (Is this a bug?)

    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
    {
      if (ObjectUtil.equals(info.getClassName(), lf.getClass().getName()))
      {
        return info.getName();
      }
    }

    // This should never happen!
    return lf.getName();
  }

  private String getDefaultLookAndFeelClassName()
  {
    if (System.getProperty("java.version").startsWith("1.7"))
    {
      return UIManager.getSystemLookAndFeelClassName();
    }

    return Plastic3DLookAndFeel.class.getName();
  }

  public List<String> getInstalledLookAndFeels()
  {
    List<String> result;

    result = new ArrayList<String>();
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
    {
      result.add(info.getName());
    }

    return result;
  }
}
