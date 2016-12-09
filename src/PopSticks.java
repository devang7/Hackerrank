import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PopSticks {
	
	int count = 0;
	int unique[] = new int[4001];
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int t = Integer.parseInt(br.readLine());
		PopSticks p = new PopSticks();
		/*for(int i = 2; i <= 8; i+=2)
		{ 
			int c = 0;
			int a[] = new int[4001];
			 p.Sticks(1, i-1);
			 c = (p.getCount()) % ((int)Math.pow(10, 9)+7);
			 p.updateU(i, c);
			 a[i] = a[i-2] + c;
			 p.resetCount();	
			 System.out.println(i);
		}*/
		p.updateU(2, 1);
		p.updateU(4, 2);
		p.updateU(6, 5);
		p.updateU(8, 14);
		p.updateU(10, 42);
		p.updateU(12, 132);
		p.updateU(14, 429);
		p.Sticks(1, 15);
		/*while(t != 0)
		{
			int n = Integer.parseInt(br.readLine());
			System.out.println(a[n] % ((int)Math.pow(10, 9)+7));
			t--;
		}*/
		//p.Sticks(1,19);
		System.out.println(p.getCount());

	}
	public void updateU(int i,int c)
	{
		unique[i] = c;
	}
	public void resetCount()
	{
		count = 0;
	}
	public int getCount()
	{
		return count;
	}
	public void Sticks(int l, int r)
	{
		System.out.println("l:"+l+" r:"+r);
		if(l == 0)
		{
			System.out.println("SAVE! r:"+r+" "+unique[r]);
			count += unique[r];
			return;
		}
		if(l == r)
		{
			count++;
			return;
		}
		else
		{
			if(l != r && l != 0)
			{
				Sticks(l+1,r-1);
				Sticks(l-1,r-1);
			}
			else
			{
				Sticks(l+1,r-1);
			}
		}
			
		
	}

}
