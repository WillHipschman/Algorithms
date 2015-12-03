package algorithms.array;

public class Array 
{
	///
	/// O(n)
	/// Returns the sum value of the maximum consecutive subarray
	/// that cross the midpoint of an array
	///
	private static int FindMaximumCrossingSubArray(int[] array)
	{
		int mid = array.length / 2;
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = mid; i >= 0; i--)
		{
			sum = sum + array[i];
			if(sum > leftSum)
			{
				leftSum = sum;
			}
		}
		
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		
		for(int i = mid + 1; i < array.length; i++)
		{
			sum = sum + array[i];
			if(sum > rightSum)
			{
				rightSum = sum;
			}
		}
		
		return leftSum + rightSum;
	}
	
	public static int Min(Comparable[] array, int lowerBound, int upperBound)
	{
		return MinMax(array, lowerBound, upperBound, false);
	}
	
	public static int Max(Comparable[] array, int lowerBound, int upperBound)
	{
		return MinMax(array, lowerBound, upperBound, false);
	}
	
	public static void Swap(Comparable[] array, int i, int j)
	{
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
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
