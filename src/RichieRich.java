import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RichieRich {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t[] = br.readLine().split(" ");
		int n = Integer.parseInt(t[0]);
		int k = Integer.parseInt(t[1]);
		String s = br.readLine();
		int a[] = new int[n];
		int in[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s.substring(i, i+1));
		}
		ArrayList<Integer> pos = new ArrayList<Integer>();
		RichieRich r = new RichieRich();
		for(int i = 0; i < n/2; i++)
		{
			if(a[i] != a[n-i-1])
			{
				pos.add(i);
				in[i]++;
				//add to arraylist
			}
		}
		//System.out.println(pos.toString());
		if(pos.size() > k)
		{
			System.out.println("-1");
		}
		else
		{
			//first do default changes. 
			for(int i = 0; i < pos.size(); i++)
			{
				int j =  pos.get(i);
				if(r.MaxPos(a, j))
				{
					a[n-j-1] = a[j];
				}
				else
				{
					a[j] = a[n-j-1];
				}
				k--;
			}
			/*for(int i = 0; i < n; i++)
			{
				System.out.print(a[i]);
			}
			System.out.println();
			System.out.println(k);*/
			if(k > 0) //additional changes
			{
				//System.out.println(k);
				int j = 0;
				while(j < n && k != 0)
				{
					int ch = j;
					//System.out.println("ch:"+ch);
					if(!r.isIn(in,ch) && k >= 2)
					{
						if(a[ch] != 9)
						{
							a[ch] = 9;
							a[n-ch-1] = 9;
							k-=2;
						}
					}
					if(r.isIn(in,ch) && k >= 1)
					{
						if(a[ch] != 9)
						{
							a[ch] = 9;
							a[n-ch-1] = 9;
							k--;
						}
					}
					//System.out.println("k:"+k);
					j++;
				
				}	
				//System.out.println(k);
				int last = 0;
				if(pos.size() != 0)
					last = pos.get(pos.size() - 1);
				while(last < n && k >= 2)
				{
				//	System.out.println(last);
					//System.out.println(a[last]);
					if(a[last] != 9)
					{
						a[last] = 9;
						a[n-last-1] = 9;
						last++;
						k = k - 2;
					}
					//System.out.println(k);
					last++;
					//System.out.println(last);
					
				}
				if(n % 2 != 0 && k >= 1)
				{
					a[n/2] = 9;
				}
			}
			for(int i = 0; i < n; i++)
			{
				System.out.print(a[i]);
			}
				
		}
		
	}
	public boolean isIn(int pos[],int j)
	{
		if(pos[j] == 1)
			return true;
		return false;
	}
	public boolean MaxPos(int a[], int i)
	{
		if(a[i] > a[a.length-i-1])
				return true;
		else
			return false;
	}
}
