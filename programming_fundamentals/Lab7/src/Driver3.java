


public class Driver3 {
	
	public class StackArray<T> implements Stack<T> 
	{
	    private T[] arr;
	    private int total;

	    public StackArray()
	    {
	        arr = (T[]) new Object[2];
	    }

	    private void resize(int capacity)
	    {
	        T[] tmp = (T[]) new Object[capacity];
	        System.arraycopy(arr, 0, tmp, 0, total);
	        arr = tmp;
	    }

	    public StackArray<T> push(T ele)
	    {
	        if (arr.length == total) resize(arr.length * 2);
	        arr[total++] = ele;
	        return this;
	    }

	    public T pop()
	    {
	        if (total == 0) throw new java.util.NoSuchElementException();
	        T ele = arr[--total];
	        arr[total] = null;
	        if (total > 0 && total == arr.length / 4) resize(arr.length / 2);
	        return ele;
	    }

	    @Override
	    public String toString()
	    {
	        return java.util.Arrays.toString(arr);
	    }

	}

	public static void main(String[] args) 
	{
		StackArray Astack = new StackArray();
		Astack.push(1);
		Astack.push(7);
		Astack.push(3);
		Astack.push(4);
		Astack.push(9);
		Astack.push(2);
		System.out.println("Pushed elements into Array stack: " + Astack.push());
		
		

	}

}
