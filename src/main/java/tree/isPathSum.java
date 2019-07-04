package tree;

import java.util.ArrayList;

public class isPathSum {

	public boolean ispathSum(TreeNode root,int sum,ArrayList<Integer> list,int index)
	{
		if(root==null)return false;
		
		sum =sum-root.data;
		list.add(index, root.data);
		index++;
		
		if(sum==0) return true;
		
		return ispathSum(root.left,sum,list,index) || ispathSum(root.right, sum,list,index);
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
	
		isPathSum b = new isPathSum();
		ArrayList<Integer> l = new ArrayList<Integer>();
	  System.out.println(b.ispathSum(root,22,l,0));
	  System.out.println(l.toString());
	}
}
