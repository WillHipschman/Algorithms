package datastructures.graph;

public class AdjacencyMatrixGraph<T> implements Graph<T>{
	
	public boolean[][] edges;
	
	private GraphNode<T>[] vertices;
	private GraphType type = GraphType.UNKNOWN;
	
	// We assume edges is a square matrix
	public AdjacencyMatrixGraph(GraphNode<T>[] vertices, boolean[][] edges)
	{
		this.vertices = vertices;
		this.edges = edges;
	}
	
	public GraphNode<T>[] GetVertices()
	{
		return vertices;
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
		
		return edges[u][v];
	}
}
