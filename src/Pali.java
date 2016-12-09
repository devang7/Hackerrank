
	
	import java.util.*;
	
public class Pali {

	
	void getInput()
	{
		String input=new String("abaaa");
		String s=new String("abaaa");
		Hashtable<String, Integer> hs = new Hashtable<String, Integer>();
		int n = input.length();
		int r[][] = new int[2][n+1];
		
		s = "@" + s + "#";
		//System.out.println(s);
		for(int j = 0; j <= 1; j++)
		{
			int rp = 0;
			r[j][0] = 0;
			int i = 1;
			while(i <= n)
			{
				//System.out.println(s);
				//System.out.println("i:"+i+"j:"+j+"rp:"+rp);
				while(s.charAt(i-rp-1) == s.charAt(i+j+rp))
				{
					rp++;
				}
				r[j][i] = rp;
				int k = 1;
				while((r[j][i-k]) != rp - k && (k < rp))
				{
					r[j][i+k] = Math.min(r[j][i-k], rp - k);
					k++;
				}
				rp = Math.max(rp - k, 0);
				i += k;
			}
		}
		s = s.substring(1, n+1);
		//System.out.println(s);
		hs.put(Character.toString(s.charAt(0)), 1);
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j <= 1; j++)
			{
				for(int rp = r[j][i]; rp > 0; rp--)
				{
					hs.put(s.substring(i-rp-1,2*rp+j),1);
				}
				
			}
			hs.put(Character.toString(s.charAt(i)), 1);
			
		}
		Enumeration<Integer> e = hs.elements();
		int counter = 0;
		while(e.hasMoreElements())
		{
			counter++;
			e.nextElement();
		}
			System.out.println(counter);
		
		
		
	}
	
	public static void main(String args[])
	{
		Pali m=new Pali();
		m.getInput();
	}



	}



