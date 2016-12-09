import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class ArrayPer {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		int b[] = new int[n];
		Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
		String s[] = br.readLine().split(" ");
		for(int i = 0; i < a.length; i++)
		{
			hs.put(Integer.parseInt(s[i]), i);
		}
		String si[] = br.readLine().split(" ");
		int min = 999999;
		//int minindex = 0;
		int minvalue = 999999;
		for(int i = 0; i < b.length; i++)
		{
			b[i] = Integer.parseInt(si[i]);
			int k = Math.abs(hs.get(b[i]) - i);
			if(k < min)
			{
				min = k;
			//	minindex = i;
				minvalue = b[i];
			}
			else if(k == min && b[i] < minvalue)
			{
				min = k;
			//	minindex = i;
				minvalue = b[i];
			}
		}
		System.out.println(minvalue);
	}
}
