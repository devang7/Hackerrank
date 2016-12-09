import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Nikita {
	
	int arr[];
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			String s[] = br.readLine().split(" ");
			for(int i = 0; i < n; i++)
			{
				a[i] = Integer.parseInt(s[i]);
			}
			Nikita ni = new Nikita();
			ni.setArr(a);
			int start = 0;
			int end = n - 1;
			System.out.println(ni.solution(start,end));
			//System.out.println(Arrays.toString(temp));
			t--;
		}
			//System.out.println(count);
			 
			
	}
	public void setArr(int a[])
	{
		arr = a;
	}
	public int solution(int start,int end)
	{
	//	System.out.println("st:"+start+"end:"+end);
		int j = findSplit(start,end);
		
		if(j == end)
			return 0;
		else
		{
			return (Math.max(solution(start,j), solution(j+1,end)) + 1);
		}
	}
	public int findSplit(int start,int end)
	{
		int ti[] = new int[end-start+1];
		int e = end;
		ti[ti.length - 1] = arr[e];
		for(int i = ti.length - 2; i >= 0; i--)
		{
			ti[i] = ti[i+1] + arr[--e];
		}
		//System.out.println(Arrays.toString(ti));
		int j = start;
		int sum = arr[j];
		int t = 1;
		while(j < end)
		{
			if(sum == ti[t++])
				return j;
			sum += arr[j+1];
			j++;
		}
		return j;
	}
		
}


