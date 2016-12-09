import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FunnyString {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			char a[] = br.readLine().toCharArray();
			int i = 0,j = 0;
			for(i = 0, j = a.length - 1; i < a.length-1; i++, j--)
			{
				if(Math.abs(a[i+1] - a[i]) != Math.abs(a[j]-a[j-1]))
				{
					break;
				}
			}
			if(i >= a.length - 1)
			{
				System.out.println("Funny");
			}
			else
			{
				System.out.println("Not Funny");
			}
			t--;
		}
	}

}
