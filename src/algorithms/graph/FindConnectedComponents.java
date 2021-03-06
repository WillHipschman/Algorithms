package algorithms.graph;

import datastructures.graph.AdjacencyMatrixGraph;
import datastructures.graph.Vertex;
import datastructures.set.DisjointSet;
import datastructures.set.DisjointSetForest;

public class FindConnectedComponents {

	//O(N^2)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> DisjointSetForest<Vertex<T>> ConnectedComponent(AdjacencyMatrixGraph<T> g)
	{
		DisjointSetForest<Vertex<T>> set = new DisjointSetForest<Vertex<T>>();
		DisjointSet[] sets = new DisjointSet[g.GetVertices().length];
		
		for(int i = 0; i < g.GetVertices().length; i++)
		{
			sets[i] = set.MakeSet(g.GetVertices()[i]);
		}
		
		for(int i = 0; i < g.GetVertices().length; i++)
		{
			for(int j =0; j < g.GetVertices().length; j++)
			{
				if(i != j && g.IsEdge(i,j))
				{
					DisjointSet<Vertex<T>> set1 = set.FindSet(sets[i]);
					DisjointSet<Vertex<T>> set2 = set.FindSet(sets[j]);
					
					if(FindConnectedComponents.SameComponent(set, set1, set2));
					{
						set.Union(set1, set2);
					}
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
