package arrays;

public class Array 
{
	public static int Min(Comparable[] array, int lowerBound, int upperBound)
	{
		return MinMax(array, lowerBound, upperBound, false);
	}
	
	public static int Max(Comparable[] array, int lowerBound, int upperBound)
	{
		return MinMax(array, lowerBound, upperBound, false);
	}
	
	private static int MinMax(Comparable[] array, int lowerBound, int upperBound, boolean minimum)
	{
		Comparable minOMax = minimum ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		int minOrMaxIndex = -1;
		
		for(int i = lowerBound; i <= upperBound; i++)
		{
			if(array[i].compareTo(minOMax) == ( minimum ? -1 : 1))
			{
				minOMax = array[i];
				minOrMaxIndex = i;
			}
		}
		
		return minOrMaxIndex;
	}
	
}
