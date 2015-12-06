package datastructures.list;

public class Stack<T> {

	private int top = -1;
	private T[] stack;
	
	
	public Stack(T[] stack)
	{
		this.stack = stack;
	}
	
	//O(1) or O(n) if we have to grow the array
	public void Push(T val)
	{
		top++;
		stack[top] = val;
	}
	
	//O(1)
	public T Pop()
	{
		T val = stack[top];
		top--;
		return val;
	}
	
	public int Count()
	{
		return top + 1;
	}
}
