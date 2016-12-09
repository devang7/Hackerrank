import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class EqualStacks {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n1 = Integer.parseInt(s[0]);
		int n2 = Integer.parseInt(s[1]);
		int n3 = Integer.parseInt(s[2]);
		int s1[] = new int[n1];
		int s2[] = new int[n2];
		int s3[] = new int[n3];
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		String si[] = br.readLine().split(" ");
		Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
		Hashtable<Integer,Integer> hb = new Hashtable<Integer,Integer>();
 		ArrayList<Integer> a = new ArrayList<Integer>();
	//	ArrayList<Integer> a13 = new ArrayList<Integer>();
	//	ArrayList<Integer> a23 = new ArrayList<Integer>();
  		int c = 0;
 		int d = 0;
		for(int i = si.length-1; i >= 0; i--)
		{
			s1[i] = Integer.parseInt(si[i]);
			sum1 += s1[i];
			hs.put(sum1, c++);
			
		}
		//System.out.println(hs.toString());
		//System.out.println(hs.toString());
		String st[] = br.readLine().split(" ");
		for(int i = st.length - 1; i >= 0; i--)
		{
			s2[i] = Integer.parseInt(st[i]);
			sum2 += s2[i];
			hb.put(sum2, d++);
			
		}
		//System.out.println(hb.toString());
		String sh[] = br.readLine().split(" ");
		int i;
		for(i = sh.length - 1; i >= 0; i--)
		{
			s3[i] = Integer.parseInt(sh[i]);
			sum3 += s3[i];
			if(hs.get(sum3) != null && hb.get(sum3) != null)
			{
				a.add(sum3);
			}
			
		}
		if(a.size() == 0)
			System.out.println("0");
		else
		{
			System.out.println(a.get(a.size()-1));
		}
		//System.out.println(Arrays.toString(a12.toArray()));
		
	}
}
