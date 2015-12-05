package data;

public class DisjointSetForest<T> {
	
	public DisjointSet<T> MakeSet(T val)
	{
		return new DisjointSet<T>(val);
	}
	
	public DisjointSet<T> FindSet(DisjointSet<T> val)
	{
		if(val.parent != val)
		{
			return FindSet(val.parent);
		}
		
		return val;
	}
	
	public void Union(DisjointSet<T> val1, DisjointSet<T> val2)
	{
		Link(this.FindSet(val1), this.FindSet(val2));
	}
	
	private void Link(DisjointSet<T> val1, DisjointSet<T> val2)
	{
		
	}
}
