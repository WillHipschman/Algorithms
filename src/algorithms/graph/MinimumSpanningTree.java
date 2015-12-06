package algorithms.graph;

import java.util.HashSet;

import algorithms.sorting.Sorting;
import datastructures.graph.Edge;
import datastructures.graph.Graph;
import datastructures.graph.Vertex;
import datastructures.set.DisjointSet;
import datastructures.set.DisjointSetForest;

// assumes connected undirected graph
public class MinimumSpanningTree {

	// O(ELogE) = O(V^2LogV)
	public static <T> HashSet<Edge> Kruskal(Graph<T> graph)
	{
		HashSet<Edge> mst = new HashSet<Edge>();
		DisjointSetForest<Vertex<T>> set = new DisjointSetForest<Vertex<T>>();
		@SuppressWarnings("unchecked")
		DisjointSet<Vertex<T>>[] sets = new DisjointSet[graph.GetVertices().length];
		
		// O(V)
		for(int i = 0; i < graph.GetVertices().length; i++)
		{
			DisjointSet<Vertex<T>> singleVertexSet = set.MakeSet(graph.GetVertices()[i]);
			sets[i] = singleVertexSet;
		}
		
		// O(ELogE) = O(V^2LogV)
		Edge[] edges =  new Edge[10];
		edges = graph.GetEdges().toArray(edges);
		Sorting.MergeSort(edges);
		
		//O(E) = O(V^2)
		for(int i = 0; i < edges.length; i++)
		{
			DisjointSet<Vertex<T>> set1 = sets[edges[i].Start.vertex];
			DisjointSet<Vertex<T>> set2 = sets[edges[i].End.vertex];
			
			if(set1 != set2)
			{
				mst.add(edges[i]);
				set.Union(set1, set2);
			}
		}
		
		return mst;
	}
}
