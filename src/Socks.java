import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;

public class Socks {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
		String s[] = br.readLine().split(" ");
		//int count = 0;
		//int flag = 0;
		int counter = 0;
		for(int i = 0; i < n; i++)
		{
			int a = Integer.parseInt(s[i]);
			if(!hs.containsKey(a))
			{
				hs.put(a, 1);
			}
			else 
			{
				int c = hs.get(a);
				hs.remove(a);
				hs.put(a, c+1);
			}
		}
		//System.out.println(hs.toString());
		Enumeration<Integer> e = hs.elements();
		while(e.hasMoreElements())
		{
			int x = e.nextElement();
			//System.out.println(x);
			counter += x/2;
		}
		System.out.println(counter);
	}
}
