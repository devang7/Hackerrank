import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;

public class Anagram {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int t = n;
		int counter = 0;
		int c[][] = new int[n][1];
		int j = 0;
		while(t != 0)
		{
			int d[] = new int[26];
			char a[] = br.readLine().toLowerCase().toCharArray();
		//	System.out.println(Arrays.toString(a));
			for(int i = 0; i < a.length; i++)
			{
				d[a[i] - 97]++;
			}
			c[j++] = d;
			t--;
		}
		Anagram g = new Anagram();
		Hashtable<int[],Integer> hs = new Hashtable<int[],Integer>();
		for(int i = 0; i < n; i++)
		{
			int a[] = c[i];
			for(int k = i + 1; k < n; k++)
			{
				if(g.same(a, c[k]) && !hs.containsKey(c[k]))
				{
					hs.put(a, 1);
					hs.put(c[k], 1);
				}
					
			}
		}
		System.out.println(hs.size());
	}
	public boolean same(int a[],int b[])
	{
		int i = 0;
		for(i = 0; i < a.length; i++)
		{
			if(a[i] != b[i])
				break;
		}
		if(i == a.length)
			return true;
		return false;
	}

}
