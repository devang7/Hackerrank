import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SuperReduce {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine(); 
		SuperReduce st = new SuperReduce();
		int j = 0;
		while((j = st.reduce(s)) != -1)
		{
			//System.out.println(j);
			String t = new String();
			if(j - 1 != -1 && (j+2) != s.length())
			{
				t += s.substring(0, j) + s.substring(j+2);
				s = t;
			}
			else if(j - 1  == -1 && j+2 != s.length())
			{
				t += s.substring(j+2);	
			}
			else if(j+2 == s.length() && j-1 != 0) 
			{
				t += s.substring(0,j);
			}
			s = t;
		}
		if(!s.equals(""))
			System.out.println(s);
		else
		{
			System.out.println("Empty String");
		}
		
	}
	public int reduce(String s)
	{
		for(int i = 0; i < s.length() - 1; i++)
		{
			if(s.charAt(i) == s.charAt(i+1))
				return i;
		}
		return -1;
		
		
	}

}
