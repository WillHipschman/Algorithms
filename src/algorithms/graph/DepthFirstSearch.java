package algorithms.graph;

import datastructures.graph.AdjacencyListGraph;
import datastructures.graph.AdjacencyMatrixGraph;
import datastructures.graph.Graph;
import datastructures.graph.GraphNode;
import datastructures.graph.GraphType;
import datastructures.graph.VisitedState;
import util.Command;

public class DepthFirstSearch {

	private static int time = 0;
	
	// O(V + E) = O(V^2)
	public static <T> void DFS(Graph<T> graph, Command<GraphNode<T>> visit)
	{		
		DepthFirstSearch.time = 0;
		
		for(int i = 0; i < graph.GetVertices().length; i++)
		{
			graph.GetVertices()[i].state = VisitedState.UNDISCOVERED;
			graph.GetVertices()[i].predecessor = null;
		}

		for(int i = 0; i < graph.GetVertices().length; i++)
		{
			if(graph.GetVertices()[i].state == VisitedState.UNDISCOVERED)
			{
				DFSVisit(graph, graph.GetVertices()[i], visit);
			}
		}
		
		if(graph.GetType() == GraphType.UNKNOWN)
		{
			graph.SetType(GraphType.ACYCLIC);
		}
	}
	
	private static <T> void DFSVisit(
			Graph<T> graph,
			GraphNode<T> node,
			Command<GraphNode<T>> visit)
	{
		if(graph instanceof AdjacencyMatrixGraph<?>)
		{
			DFSVisit((AdjacencyMatrixGraph<T>)graph, node, visit);
		}
		if(graph instanceof AdjacencyListGraph<?>)
		{
			DFSVisit((AdjacencyListGraph<T>)graph, node, visit);
		}
	
	}
	
	private static <T> void DFSVisit(
			AdjacencyListGraph<T> graph,
			GraphNode<T> node,
			Command<GraphNode<T>> visit)
	{
		DepthFirstSearch.time++;
		node.discoveryTime = DepthFirstSearch.time;
		
		if(node.state == VisitedState.DISCOVERED)
		{
			graph.SetType(GraphType.CYCLIC);
		}
		else
		{
			node.state = VisitedState.DISCOVERED;
		}

		visit.Run(node);;
		
		GraphNode<T> current = node.adjList.head.data;
		while(current != null)
		{
			if(current.state == VisitedState.UNDISCOVERED)
			{
				current.predecessor = node;
				DFSVisit(graph, current, visit);
			}
		}
		
		DepthFirstSearch.time++;
		node.finishTime = DepthFirstSearch.time;
		node.state = VisitedState.VISITED;
	
	}
	
	private static <T> void DFSVisit(
			AdjacencyMatrixGraph<T> graph,
			GraphNode<T> node,
			Command<GraphNode<T>> visit)
	{
		DepthFirstSearch.time++;
		node.discoveryTime = DepthFirstSearch.time;
		
		if(node.state == VisitedState.DISCOVERED)
		{
			graph.SetType(GraphType.CYCLIC);
		}
		else
		{
			node.state = VisitedState.DISCOVERED;
		}

		visit.Run(node);;
		
		for(int i = 0; i < graph.edges.length; i++)
		{
			if(i != node.vertex && graph.edges[node.vertex][i] == true)
			{
				GraphNode<T> current = graph.GetVertices()[i];
				if(current.state == VisitedState.UNDISCOVERED)
				{
					current.predecessor = node;
					DFSVisit(graph, current, visit);
				}
			}
		}
		
		DepthFirstSearch.time++;
		node.finishTime = DepthFirstSearch.time;
		node.state = VisitedState.VISITED;
	}
}
