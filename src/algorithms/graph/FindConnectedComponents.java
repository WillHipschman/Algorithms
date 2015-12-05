package algorithms.graph;

import data.AdjacencyMatrixGraph;
import data.DisjointSetForest;
import data.GraphNode;

public class FindConnectedComponents {

	//O(N^2)
	public static <T> DisjointSetForest<GraphNode<T>> ConnectedComponent(AdjacencyMatrixGraph<T> g)
	{
		DisjointSetForest<GraphNode<T>> set = new DisjointSetForest<GraphNode<T>>();
		
		for(int i =0; i < g.nodes.length; i++)
		{
			set.MakeSet(g.nodes[i][i]);
		}
		
		for(int i = 0; i < g.nodes.length; i++)
		{
			for(int j =0; j < g.nodes.length; j++)
			{
				if(i == j)
				{
					continue;
				}
				
				if(FindConnectedComponents.SameComponent(set, g.nodes[i][i], g.nodes[j][j]))
				{
					set.Union(g.nodes[i][i], g.nodes[j][j]);
				}
			}
		}
		
		return set;
	}
	
	public static <T> boolean SameComponent(DisjointSetForest<T> set, T u, T v)
	{
		if(set.FindSet(u) == set.FindSet(v))
		{
			return true;
		}
		return false;
	}
}
