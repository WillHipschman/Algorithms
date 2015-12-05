package data;

public class Queue<T> {

	LinkedList<T> queue = new LinkedList<T>();
	
	public boolean IsEmpty()
	{
		return queue.IsEmpty();
	}
	
	public void Enqueue(T val)
	{
		queue.InsertHead(val);;
	}
	
	public T Dequeue()
	{
		return queue.RemoveTail();
	}
}
