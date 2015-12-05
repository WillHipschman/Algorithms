package data;

public class LinkedList<T> {

	public Node<T> head = null;
	public Node<T> tail = null;
	
	public LinkedList(){
		
	}
	
	public boolean IsEmpty()
	{
		return head == null;
	}
	
	//O(1)
	public void InsertHead(T data)
	{
		Node<T> n = new Node<T>(data);
		n.previous = null;
		n.next = this.head;
		
		if(this.head != null)
		{
			this.tail.previous = n;
		}
		
		this.head = n;
		
		if(this.tail == null)
		{
			this.tail = n;
		}
	}
	
	//O(1)
	public void InsertTail(T data)
	{
		Node<T> n = new Node<T>(data);
		n.previous = this.tail;
		n.next = null;
		
		if(this.tail != null)
		{
			this.tail.next = n;
		}
		
		this.tail = n;
		
		if(this.head == null)
		{
			this.head = n;
		}
	}
	
	public void Remove(Node<T> n)
	{
		Node<T> next = n.next;
		Node<T> prev = n.previous;
		
		if(prev != null)
		{
			prev.next = next;
		}
		else
		{
			this.head = next;
		}
		
		if(next != null)
		{
			next.previous = prev;
		}
		else
		{
			this.tail = prev;
		}
	}
	
	//O(1)
	public T RemoveTail()
	{
		Node<T> val = this.tail;
		this.tail = this.tail.previous;
		this.tail.next = null;
		
		return val.data;
	}
	
	//O(1)
	public T RemoveHead()
	{
		Node<T> val = this.head;
		this.head = this.head.next;
		this.head.previous = null;
		
		return val.data;
	}
}
