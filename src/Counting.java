import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Counting {

	public static void main(String args[]) throws Exception
	{
		int a[] = {1,2,3,4,5,6,7,6,3,4,32,2};
		System.out.println(Counting.find(a,2));
		
	}
	public static int find(int numbers[],int k)
	{
		int count = 0;
		Arrays.sort(numbers);
		LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
		
		for(int i = 0; i < numbers.length; i++)
		{
			if(!hs.contains(numbers[i]))
				hs.add(numbers[i]);
		}
		System.out.println(hs.toString());
		Iterator<Integer> e = hs.iterator();
		while(e.hasNext())
		{
			int value = e.next();
			int diff = value+k;
			if(hs.contains(diff))
			{
				count++;
			}
		}
		
		
		return count;
	}
}
