package datastructures.graph;

import datastructures.list.LinkedList;

public class GraphNode<T>
{
	public T data;
	public boolean visited = false;
	public Integer distanceFromSource = Integer.MAX_VALUE;
	public LinkedList<GraphNode<T>> adjList;
	public int vertex;
	
	public GraphNode(T data, LinkedList<GraphNode<T>> adjList, int vertex){
		this.data = data;
		this.adjList = adjList;
		this.vertex = vertex;
	}
}