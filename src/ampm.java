import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ampm {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(":");
		String hh = s[0];
		String mm = s[1];
		char a[] = s[2].toCharArray();
		char t = a[2];
		String sec = Character.toString(a[0]);
		String sb = Character.toString(a[1]);
		sec = sec + sb;
		if(Integer.parseInt(hh) == 12)
		{
			if(t == 'A')
			{
				hh = "00";
			}
			else
			{
				hh = "12";
			}
		}
		else
		{
			if(t == 'P')
			{
				int h = Integer.parseInt(hh);
				h += 12;
				hh = Integer.toString(h);
			}
		}
		System.out.println(hh+":"+mm+":"+sec);
		
	}
}
