package datastructures.graph;

import datastructures.list.LinkedList;

public class Vertex<T>
{
	public T data;
	public VisitedState state = VisitedState.UNDISCOVERED;
	public Integer distanceFromSource = Integer.MAX_VALUE;
	public int vertex;
	
	//only used in AdjMatrix
	public Vertex<T> predecessor;
	public int discoveryTime = -1;
	public int finishTime = -1;
	
	//only used in AdjList
	public int weight = 0;
	public LinkedList<Vertex<T>> adjList;

	public Vertex(T data, LinkedList<Vertex<T>> adjList, int vertex){
		this.data = data;
		this.adjList = adjList;
		this.vertex = vertex;
	}
}