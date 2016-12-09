import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoinChange {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int amt = Integer.parseInt(s[0]);
		int n = Integer.parseInt(s[1]);
		int a[] = new int[n];
		s = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
		}
		long mem[][] = new long[n][amt+1];
		for(int i = 0; i < n; i++)
		{
			mem[i][0] = 1; //amt = 0;
		}
		for(int j = 1; j < amt+1; j++)
		{
			if(j % a[0] == 0)
			{
				mem[0][j] = 1;
			}
			else
			{
				mem[0][j] = 0;
			}
		}
		for(int i = 1; i < n; i++)
		{
			for(int j = 1; j < amt+1; j++)
			{
				try{
					mem[i][j] = mem[i][j-a[i]]+ mem[i-1][j];
					//System.out.println("+1 for amt:"+(a[i]));
				}
				catch(Exception e){
					//System.out.println(e);
					mem[i][j] = mem[i-1][j];
				}
				
			}
		}
		/*for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < amt+1; j++)
			{
				System.out.print(mem[i][j]+" ");
			}
			System.out.println();
		}*/
		System.out.println(mem[n-1][amt]);
		
	}
}
