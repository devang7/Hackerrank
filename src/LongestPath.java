import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LongestPath {
	
	
 	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		//int q = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int adj[][] = new int[n][n];
		for(int i = 0; i < m; i++)
		{
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			adj[a-1][b-1] = 1;
			adj[b-1][a-1] = 1;
		}
		LongestPath p = new LongestPath();
		int visited[] = new int[n];
		//ArrayList<Integer> t = p.longestPath(visited, adj, 0, n);
		int max = 0;
		ArrayList<Integer> max_a = null;
		for(int i = 0; i < n; i++)
		{
			System.out.println("for source:"+i);
			visited = new int[n];
			ArrayList<Integer> t = p.longestPath(visited, adj, i, n);
			System.out.println(t);
			if(t.size() > max)
			{
				max = t.size();
				max_a = t;
			}
		}
		System.out.println(max_a.size());
		for(int i = 0; i < max_a.size(); i++)
		{
			System.out.print(max_a.get(i)+1+" ");
		}
		
		//System.out.println(n);
		//p.dfs(visited, adj, 0, n);
	}
	public ArrayList<Integer> longestPath(int visited[],int adj[][],int source,int n)
	{
		ArrayList<Integer> br = new ArrayList<Integer>();
		//System.out.println(source);
		br.add(source);
		//System.out.println("br"+br);
		visited[source] = 1;
		int max = 1;
		for(int i = 0; i < n; i++)
		{
			int c = 0;
			ArrayList<Integer> cb = null;
			if(adj[source][i] == 1 && visited[i] != 1)
			{
				cb = longestPath(visited,adj,i,n);
				//System.out.println("cb:"+cb);
				c = 1 + cb.size();
			}
			if(cb != null && c > max)
			{
				for(int j = 0; j < cb.size(); j++)
				{
					br.add(cb.get(j));
				}
				max = c;
			}
				
		}
		//System.out.println("return:"+br);
		return br;
	}
	public void dfs(int visited[],int adj[][],int source,int n)
	{
		visited[source] = 1;
		System.out.print(source+1+" ");
		for(int i = 0; i < n; i++)
		{
			if(adj[source][i] == 1 && visited[i] != 1)
			{
				dfs(visited,adj,i,n);
			}
		}
	}

}
