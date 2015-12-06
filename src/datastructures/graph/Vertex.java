package datastructures.graph;

import java.util.HashMap;

import datastructures.list.LinkedList;

public class Vertex<T> implements Comparable<Vertex<T>>
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
	public HashMap<Integer, Integer> adjMap;
	public LinkedList<Integer> adjList;

	public Vertex(T data, HashMap<Integer, Integer> adjMap, int vertex){
		this.data = data;
		this.adjMap = adjMap;
		this.adjList = new LinkedList<Integer>(adjMap.values());
		this.vertex = vertex;
	}
	
	public int compareTo(Vertex<T> other)
	{
		return this.distanceFromSource - other.distanceFromSource;
	}
}