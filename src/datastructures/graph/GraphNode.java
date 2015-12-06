package datastructures.graph;

import datastructures.list.LinkedList;

public class GraphNode<T>
{
	public T data;
	public VisitedState state = VisitedState.UNDISCOVERED;
	public int discoveryTime = -1;
	public int finishTime = -1;
	public Integer distanceFromSource = Integer.MAX_VALUE;
	public LinkedList<GraphNode<T>> adjList;
	public int vertex;
	public GraphNode<T> predecessor;

	public GraphNode(T data, LinkedList<GraphNode<T>> adjList, int vertex){
		this.data = data;
		this.adjList = adjList;
		this.vertex = vertex;
	}
}