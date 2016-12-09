import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ProgCount {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		HashMap<Integer,ArrayList<Integer>> hs = new HashMap<Integer,ArrayList<Integer>>();
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(br.readLine());
			if(!hs.containsKey(a[i]))
			{
				ArrayList<Integer> pos = new ArrayList<Integer>();
				pos.add(i);
				hs.put(a[i], pos);
			}
			else
			{
				ArrayList<Integer> p = hs.get(a[i]);
				p.add(i);
			}
		}
		
	}
}
