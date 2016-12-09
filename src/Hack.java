import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hack {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
		char a[] = s.toCharArray();
		int flag = 0;
		int j = 0;
		int i = 0;
		while(i < a.length)
		{
			
			if(flag == 0)
			{
				flag = 1;
				j = i + n - 1;
				int t = j;
				while(j < a.length && j >= i)
				{
					System.out.print(a[j]);
					j--;
				}
				if(j >= a.length)
				{
					j = a.length - 1;
					while(j >= i)
					{
						System.out.print(a[j]);
						j--;
					}
				}
				i = t + 1;
			}
			else
			{
				j = i;
				//System.out.println("j:"+j+"i+n:"+(i+n));
				while(j < a.length && j < i+n)
				{
					System.out.print(a[j]);
					j++;
				}
				i = j;
				//System.out.println(i);
				flag = 0;
				
			}
		}
	}

}
