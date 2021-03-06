package datastructures.graph;

import java.util.ArrayList;

public class AdjacencyListGraph<T> implements Graph<T>{

	private Vertex<T>[] vertices;
	private ArrayList<Edge> edges;
	private GraphType type = GraphType.UNKNOWN;
	
	public AdjacencyListGraph(Vertex<T>[] nodes)
	{
		this.vertices = nodes;
		this.SetupEdges();
	}
	
	public Vertex<T>[] GetVertices()
	{
		return vertices;
	}
	
	public ArrayList<Edge> GetEdges()
	{
		return edges;
	}
	
	public GraphType GetType()
	{
		return type;
	}
	
	public void SetType(GraphType type)
	{
		this.type = type;
	}
	
	//O(E) = O(V^2)
	public boolean IsEdge(int u, int v)
	{
		if(vertices.length < u)
		{
			return false;
		}
		
		Vertex<T> current = vertices[u];
		
		while(current != null)
		{
			if(current.vertex == v)
			{
				return true;
			}
		}
		
		return false;
	}
	
	private void SetupEdges()
	{
		for(int i = 0; i < this.vertices.length; i++)
		{
			Vertex<T> vertex = this.vertices[i];
			
			for(Integer key : vertex.adjMap.keySet())
			{
				edges.add(new Edge(vertex.vertex, vertex.adjMap.get(key), key));
			}
		}
	}
}
