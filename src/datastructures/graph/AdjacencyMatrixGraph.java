package datastructures.graph;

public class AdjacencyMatrixGraph<T> {
	
	public GraphNode<T>[][] nodes;
	
	public AdjacencyMatrixGraph(GraphNode<T>[][] nodes)
	{
		this.nodes = nodes;
	}
	
	// O(1)
	public boolean IsEdge(int u, int v)
	{
		if(nodes.length < u)
		{
			return false;
		}
		
		return nodes[u][v] != null;
	}
}
