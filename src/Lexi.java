import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Lexi {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			String s = br.readLine(); 
			char a[] = s.toCharArray();
			ArrayList<Integer> mi = new ArrayList<Integer>();
			mi.add((int)a[a.length-1]);
			int i = a.length - 1;
			while(i > 0  && a[i] <= a[i-1])
			{
				mi.add((int)a[i-1]);
				i--;
			}
			if(i == 0)
			{
				System.out.println("no answer");
			}
			else
			{
				int temp = i-1;
				int j = 0;
				Iterator<Integer> p = mi.iterator();
				while(p.hasNext())
				{
					
					if(p.next() > (int)a[temp])
						break;
					j++;
				}
				char r = a[temp];
				int z = mi.get(j);
				a[temp] = (char)z;
				mi.set(j, (int) r);
				Collections.sort(mi);
				for(int q = 0, w = temp+1; q < mi.size(); q++,w++)
				{
					int b = mi.get(q);
					a[w] = (char)b;
				}
				
			}
			System.out.println(new String(a));
			t--;
		}
		
	}

}
