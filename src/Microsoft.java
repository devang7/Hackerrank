import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Microsoft {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int visited[] = new int[26];
		
		char arr[] = new char[26];
		char map1,map2;
		for(int i = 0; i < s.length; i++)
		{
			String h[] = s[i].split("-");
			map1 = h[0].charAt(0);
			map2 = h[1].charAt(0);
			if(visited[map1 - 65] == 0)
			{
				arr[map1 - 65] = map2;
				visited[map1 - 65]++;
			}
		
		}
		System.out.println(arr);
		String si = br.readLine();
		char input[] = si.toCharArray();
		char output[] = new char[input.length];
		
		for(int i = 0; i < input.length; i++)
		{
			if(input[i] >= 'A' && input[i] <= 'Z')
			{
				output[i] = arr[input[i] - 65];
			}
			else if(input[i] >= 'a' && input[i] <= 'z')
			{
				output[i] = arr[input[i] - 97];
				output[i] = Character.toLowerCase(output[i]);
				
			}
			else
			{
				output[i] = input[i];
			}
		}
		String ans = new String(output);
		System.out.println(ans);
	}

}
