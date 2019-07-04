package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DepthList {

	public static void createList(TreeNode root,ArrayList<ArrayList<Integer>>lists,int level)
	{
		if(root==null)return;
		ArrayList<Integer> list ;
		if(lists.size()==level)
		{
			list = new ArrayList<>();
			lists.add(list);
		}
		else
		{
			list=lists.get(level);
		}

		list.add(root.data);
		
		createList(root.left, lists, level+1);
		createList(root.right, lists, level+1);
	}
	
	
	public static ArrayList<ArrayList<Integer>> createBfsList(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(root.data);
		
		lists.add(list);
		
		q.add(root);
		
		while(!q.isEmpty())
		{
			TreeNode parent = (TreeNode) q.poll();
			
			ArrayList<Integer> l = new ArrayList<>();
			
			if(parent.left!=null)
			{
			l.add(parent.left.data);
			q.add(parent.left);

			}
			
			if(parent.right!=null)
			{
			l.add(parent.right.data);
		    q.add(parent.right);
			}
		    lists.add(l);
		    		
		}
		return lists;
		
}
	
	public static void main(String args[])
	{
      int a[] = new int[]{5,10,1,4,7};
      TreeNode root=null;
  	
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
		ArrayList<ArrayList<Integer>>lists=new ArrayList<>();
		//createList(root, lists, 0);
		lists=createBfsList(root);
		int level=0;
		for(ArrayList<Integer>list:lists)
		{
			System.out.println("level===="+ level);

			Iterator<Integer> it =list.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
			level++;
		}
	}
	
	public static void inorder(TreeNode root)
	{
		if(root==null)return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
}
