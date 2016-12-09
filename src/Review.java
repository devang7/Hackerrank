import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Review {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = "";
		for(int i = 0; i < n; i++)
		{
			s = br.readLine();
			char a[] = s.toCharArray();
			char e[];
			if(s.length() % 2 == 0) //even length
			{
				e = new char[s.length()/2];
				
			}
			else
			{
				e = new char[(s.length()/2)+1];
			}
			char o[] = new char[s.length()/2];
			int k=0,l=0;
			for(int j = 0; j < a.length; j++)
			{
				if(j%2 == 0)
				{
					e[k++] = a[j];
				}
				else
				{
					o[l++] = a[j];
				}
			}
			String one = new String(e);
			String two = new String(o);
			System.out.print(one+" "+two);
		}
	}

}
