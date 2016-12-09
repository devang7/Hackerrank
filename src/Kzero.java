import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Kzero {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int t = Integer.parseInt(s[1]);
		String si[] = br.readLine().split(" ");
		int arr[] = new int[n];
		int zero[] = new int[n];
		Arrays.fill(zero, 999999);
		Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
		//Hashtable<Integer,Integer> hb = new Hashtable<Integer,Integer>();
		//ArrayList<Integer> a = new ArrayList<Integer>();
		int count = 0;
		int counter = 0;
		for(int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(si[i]);
			if(arr[i] == 0)
			{
				hs.put(i, counter++);
				zero[count++] = i;
				//hb.put(count, i);
			}
		}
		//System.out.println(Arrays.toString(zero));
		//Integer ar[] = new Integer[n];
		while(t != 0)
		{
			
			String sp[] = br.readLine().split(" ");
			int type = Integer.parseInt(sp[0]);
			if(type == 1)
			{
				int k = Integer.parseInt(sp[1]);
				k = k-1;
				if(zero[k] != 999999)
				{
					System.out.println(zero[k]);
				}
				else
				{
					System.out.println("NO");
				}
				
			}
			else
			{
				int index = Integer.parseInt(sp[1]);
				int value = Integer.parseInt(sp[2]);
				//System.out.println(index);
				//System.out.println(hs.get(index));
				if(hs.get(index) != null && value != 0) //replace zero by other value
				{
					hs.remove(index);
					int i = Arrays.binarySearch(zero, 0, count, index);
					zero[i] = 999999;
					Arrays.sort(zero);
					count -= 1;
					
				}
				else if(hs.get(index) == null && value == 0) //adds zero
				{
					hs.remove(index);
					hs.put(index, counter);
					zero[count] = index;
					Arrays.sort(zero);
					count = count + 1;
				}
				else if(hs.get(index) != null && value != 0) //remove
				{
					hs.remove(index);
					int i = Arrays.binarySearch(zero, 0, count, index);
					zero[i] = 999999;
					Arrays.sort(zero);
					count -= 1;
				}
				//System.out.println(hs.toString());
				//System.out.println(Arrays.toString(zero));
			}
			t--;
		}
	}

}
