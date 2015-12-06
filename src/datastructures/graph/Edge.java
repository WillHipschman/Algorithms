package datastructures.graph;

@SuppressWarnings("rawtypes")
public class Edge implements Comparable<Edge>{

	public int Weight;
	public Vertex Start;
	public Vertex End;
	
	public Edge(Vertex start, Vertex end, int weight)
	{
		this.Weight = weight;
		this.Start = start;
		this.End = end;
	}
	
	@Override
	public int compareTo(Edge other) 
	{
		return this.Weight - other.Weight;
	}
}
