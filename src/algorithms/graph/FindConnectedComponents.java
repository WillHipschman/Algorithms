package algorithms.graph;

import data.AdjacencyMatrixGraph;
import data.DisjointSet;
import data.DisjointSetForest;
import data.GraphNode;

public class FindConnectedComponents {

	//O(N^2)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> DisjointSetForest<GraphNode<T>> ConnectedComponent(AdjacencyMatrixGraph<T> g)
	{
		DisjointSetForest<GraphNode<T>> set = new DisjointSetForest<GraphNode<T>>();
		DisjointSet[] sets = new DisjointSet[g.nodes.length];
		
		for(int i = 0; i < g.nodes.length; i++)
		{
			sets[i] = set.MakeSet(g.nodes[i][i]);
		}
		
		for(int i = 0; i < g.nodes.length; i++)
		{
			for(int j =0; j < g.nodes.length; j++)
			{
				if(i == j)
				{
					continue;
				}
				
				DisjointSet<GraphNode<T>> set1 = set.FindSet(sets[i]);
				DisjointSet<GraphNode<T>> set2 = set.FindSet(sets[j]);
				
				if(FindConnectedComponents.SameComponent(set, set1, set2));
				{
					set.Union(set1, set2);
				}
			}
		}
		
		return set;
	}
	
	public static <T> boolean SameComponent(
			DisjointSetForest<T> set, 
			DisjointSet<T> u, 
			DisjointSet<T> v)
	{
		if(set.FindSet(u) == set.FindSet(v))
		{
			return true;
		}
		return false;
	}
}
