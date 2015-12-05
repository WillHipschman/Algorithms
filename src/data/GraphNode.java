package data;

public class GraphNode<T> extends Node<T>
{
	public int Vertex = -1;
	
	public GraphNode(Node<T> previous, Node<T> next, T data, int vertex){
		super(previous, next, data);
		this.Vertex = vertex;
	}
}