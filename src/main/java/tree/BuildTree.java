package tree;

public class BuildTree {
	
	private static TreeNode root=null;
	
	public static void main(String args[])
	{
		int a[] = new int[]{5,10,1,4,7};
		
		for(int i=0;i<a.length;i++)
		{
			if(root==null)
			{
				root = new TreeNode(a[i]);
			}
			else
			{
				root.insert(a[i]);
			}
		}
		inorder(root);
	}
	
	public static void inorder(TreeNode root)
	{
		if(root==null)return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

}
