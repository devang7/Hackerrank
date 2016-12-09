import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chess {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		while(g != 0)
		{
			String s[] = br.readLine().split(" ");
			int w = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int m = Integer.parseInt(s[2]);
			int a[][] = new int[4][4];
			Chess k = new Chess();
			for(int l = 0; l < w; l++)
			{
				s = br.readLine().split(" ");
				int i = Integer.parseInt(s[2])-1;
				int j = s[1].charAt(0) - 65;
				a = k.getPos(a, s[0], i, j);
			}
			g--;
		}
	}
	public int[][] getPos(int a[][],String t, int i, int j)
	{
		if(t.equals("Q"))
		{
			int temp = j;
			while(temp < 4)
			{
				a[i][temp] = 1;
				temp = temp + 1;
			}
			temp = j;
			while(temp >= 0)
			{
				a[i][temp] = 1;
				temp = temp - 1;
			}
		}
		if(t.equals("N"))
		{
			
		}
		if(t.equals("B"))
		{
			
		}
		if(t.equals("R"))
		{
			
		}
		return a;
	}

}
