package algorithms.graph;

import java.util.ArrayList;
import data.AdjacencyListGraph;
import data.Node;
import data.Queue;

public class Search {

	public static void BFS(AdjacencyListGraph graph, Integer sourceVertexIndex)
	{
		Queue<Node<Integer>> toProcess = new Queue<Node<Integer>>();
		
		if(graph.adjList.length < sourceVertexIndex)
		{
			throw new IndexOutOfBoundsException();
		}
	
		graph.adjList[sourceVertexIndex].distanceFromSource = 0;
		toProcess.Enqueue(graph.adjList[sourceVertexIndex]);
	
		while(!toProcess.IsEmpty())
		{
			Node<Integer> current = toProcess.Dequeue();
			
			while(current != null)
			{
				if(current.visited != true)
				{
					current.distanceFromSource = source.distanceFromSource + 1;
					toProcess.Enqueue(current);
				}
				current = current.next;
			}
			
			source.visited = true;
			source = toProcess.Dequeue();
		}
	}
}
