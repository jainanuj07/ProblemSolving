package tree;

public class CheckBst {
	
	public boolean isBst(TreeNode root,TreeNode left,TreeNode right)
	{
		if(root==null)return true;
		
		if(left!=null && root.data<left.data)
			return false;
		
		if(right!=null && root.data>right.data)
			return false;
		
		return isBst(root.left,left,root) && isBst(root.right,root,right);
		
		
	}
	
	public static void main(String args[])
	{
		TreeNode root=null;
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
	
		CheckBst b = new CheckBst();
	  System.out.println(b.isBst(root,null,null));
	}
	
	
	
}
