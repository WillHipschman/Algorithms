package data;

public class AdjacencyListGraph<T> implements Graph<T>{

	public GraphNode<T>[] nodes;
	
	public AdjacencyListGraph(GraphNode<T>[] nodes)
	{
		this.nodes = nodes;
	}
	
	//O(E) = O(V^2)
	public boolean IsEdge(int u, int v)
	{
		if(nodes.length < u)
		{
			return false;
		}
		
		GraphNode<T> current = nodes[u];
		
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
