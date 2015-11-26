package sorting;

public class SortingTests {

	
	public void VerifyInOrder(Comparable[] array)
	{
		for(int i = 0; i < array.length - 1; i++)
		{
			if(array[i].compareTo(array[i + 1]) == 1)
			{
				//fail
			}
		}
	}
}
