import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijktras {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		while(q != 0)
		{
			String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int e = Integer.parseInt(s[1]);
			long v[][] = new long[n][n];
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					v[i][j] = (long)Math.pow(10, 12);
				}
			}
			Dijktras d = new Dijktras();
			for(int i = 0; i < e; i++)
			{
				String si[] = br.readLine().split(" ");
				int to = Integer.parseInt(si[0]);
				int from = Integer.parseInt(si[1]);
				int w = Integer.parseInt(si[2]);
				d.makeGraph(v, to-1, from-1, w);
				d.makeGraph(v, from-1, to-1, w);
			}
			long fin[] = new long[n];
			Arrays.fill(fin, -1);
			int source = Integer.parseInt(br.readLine());
			fin = d.dij(v, fin,source-1);
			for(int i = 0; i < fin.length; i++)
			{
				if(i != source - 1 && i != n-1)
				{
					if(fin[i] < Math.pow(10, 12))
						System.out.print(fin[i]+" ");
					else 
						System.out.print(-1+" ");
				}
				if(i == n-1)
				{
					if(fin[i] < Math.pow(10, 12))
						System.out.print(fin[i]);
					else 
						System.out.print(-1);
				}
			}
			//System.out.println(Arrays.toString(fin));
			q--;
		}
	}
	public long[] dij(long v[][],long f[],int s)
	{
		int n = f.length;
		long max[] = new long[n];
		Arrays.fill(max, (long)Math.pow(10, 13));
		//System.out.println(Arrays.toString(max));
		max[s] = 0;
		Ni temp = new Ni(s,0);
		Comparator<Ni> cost = new costComp();
		PriorityQueue<Ni> pq = new PriorityQueue<Ni>(10,cost);
		pq.add(temp);
		//System.out.println(Arrays.toString(max));
		while(!pq.isEmpty() && !isVisited(f))
		{
			//System.out.println("In");
			Ni ti = pq.remove();
			int i = ti.vertex;
			f[i] = 1;
			long w = ti.value;
			for(int j = 0; j < n; j++)
			{
				if(v[i][j] != 0 && f[j] == -1 && (w + v[i][j]) < max[j])
				{
					temp = new Ni(j,(w+v[i][j]));
					pq.add(temp);
					max[j] = w+v[i][j];
				}
			}
		}	
		//System.out.println(Arrays.toString(max));
		return max;
	}
	public boolean isVisited(long a[])
	{
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == -1)
				return false;
		}
		return true;
	}
	public long[][] makeGraph(long a[][],int to,int from,int w)
	{
		if(a[to][from] > w)
		{
			a[to][from] = w;
			//System.out.println("Changed for:"+(to+1)+" "+(from+1));
		}
			
		return a;
	}
}
class costComp implements Comparator<Ni>
{
	public int compare(Ni a, Ni b)
	{
		if(a.value > b.value)
			return 1;
		else if(a.value < b.value)
			return -1;
		else
			return 1;
		
	}
}
class Ni
{
	Ni(int a,long b)
	{
		vertex = a;
		value = b;
	}
	int vertex;
	long value;
}
