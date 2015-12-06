package algorithms.graph;

import datastructures.graph.AdjacencyListGraph;
import datastructures.graph.AdjacencyMatrixGraph;
import datastructures.graph.GraphNode;
import datastructures.list.Node;
import datastructures.list.Queue;

public class Search {

	public static <T> void BFS(AdjacencyMatrixGraph<T> graph, Integer sourceVertexIndex)
	{
		Queue<GraphNode<T>> toProcess = new Queue<GraphNode<T>>();
		
		if(graph.nodes.length < sourceVertexIndex)
		{
			throw new IndexOutOfBoundsException();
		}	
		
		graph.nodes[sourceVertexIndex][sourceVertexIndex].distanceFromSource = 0;
		graph.nodes[sourceVertexIndex][sourceVertexIndex].visited = true;
		
		toProcess.Enqueue(graph.nodes[sourceVertexIndex][sourceVertexIndex]);
	
		while(!toProcess.IsEmpty())
		{
			GraphNode<T> prev = toProcess.Dequeue();
			
			for(int i = 0; i < graph.nodes.length; i ++)
			{
				GraphNode<T> current = graph.nodes[prev.vertex][i];
				
				if(current.visited != true)
				{
					current.distanceFromSource = prev.distanceFromSource + 1;
					current.visited = true;
					toProcess.Enqueue(current);
				}
			}
		}
	}
	
	public static <T> void BFS(AdjacencyListGraph<T> graph, Integer sourceVertexIndex)
	{
		Queue<GraphNode<T>> toProcess = new Queue<GraphNode<T>>();
		
		if(graph.nodes.length < sourceVertexIndex)
		{
			throw new IndexOutOfBoundsException();
		}
	
		graph.nodes[sourceVertexIndex].distanceFromSource = 0;
		toProcess.Enqueue(graph.nodes[sourceVertexIndex]);
	
		while(!toProcess.IsEmpty())
		{
			GraphNode<T> prev = toProcess.Dequeue();
			Node<GraphNode<T>> current = prev.adjList.head;
			
			while(current != null)
			{
				if(current.data.visited != true)
				{
					current.data.distanceFromSource = prev.distanceFromSource + 1;
					current.data.visited = true;
					toProcess.Enqueue(current.data);
				}
				current = current.next;
			}
			
			prev.visited = true;
		}
	}
}
