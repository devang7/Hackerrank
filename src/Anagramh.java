import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Anagramh {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			String s = br.readLine();
			if(s.length() % 2 != 0)
			{
				System.out.println("-1");
			}
			else
			{
				Hashtable<Character,Integer> hs = new Hashtable<Character,Integer>();
				String s1 = s.substring(0, s.length()/2);
				String s2 = s.substring(s.length()/2);
				//System.out.println(s1);
				char a[] = s1.toCharArray();
				for(int i = 0; i < s1.length(); i++)
				{
					if(!hs.containsKey(a[i]))
					{
						hs.put(a[i], 1);
					}
					else
					{
						int count = hs.get(a[i]);
						hs.put(a[i], count+1);
					}
				}
				//System.out.println(hs.toString());
				//System.out.println(s2);
				char a2[] = s2.toCharArray();
				int g = 0;
				for(int i = 0; i < a2.length; i++)
				{
					if(hs.containsKey(a2[i]))
					{
						int c = hs.get(a2[i]);
						if(c == 1)
							hs.remove(a2[i]);
						else
							hs.put(a[i], c - 1);
					}
					else
					{
						g++;
					}
				}
				System.out.println(g);
			}
			t--;
		}
	}

}
