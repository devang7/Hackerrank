import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Delivery {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int q = Integer.parseInt(s[2]);
		int[] type[] = new int[m][];
		for(int i = 0; i < m; i++)
		{
			s = br.readLine().split(" ");
			int arr[] = new int[Integer.parseInt(s[0])];
			for(int j = 0; j < arr.length; j++)
			{
				arr[j] = Integer.parseInt(s[j+1]);
			}
			type[i] = arr;
		}
		/*for(int i = 0; i < m; i++)
		{
			System.out.println(Arrays.toString(type[i]));
		}*/
		Delivery d = new Delivery();
	//	System.out.println(d.shortDist(12,4));
		int curr = 1;
		int minutes = 0;
		while(q != 0)
		{
			//System.out.println(q);
			s = br.readLine().split(" ");
			int foodt = Integer.parseInt(s[0]);
			int dest = Integer.parseInt(s[1]);
			int y[] = type[foodt -1];
			int rest = y[d.BestRest(curr, y,dest)];
			//System.out.println("Goto curr:"+curr+" rest:"+rest+" dest:"+dest);
			minutes += d.shortDist(curr, rest) + d.shortDist(rest, dest);
			curr = dest;
			//System.out.println(minutes);
			q--;
		}
		System.out.println(minutes);
		
	}
	public int BestRest(int current, int a[],int dest)
	{
		//System.out.println("In");
		//System.out.println(Arrays.toString(a));
		int min = shortDist(current,a[0]) + shortDist(a[0],dest);
		int min_index = 0;
		for(int i = 1; i < a.length; i++)
		{
			int c = shortDist(current,a[i])+shortDist(a[i],dest);
			
			if(c < min)
			{
		
			
					min_index = i;
					min = c;
				
			}
				
		}
		//System.out.println("bestrest:"+a[min]);
		return min_index;
	}
	public int shortDist(int c,int d)
	{
		//System.out.println("a "+a+"b "+b);
		int p1 = (int) (Math.log(c)/Math.log(2));
		int p2 = (int) (Math.log(d)/Math.log(2));
		HashSet<Integer> hs = new HashSet<Integer>();
		int p3 = 0;
		int a = Math.max(c, d);
		int b = Math.min(c, d);
		for(int i = a; i >= 1; i = i/2)
		{
			hs.add(i);
		}
		//System.out.println(hs.toString());
		for(int i = b; i >= 1; i = i/2)
		{
			
			if(hs.contains(i))
			{
				p3 = i;
				break;
			}
		}
		//System.out.println("CA:"+p3);
		return p1+p2-2*(int)(Math.log(p3)/Math.log(2));
	}

}
