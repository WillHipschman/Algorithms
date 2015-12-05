package data;

public class AdjacencyListGraph implements Graph{

	public GraphNode<Integer>[] adjList;
	
	public AdjacencyListGraph(GraphNode<Integer>[] adjList)
	{
		this.adjList = adjList;
	}
	
	public boolean IsEdge(int u, int v)
	{
		if(adjList.length < u)
		{
			return false;
		}
		
		GraphNode<Integer> current = adjList[u];
		
		while(current != null)
		{
			if(current.data == v)
			{
				return true;
			}
		}
		
		return false;
	}
}
