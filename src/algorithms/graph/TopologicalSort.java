package algorithms.graph;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;
import datastructures.list.LinkedList;
import util.commands.AddToFrontOfList;
import util.commands.NoOp;

public class TopologicalSort {

	public static <T> LinkedList<Vertex<T>> TopoSort(Graph<T> graph)
	{
		AddToFrontOfList<Vertex<T>> finishAction = new AddToFrontOfList<Vertex<T>>();
		DepthFirstSearch.DFS(graph, new NoOp<Vertex<T>>(), new NoOp<Vertex<T>>(), finishAction);
		return finishAction.List;
	}
}
