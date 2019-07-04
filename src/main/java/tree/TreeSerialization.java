package tree;

import java.util.StringTokenizer;

public class TreeSerialization {
  
  public static void main(String args[])
  {
    TreeNode a = new TreeNode(8);
    TreeNode b=  new TreeNode(3);
    TreeNode c = new TreeNode(10);
    TreeNode d = new TreeNode(1);
    TreeNode e = new TreeNode(6);
    
    a.left=b;
    a.right=c;
    b.left=d;
    b.right=e;

    String serialize = serialize(a);
    System.out.println(serialize(a));
     preOrderTraversal(deserialize(serialize));

  }

  public static void preOrderTraversal(TreeNode root)
  {
    if(root==null)
      return;
    System.out.println(root.data);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }
  
  public static String serialize(TreeNode root){
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  private static void serialize(TreeNode x, StringBuilder sb){
    if (x == null) {
        sb.append("# ");
    } else {
        sb.append(x.data + " ");
        serialize(x.left, sb);
        serialize(x.right, sb);
    }
  }
  
  public static TreeNode deserialize(String s){
    if (s == null || s.length() == 0) return null;
    StringTokenizer st = new StringTokenizer(s, " ");
    return deserialize(st);
  }

  private static TreeNode deserialize(StringTokenizer st){
    if (!st.hasMoreTokens())
        return null;
    String val = st.nextToken();
    if (val.equals("#"))
        return null;
    TreeNode root = new TreeNode(Integer.parseInt(val));
    root.left = deserialize(st);
    root.right = deserialize(st);
    return root;
  }
}
