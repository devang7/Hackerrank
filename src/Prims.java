import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int e = Integer.parseInt(s[1]);
		long v[][] = new long[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				v[i][j] = (long)Math.pow(10, 13);
			}
		}
		Prims d = new Prims();
		for(int i = 0; i < e; i++)
		{
			String si[] = br.readLine().split(" ");
			int to = Integer.parseInt(si[0]);
			int from = Integer.parseInt(si[1]);
			int w = Integer.parseInt(si[2]);
			v = d.makeGraph(v, to-1, from-1, w);
			v = d.makeGraph(v, from-1, to-1, w);
		}
		long fin[] = new long[n];
		Arrays.fill(fin, -1);
		int source = Integer.parseInt(br.readLine());
		fin[source-1] = 0;
		long ans = d.prim(v,fin,source-1);
		System.out.println(ans);
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
	public long prim(long v[][],long f[],int s)
	{
		long sum = 0;
		int n = f.length;
		Comparator<Nii> cost = new costComp1();
		PriorityQueue<Nii> pq = new PriorityQueue<Nii>(10,cost);
		Nii temp = new Nii(s,0);
		pq.add(temp);
		long max[] = new long[n];
		Arrays.fill(max, (long)Math.pow(10, 13));
		//System.out.println(Arrays.toString(max));
		max[s] = 0;
		while(!pq.isEmpty() && !isVisited(f))
		{
			Nii t = pq.remove();
			int i = t.vertex;
			long w = t.value;
			f[i] = 1;
			sum += w;
			//System.out.println("Added:"+w+"for:"+i);
			//System.out.println(Arrays.toString(f));
			for(int j = 0; j < n; j++)
			{
				//System.out.println(Arrays.toString(v[i]));
				//System.out.println(Arrays.toString(max));
				if(v[i][j] != (long)Math.pow(10, 13) && f[j] == -1 && v[i][j] < max[j])
				{
					
					//System.out.println("Adding in Queue:"+j+"value:"+max[j]);
					pq.add(new Nii(j,v[i][j]));
					max[j] = v[i][j];
				}
			}
		}
		return sum;
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

}
class costComp1 implements Comparator<Nii>
{
	public int compare(Nii a, Nii b)
	{
		if(a.value > b.value)
			return 1;
		else if(a.value < b.value)
			return -1;
		else
			return 1;
		
	}
}
class Nii
{
	Nii(int a,long b)
	{
		vertex = a;
		value = b;
	}
	int vertex;
	long value;
}

