import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BabySteps {
	
	long mem[];
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		BabySteps ba = new BabySteps();
		while(q != 0)
		{
			String s[] = br.readLine().split(" ");
			int current = 0;
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			ba.initialize(b);
			//System.out.println(ba.findMin(a,b,d,current));
			ba.finditer(a, b, d);
			System.out.println(ba.getmem());
			q--;
		}
	}
	public long getmem()
	{
		return mem[1];
	}
	public void initialize(int b)
	{
		mem = new long[2*b+1];
		Arrays.fill(mem,Integer.MAX_VALUE);
	}
	public int findMin(int a,int b,int d,int current)
	{
		//System.out.println(Arrays.toString(mem));
		/*if(current != 0 && mem[current] > 0)
		{
			return mem[current];
		}*/
		if(current == d)
		{
			//mem[current] = 0;
			return 0;
		}
		if(d - a == 0)
		{
			mem[current] = 1;
			return 1;
		}
		else if(d - b == 0)
		{
			mem[current] = 1;
			return 1;
		}
		else if((d - current) < 2*b)
		{
			mem[current] = 2;
			return 2;
		}
		else if((d - current) < 2*a)
		{
			mem[current] = 2;
			return 2;
		}
		else if((d-current) < (a+b))
		{
			mem[current] = 2;
			return 2;
		}
		else
		{
			int k = Math.min(findMin(a,b,d,current+a) + 1, findMin(a,b,d,current+b) + 1);
			//System.out.println(k);
			mem[current] = k;
			return k;
		}
	
	}
	public void finditer(int a,int b,int d)
	{
		int current = d;
		mem[2*b] = 0;
		int flag = 0;
		while(current >= 2*b)
		{
			flag = 1;
			int length = mem.length-1;
			if(length-a >= 0)
			{
				mem[length-a] = Math.min(mem[length]+1, mem[length-a]);	
			}
			if(length-b >= 0)
			{
				mem[length-b] = Math.min(mem[length]+1, mem[length-b]);
			}
			if(length-(2*a) >= 0)
			{
				mem[length-2*a] = Math.min(mem[length]+2, mem[length-2*a]);
			}
			else
			{
				mem[0] = Math.min(mem[0],mem[length]+2);
			}
			if(length - (2*b) >= 0)
			{
				mem[length-2*b] = Math.min(mem[length]+2, mem[length-2*b]);
			}
			else
			{
				mem[0] = Math.min(mem[0],mem[length]+2);
			}
			if(length - (a+b) >= 0)
			{
				mem[length-(a+b)] = Math.min(mem[length]+2, mem[length-(a+b)]);
			}
			else
			{
				mem[0] = Math.min(mem[0], mem[length]+2);
			}
			//System.out.println(Arrays.toString(mem));
			long dummy[] = new long[2*b + 1];
			Arrays.fill(dummy,Integer.MAX_VALUE);
			for(int i = 2*b-1,j = 2*b; i >= 0; i--,j--)
			{
				dummy[j] = mem[i];
			}
			mem = dummy;
			//System.out.println(Arrays.toString(mem));
			current--;
		}
		//System.out.println(flag);
		if(flag == 0)
		{
			if(d == 0)
				mem[1] = 0;
			else
			{
				if(d-a == 0)
				{
					//System.out.println("IN");
					mem[1] = 1;
				}	
				else if(d-b == 0)
					mem[1] = 1;
				else
					mem[1] = 2;
			}
		}
		
			
			
	}

}
