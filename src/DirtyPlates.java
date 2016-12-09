import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DirtyPlates {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int p[] = new int[n];
		int d[] = new int[n];
		String x[] = br.readLine().split(" ");
		String y[] = br.readLine().split(" ");
		Comparator<Index> cost = new CostCompare();
		PriorityQueue<Index> pq = new PriorityQueue<Index>(10,cost);
		for(int i = 0; i < n; i++)
		{
			p[i] = Integer.parseInt(x[i]);
			d[i] = Integer.parseInt(y[i]);
			Index temp = new Index(i,d[i]);
			pq.add(temp);
		}
		int count = 0;
		int total = 0;
		while(count != k && !pq.isEmpty())
		{
			count++;
			total += p[pq.remove().i];	
			System.out.println(total);
		}
		while(!pq.isEmpty())
		{
			total -= pq.remove().value;
		}
		if(total < 0)
		{
			System.out.println(0);
		}
		else
		{
			System.out.println(total);
		}
	}

}
class CostCompare implements Comparator<Index>
{
	public int compare(Index x, Index y)
	{
		if(x.value < y.value)
		{
			return 1;
		}
		else if(x.value > y.value)
			return -1;
		return 0;
	}
}
class Index
{
	Index(int ind,int va)
	{
		 i = ind;
		 value = va;
	}
	int i;
	int value;
}
