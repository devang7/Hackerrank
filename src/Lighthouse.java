import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lighthouse {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char a[][] = new char[n][n];
		for(int i = 0; i < n; i++)
		{
			a[i] = br.readLine().toCharArray();
		}
		Lighthouse li = new Lighthouse();
		int radius = 0;
		for(int i = 1; i < n-1; i++)
		{
			for(int j = 1; j < n-1; j++)
			{
				if(a[i][j] == '.')
				{
					//System.out.println("Inside:"+i+","+j);
					int r = 0;
					//System.out.println("r:"+(j+r));
					int l = 0;
					int d = 0;
					int u = 0;
					int temp = 0;
					while((j+r+1) < n && a[i][j+r+1] != '*')
					{
						//System.out.println("In r:"+" "+i+","+(j+r+1));
						r++;
						
					}	
					while((j-l-1) >= 0 && a[i][j-l-1] != '*')
						l++;
					while((i+d+1) < n && a[i+d+1][j] != '*')
						d++;
					while((i-u-1) >= 0 && a[i-u-1][j] != '*')
						u++;
					temp = li.min(r,l,d,u);
					//System.out.println(r+" "+l+" "+d+" "+u);
					//System.out.println(temp);
					if(temp > 0)
					{
						int p = i;
						int q = j;
						int counter = -temp;
						int left = 0;
						int right = 0;
						//System.out.println("At:"+i+","+j);
						while(counter != temp)
						{
							int t = (int)Math.sqrt(Math.pow(temp,2) - Math.pow(counter,2));
							if(t == temp)
							{
								counter++;
								continue;
							}
							//go left;
							int c = 0;
							while(c != (t+1))
							{
								c++;
								if((q+c) < n && a[p+counter][q+c] != '.')
									break;
								
							}
							if(c == (t+1))
								left = 1;
							else
							{
								left = 0;
								break;
							}
							//go right
							c = 0;
							while(c != (t+1))
							{
								c++;
								if((q-c) >= 0 && a[p+counter][q-c] != '.')
									break;
							}
							if(c == (t+1))
								right = 1;
							else
							{
								right = 0;
								break;
							}
							counter++;
						}
						if(left == 1 && right == 1)
						{
							//System.out.println("In:"+i+" "+j);
							if(temp > radius)
								radius = temp;
						}
							
					}
				}
			}
		}
		//System.out.println(a[4]);
		System.out.println(radius);
	}
	public int min(int a,int b,int c,int d)
	{
		int min = 51;
		if(a < min)
			min = a;
		if(b < min)
			min = b;
		if(c < min)
			min = c;
		if(d < min)
			min = d;
		return min;
	}

}
