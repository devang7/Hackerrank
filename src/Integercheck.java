import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Integercheck {
	
	public static void main(String args[]) throws Exception
	{
		Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
		int a[] = new int[]{2,2,2,1,0,4,6,5,3,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2};
		//int max = 0;
		//int value = a[0];
		for(int i = 0; i < a.length; i++)
		{
			if(hs.containsKey(a[i]))
			{
				int k = hs.get(a[i]);
				//hs.remove(a[i]);
				hs.put(a[i], k+1);
				System.out.println(hs.toString());
			}
			else
			{
				hs.put(a[i], 1);
				System.out.println(hs.toString());
			}
		}
		System.out.println(hs.toString());
		Enumeration<Integer> e = hs.elements();
		int max = Integer.MIN_VALUE;
		int pos = 0;
		int j = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(e.hasMoreElements())
		{
			int i = e.nextElement();
			j++;
			if(max <= i)
			{
				if(max == i)
				{
					arr.add(j);
				}
				max = i;
				pos = j;
			}
		}
		//System.out.println(j);
		Enumeration<Integer> h = hs.keys();
		int c = 0;
		while(h.hasMoreElements())
		{
			int i = h.nextElement();
			c++;
			if(c == pos)
			{
				System.out.println(i);
				break;
			}
		}
		
		
	}

}
