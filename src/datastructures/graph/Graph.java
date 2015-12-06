package datastructures.graph;

public interface Graph<T> {
	
	public GraphNode<T>[] GetVertices();
	
	public GraphType GetType();
	public void SetType(GraphType type);
	
	public boolean IsEdge(int u, int v);
	
}
