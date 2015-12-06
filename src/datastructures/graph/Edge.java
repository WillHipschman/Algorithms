package datastructures.graph;

public class Edge implements Comparable<Edge>{

	public int Weight;
	public int Start;
	public int End;
	
	public Edge(int start, int end, int weight)
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
