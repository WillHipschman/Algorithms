package util.commands;

import datastructures.list.LinkedList;

public class AddToFrontOfList<T> implements Command<T> {

	public LinkedList<T> List = new LinkedList<T>();
	
	public void Run(T t)
	{
		List.InsertHead(t);
	}
}
