import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lady {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			int n = Integer.parseInt(br.readLine());
			char a[] = br.readLine().toCharArray();
			int flag = 0;
			for(int i = 0; i < n; i++)
			{
				if(a[i] == '_')
				{
					flag = 1;
				}
			}
			if(flag == 0)
			{
				int i = 0;
				int j = 0;
				while(i < n)
				{
					j = i+1;
					int count = 1;
					while(j < n && a[i] == a[j])
					{
						j++;
						count++;
					}
				//System.out.println("c:"+count);
					if(count <= 1)
					{
						//i = j;
						break;
					}
					
					i = j;
					//System.out.println(i);
				}
				if(i < n)
				{
					System.out.println("NO");
				}
				else
				{
					System.out.println("YES");
				}
			}
			else
			{
				int alp[] = new int[26];
				for(int i = 0; i < n; i++)
				{
					if(a[i] != '_')
						alp[a[i] - 65]++;
				}
				int i = 0;
				for(i = 0; i < 26; i++)
				{
					if(alp[i] != 0 && alp[i] <= 1)
					{
						break;
					}
						
				}
				if(i != 26)
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			t--;
		}
		
	}

}
