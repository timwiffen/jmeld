package org.jmeld.ui;

import org.jdesktop.swingx.treetable.*;
import org.jmeld.ui.swing.table.*;
import org.jmeld.util.node.*;

import javax.swing.tree.*;

import java.util.*;
import java.io.*;

public class UINode
    implements TreeTableNode, Comparable<UINode>
{
  private JMTreeTableModel treeTableModel;
  private String text;
  private String name;
  private boolean leaf;
  private JMDiffNode diffNode;
  private UINode parent;
  private List<UINode> children = new ArrayList<UINode>();
  private Map<String, UINode> childrenMap = new HashMap<String, UINode>();
  private boolean checkSort;

  public UINode(JMTreeTableModel treeTableModel, JMDiffNode diffNode)
  {
    this.treeTableModel = treeTableModel;
    this.diffNode = diffNode;

    this.name = diffNode.getName();
    this.leaf = diffNode.isLeaf();
  }

  public UINode(JMTreeTableModel treeTableModel, String name, boolean leaf)
  {
    assert name != null;

    this.treeTableModel = treeTableModel;
    this.name = name;
    this.leaf = leaf;
  }

  public String getName()
  {
    return name;
  }

  public JMDiffNode getDiffNode()
  {
    return diffNode;
  }

  public UINode addChild(UINode child)
  {
    UINode c;

    c = childrenMap.get(child.getName());
    if (c == null)
    {
      childrenMap.put(child.getName(), child);
      children.add(child);
      child.setParent(this);
      checkSort = true;

      c = child;
    }

    return c;
  }

  private void setParent(UINode parent)
  {
    this.parent = parent;
  }

  public List<UINode> getChildren()
  {
    checkSort();
    return children;
  }

  public Enumeration<UINode> children()
  {
    checkSort();
    return Collections.enumeration(children);
  }

  public boolean getAllowsChildren()
  {
    return isLeaf();
  }

  public UINode getChildAt(int childIndex)
  {
    checkSort();
    return children.get(childIndex);
  }

  public int getChildCount()
  {
    checkSort();
    return children.size();
  }

  public int getIndex(TreeNode node)
  {
    checkSort();
    return children.indexOf(node);
  }

  public UINode getParent()
  {
    return parent;
  }

  public boolean isLeaf()
  {
    return leaf;
  }

  private void checkSort()
  {
    if (checkSort)
    {
      Collections.sort(children);
      checkSort = false;
    }
  }

  public void print(String indent)
  {
    System.out.println(indent + name);
    indent += "  ";
    checkSort();
    for (UINode node : children)
    {
      node.print(indent);
    }
  }

  @Override
  public String toString()
  {
    String pn;

    if (text == null)
    {
      text = name;
      if (parent != null)
      {
        pn = parent.getName();
        if (name.startsWith(pn))
        {
          text = name.substring(pn.length());
          if (text.startsWith(File.separator))
          {
            text = text.substring(1);
          }
        }
      }
    }

    return text;
  }

  public int compareTo(UINode o)
  {
    return toString().compareTo(o.toString());
  }

  public Object getValueAt(int column)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public int getColumnCount()
  {
    return treeTableModel.getColumnCount();
  }

  public boolean isEditable(int column)
  {
    return false;
  }

  public void setValueAt(Object aValue, int column)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object getUserObject()
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void setUserObject(Object userObject)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
