import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;

public class GemStones {
		public static void main(String args[]) throws Exception
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			Hashtable<Character,Integer> hs = new Hashtable<Character,Integer>();
			int counter = 0;
			int alpha[] = new int[26];
			int r = t;
			while(t != 0)
			{
				char a[] = br.readLine().toCharArray();
				hs.clear();
				for(int i = 0; i < a.length; i++)
				{
					if(!hs.containsKey(a[i]))
					{
						hs.put(a[i], 0);
						alpha[a[i] - 97]++;
					}
				}
				t--;
			}
			for(int i = 0; i < 26; i++)
			{
				if(alpha[i] == r)
					counter++;
			}
			//System.out.println(Arrays.toString(alpha));
			System.out.println(counter);
	
		}
	
}
