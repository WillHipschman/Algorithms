package datastructures.graph;

import java.util.ArrayList;

public class AdjacencyMatrixGraph<T> implements Graph<T>{
	
	public Integer[][] edges;
	
	private Vertex<T>[] vertices;
	private ArrayList<Edge> edgeList;
	private GraphType type = GraphType.UNKNOWN;
	
	// We assume edges is a square matrix
	public AdjacencyMatrixGraph(Vertex<T>[] vertices, Integer[][] edges)
	{
		this.vertices = vertices;
		this.edges = edges;
		
		this.SetupEdges();
	}
	
	public Vertex<T>[] GetVertices()
	{
		return vertices;
	}
	
	public ArrayList<Edge> GetEdges()
	{
		return edgeList;
	}
	
	public GraphType GetType()
	{
		return type;
	}
	
	public void SetType(GraphType type)
	{
		this.type = type;
	}
	
	// O(1)
	public boolean IsEdge(int u, int v)
	{
		if(edges.length < u)
		{
			return false;
		}
		
		return edges[u][v] != 0;
	}
	
	private void SetupEdges()
	{
		for(int i = 0; i < this.vertices.length; i++)
		{
			for(int j = 0; i < this.vertices.length; j++)
			{
				edgeList.add(new Edge(this.vertices[i].vertex, this.vertices[j].vertex, edges[i][j]));
			}
		}
	}
}
