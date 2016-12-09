import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Radio {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int house[] = new int[100002];
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
			house[a[i]]++;
		}
		int start = 1;
		Radio r = new Radio();
		int i = 0;
		int count = 0;
		while((i = r.firstindex(house, start)) != -1)
		{
			int pr = r.putradio(house, i+k);
			if(pr != -1)
			{
				count++;
				start = pr+k+1;
			}
		}
		System.out.println(count);
		
	}
	public int putradio(int house[],int end)
	{
		for(int i = end; i >= 0; i--)
		{
			if(i < house.length && house[i] >= 1)
				return i;
		}
		return -1;
	}
	public int firstindex(int house[],int start)
	{
		for(int i = start; i < house.length; i++)
		{
			if(house[i] >= 1)
				return i;
		}
		return -1;
	}

}
