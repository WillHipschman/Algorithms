package datastructures.graph;

public class AdjacencyListGraph<T> implements Graph<T>{

	private GraphNode<T>[] vertices;
	private GraphType type = GraphType.UNKNOWN;
	
	public AdjacencyListGraph(GraphNode<T>[] nodes)
	{
		this.vertices = nodes;
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
	
	//O(E) = O(V^2)
	public boolean IsEdge(int u, int v)
	{
		if(vertices.length < u)
		{
			return false;
		}
		
		GraphNode<T> current = vertices[u];
		
		while(current != null)
		{
			if(current.vertex == v)
			{
				return true;
			}
		}
		
		return false;
	}
}
