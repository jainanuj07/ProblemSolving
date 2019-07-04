package tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class WeaveLists {
	
	public static void main(String args[])
	{
		LinkedList<Integer> first = new LinkedList<Integer>();
		first.add(1);
		first.add(2);
		
		LinkedList<Integer> second = new LinkedList<Integer>();
		second.add(3);
		second.add(4);
		
		ArrayList<LinkedList<Integer>> result = new ArrayList<>();
				
		LinkedList<Integer> prefix = new LinkedList<>();
	    weaveLists(first,second,prefix,result);
		
	}
	
	
	public static void weaveLists(LinkedList<Integer> first,LinkedList<Integer> second,LinkedList<Integer>prefix,ArrayList<LinkedList<Integer>> results )
	{
		if(first.size()==0 || second.size()==0)
		{
			LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return ;
		}
		
        int headfirst = first.removeFirst();
        prefix.addLast(headfirst);	
        weaveLists(first, second, prefix, results);
	}

}
