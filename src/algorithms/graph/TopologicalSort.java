package algorithms.graph;

import datastructures.graph.Graph;
import datastructures.graph.GraphNode;
import datastructures.list.LinkedList;
import util.commands.AddToFrontOfList;
import util.commands.NoOp;

public class TopologicalSort {

	public static <T> LinkedList<GraphNode<T>> TopoSort(Graph<T> graph)
	{
		AddToFrontOfList<GraphNode<T>> finishAction = new AddToFrontOfList<GraphNode<T>>();
		DepthFirstSearch.DFS(graph, new NoOp<GraphNode<T>>(), new NoOp<GraphNode<T>>(), finishAction);
		return finishAction.List;
	}
}
