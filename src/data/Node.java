package data;

public class Node<T> {

	public Node<T> parent;
	public Node<T> previous;
	public Node<T> next;
	public T data;
	
	public Node(T data){
		this.data = data;
	}
}
