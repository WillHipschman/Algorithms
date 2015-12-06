package algorithms.graph;

import datastructures.graph.AdjacencyListGraph;
import datastructures.graph.AdjacencyMatrixGraph;
import datastructures.graph.GraphNode;
import datastructures.graph.VisitedState;
import datastructures.list.Node;
import datastructures.list.Queue;
import util.commands.Command;

public class BreadthFirstSearch {
	
	// O(V^2)
	public static <T> void BFS(AdjacencyMatrixGraph<T> graph, GraphNode<T> node, Command<GraphNode<T>> visit)
	{
		Queue<GraphNode<T>> toProcess = new Queue<GraphNode<T>>();	
		node.state = VisitedState.FINISHED;
		toProcess.Enqueue(node);
	
		while(!toProcess.IsEmpty())
		{
			GraphNode<T> prev = toProcess.Dequeue();
			
			for(int i = 0; i < graph.GetVertices().length; i ++)
			{
				if(graph.edges[prev.vertex][i] == true)
				{
					GraphNode<T> current = graph.GetVertices()[i];
					
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
	public static <T> void BFS(AdjacencyListGraph<T> graph, GraphNode<T> node, Command<GraphNode<T>> visit)
	{
		Queue<GraphNode<T>> toProcess = new Queue<GraphNode<T>>();
		toProcess.Enqueue(node);
	
		while(!toProcess.IsEmpty())
		{
			GraphNode<T> prev = toProcess.Dequeue();
			Node<GraphNode<T>> current = prev.adjList.head;
			
			while(current != null)
			{
				if(current.data.state != VisitedState.FINISHED)
				{
					visit.Run(current.data);
					current.data.state = VisitedState.FINISHED;
					toProcess.Enqueue(current.data);
				}
				current = current.next;
			}
			
			prev.state = VisitedState.FINISHED;
		}
	}
}
