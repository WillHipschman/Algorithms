package algorithms.graph;

import datastructures.graph.AdjacencyListGraph;
import datastructures.graph.AdjacencyMatrixGraph;
import datastructures.graph.Vertex;
import datastructures.graph.VisitedState;
import datastructures.list.Node;
import datastructures.list.Queue;
import util.commands.Command;

public class BreadthFirstSearch {
	
	// O(V^2)
	public static <T> void BFS(AdjacencyMatrixGraph<T> graph, Vertex<T> node, Command<Vertex<T>> visit)
	{
		Queue<Vertex<T>> toProcess = new Queue<Vertex<T>>();	
		node.state = VisitedState.FINISHED;
		toProcess.Enqueue(node);
	
		while(!toProcess.IsEmpty())
		{
			Vertex<T> prev = toProcess.Dequeue();
			
			for(int i = 0; i < graph.GetVertices().length; i ++)
			{
				if(graph.IsEdge(prev.vertex, i))
				{
					Vertex<T> current = graph.GetVertices()[i];
					
					if(current.state != VisitedState.FINISHED)
					{
						visit.Run(current);
						current.state = VisitedState.FINISHED;
						toProcess.Enqueue(current);
					}
				}
			}
		}
	}
		
	//O(V^2)
	public static <T> void BFS(AdjacencyListGraph<T> graph, Vertex<T> node, Command<Vertex<T>> visit)
	{
		Queue<Vertex<T>> toProcess = new Queue<Vertex<T>>();
		toProcess.Enqueue(node);
	
		while(!toProcess.IsEmpty())
		{
			Vertex<T> prev = toProcess.Dequeue();
			Node<Integer> current = prev.adjList.head;
			
			while(current != null)
			{
				if(graph.GetVertices()[current.data].state != VisitedState.FINISHED)
				{
					visit.Run(graph.GetVertices()[current.data]);
					graph.GetVertices()[current.data].state = VisitedState.FINISHED;
					toProcess.Enqueue(graph.GetVertices()[current.data]);
				}
				current = current.next;
			}
			
			prev.state = VisitedState.FINISHED;
		}
	}
}
