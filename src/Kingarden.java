import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kingarden {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split(" ");
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
		}
		int max = 0;
		int j = 0;
		int id = 0;
		while(j < a.length)
		{
			int min = n;
			int i = j;
			int count = 0;
			int c = 0;
			while(min != 0)
			{
				if(a[i] - c <= 0)
					count++;
				i = (i+1) % n;
				c++;
				min--;
			}
			if(count > max)
			{
				max = count;
				id = j;
			}
			j++;
		}
		System.out.println(id+1);
 	}

}
