package datastructures.graph;

import java.util.ArrayList;

public interface Graph<T> {
	
	public Vertex<T>[] GetVertices();
	public ArrayList<Edge> GetEdges();
	
	public GraphType GetType();
	public void SetType(GraphType type);
	
	public boolean IsEdge(int u, int v);
	
}
