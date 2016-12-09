import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		while(q != 0)
		{
			String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int e = Integer.parseInt(s[1]);
			int fin[] = new int[n];
			Arrays.fill(fin, -1);
			int ver[][] = new int[n][n];
			ShortestPath su = new ShortestPath();
			for(int i = 0; i < e; i++)
			{
				String si[] = br.readLine().split(" ");
				int from = Integer.parseInt(si[0]);
				int to = Integer.parseInt(si[1]);
				ver = su.makeGraph(ver, to-1, from-1);
				ver = su.makeGraph(ver, from - 1, to -1);
			}
			//su.printll(ver);
			int start = Integer.parseInt(br.readLine().trim());
			int depth[] = new int[n];
			fin[start - 1] = 0;
			fin = su.bfs(ver, fin,start-1,depth);
			//System.out.println(Arrays.toString(fin));
			for(int i = 0; i < fin.length; i++)
			{
				if(i != (start-1))
				{
					System.out.print(fin[i]+" ");
				}
			}
			System.out.println();
			q--;
		}
	}
	public int[] bfs(int v[][],int f[],int start,int depth[])
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		depth[start] = 0;
		int count = 0;
		while(q.peek() != null)
		{
			int i = q.poll();
			//System.out.println("Pop out:"+i);
			f[i] = depth[i]*6;
			//push unvisited children
			for(int j = 0; j < f.length; j++)
			{
				if(v[i][j] != 0)
				{
					if(f[j] == -1) //unvisited
					{
						f[j] = 0;  //mark visited
						depth[j] = depth[i]+1;
						q.add(j);
					}
				}
				
			}
			
		}
		return f;
	}
	/*public void printll(Vertex v[])
	{
		for(int i = 0; i < v.length; i++)
		{
			Vertex e = v[i];
			System.out.print(i + "->");
			while(e != null)
			{
				System.out.print(e.a+"->");
				e = e.next;
			}
			System.out.println();
		}
	}*/
	public int[][] makeGraph(int a[][],int to,int from)
	{
		a[to][from] = 1;
		return a;
	}

}
