package datastructures.set;

public class DisjointSetForest<T> {
	
	public DisjointSet<T> MakeSet(T val)
	{
		return new DisjointSet<T>(val);
	}
	
	public DisjointSet<T> FindSet(DisjointSet<T> val)
	{
		if(val.parent != val)
		{
			val.parent = FindSet(val.parent);
		}
		
		return val.parent;
	}
	
	public void Union(DisjointSet<T> val1, DisjointSet<T> val2)
	{
		Link(this.FindSet(val1), this.FindSet(val2));
	}
	
	private void Link(DisjointSet<T> val1, DisjointSet<T> val2)
	{
		if(val1.rank > val2.rank)
		{
			val2.parent = val1;
		}
		else
		{
			if(val1.rank == val2.rank)
			{
				val2.rank = val1.rank + 1;
			}
		}
	}
}
