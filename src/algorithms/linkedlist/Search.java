package algorithms.linkedlist;

import data.*;

public class Search {

	//O(n)
	public Node<Integer> SearchLL(LinkedList<Integer> list, Integer val)
	{
		Node<Integer> current = list.head;
		
		while(current != null)
		{
			if(current.data == val)
			{
				return current;
			}
		}
		
		return null;
	}
}
