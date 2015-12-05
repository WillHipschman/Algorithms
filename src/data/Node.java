package data;

public class Node<T> {

	public Node<T> previous;
	public Node<T> next;
	public T data;
	public boolean visited = false;
	public Integer distanceFromSource = Integer.MAX_VALUE;
	
	public Node(Node<T> previous, Node<T> next, T data){
		this.previous = previous;
		this.next = next;
		this.data = data;
	}
}
