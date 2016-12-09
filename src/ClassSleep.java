import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class ClassSleep {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
		String t = br.readLine();
		int count = 0;
		for(int i = 0; i < t.length(); i++)
		{
			char x = t.charAt(i);
			if(x == '0')
			{
				hs.put(i+1, count++);
			}
		}
		String y[] = br.readLine().split(" ");
		int i;
		for(i = 0; i < k; i++)
		{
			if(hs.containsKey(Integer.parseInt(y[i])))
			{
				break;
			}
		}
		if(i == k)
		{
			System.out.println("NO");
		}
		else
		{
			System.out.println("YES");
		}
	}
		
	
}
