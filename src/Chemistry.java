import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Chemistry {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Hashtable<String,String[]> hs = new Hashtable<String,String[]>();
		int t = n;
		Chemistry c = new Chemistry();
		while(t != 0)
		{
			String s[] = br.readLine().split(" ");
			hs.put(s[0], c.make(s));
			t--;
		}
		String a[] = br.readLine().split(" ");
		int i;
		//System.out.println(hs.toString());
		for(i = 0; i < a.length; i++)
		{
			
			if(hs.containsKey(a[i]))
			{
				//System.out.println(a[i]+"i:"+i);
				String s[] = hs.get(a[i]);
				Hashtable<String,Integer> hb = new Hashtable<String,Integer>();
				for(int p = 0; p < s.length; p++)
				{
					hb.put(s[p], 1);
				}
				//System.out.println(s[0]);
				int k = 0;
				int j = 0;
				while(k < a.length && k != i)
				{
					//System.out.println(a[k]+" "+s[j]);
					if(hb.containsKey(a[k]))
					{
						j++;
					}
					k++;
				}
				//System.out.println(j);
				if(j != hb.size())
				{
					break;
				}
			}
		}
		if(i != a.length)
		{
			System.out.println("BOOM!");
		}
		else
		{
			System.out.println("SAFE!");
		}
		
	}
	public String[] make(String s[])
	{
		String[] temp = new String[s.length-2];
		int j = 0;
		for(int i = 2; i < s.length; i++)
		{
			temp[j++] = s[i];
		}
		
		return temp;
	}

}
