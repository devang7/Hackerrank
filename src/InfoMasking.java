import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InfoMasking {
	
	public static void main(String args[]) throws Exception
	{
		InfoMasking e = new InfoMasking();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String t = br.readLine();
			if(t == null)
				break;
			if(t.charAt(0) == 'E')
			{
				System.out.println(e.email(t.substring(2)));
			}
			else if(t.charAt(0) == 'P')
			{
				System.out.println(e.ph(t.substring(2)));
			}
		}
	}
	public String email(String input)
	{
		StringBuilder br = new StringBuilder();
		int i = input.indexOf("@");
		br.append(input.substring(i));
		String user = input.substring(0, i);
		char a[] = user.toCharArray();
		for(int j = 1; j < a.length-1; j++)
		{
			a[j] = '*';
		}
		a[a.length-1] = '*';
		return (new String(a) + br.toString());
	}
	public String ph(String input)
	{
		StringBuilder br = new StringBuilder();
		br.append(input.substring(input.length() - 5, input.length()));
		input = input.substring(0,input.length() - 5);
		char a[] = input.toCharArray();
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] != '+' && a[i] != '-')
				a[i] = '*';
		}
		return new String(a) + br.toString();
	}

}
