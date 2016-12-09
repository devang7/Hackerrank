import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

public class ExpTree {
	public static void main(String args[]) throws Exception
	{
		/*String input = "(AB)C((DE)F)";
		ExpTree e = new ExpTree();
		System.out.println(e.reverse(input));
		System.out.println(e.simplify(input));*/
		ExpTree e = new ExpTree();
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
      //  while(true)
        //    {
            String t = br.readLine();
            //if(t == null)
              //  break;
            String in = e.spaceParser(t);
		int i = in.indexOf("/");
		String command = in.substring(i, in.length());
		String input = in.substring(0,i);
		char a[] = command.toCharArray();
		String ans = input;
		for(int j = 0; j < a.length; j++)
		{
			if(a[j] == 'R')
			{
				ans = e.reverse(ans);
			}
			else if(a[j] == 'S')
			{
				ans = e.simplify(ans);
			}
		}
		 System.out.println(ans);
            
        //}
   
       // y.close();
		
		 
		
	}
	
	public String compress(String command)
	{
		StringBuilder br = new StringBuilder();
		int count = 1;
		char a[] = command.toCharArray();
		int i = 1;
		for(i = 1; i < a.length; i++)
		{
			System.out.println(count);
			System.out.println(a[i]);
			if(a[i] == a[i-1])
				count++;
			else
			{
				if(a[i-1] == 'S')
				{
					br.append("S");
				}
				else 
				{
					if(count % 2 != 0)
					{
						br.append("R");
					}
				}
				count = 1;
			}
		}
		if(a[i-1] == 'S')
		{
			br.append("S");
		}
		else 
		{
			if(count % 2 != 0)
			{
				br.append("R");
			}
		}
		return br.toString();
	}
	public String reverse(String input)
	{
		char a[] = input.toCharArray();
		char temp[] = new char[a.length];
		int i = 0;
		for(int j = a.length - 1; j >= 0; j--)
		{
			if(a[j] == '(')
			{
				temp[i++] = ')';
			}
			else if(a[j] == ')')
			{
				temp[i++] = '(';
			}
			else
			{
				temp[i++] = a[j];
			}
		}
		return new String(temp);
	}
	public String simplify(String input)
	{
		int flag = 0;
		char a[] = input.toCharArray();
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < a.length; i++)
		{
			//System.out.println(st);
			if(a[i] == '(' && flag == 0)
			{
				st.push(i);
			}
			else if(a[i] == '(' && flag == 1)
			{
				
			}
			else if(!st.isEmpty() && a[i] == ')')
			{
				//System.out.println("In");
				int j = st.pop(); 
				a[i] = '!';
				a[j] = '!';
				st.clear();
				flag = 0;
			}
			else
			{
				flag = 1;
			}
		}
		
	//	String s = new String(a);
		char t[] = new char[a.length];
		int j = 0;
		Arrays.fill(t, ' ');
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] != '!')
			{
				t[j++] = a[i];
			}
		}
		//System.out.println(new String(t).trim());
		return new String(t).trim();
	}
	public String spaceParser(String s)
	{
		char a[] = s.toCharArray();
		int i = 0; 
		StringBuilder br = new StringBuilder();
		while(i < a.length)
		{
			if(a[i] == ' ')
			{
				int j = i+1;
				while(j < a.length && a[j] == ' ')
				{
					j++;
				}
				i = j;
			}
			else
			{
				br.append(Character.toString(a[i]));
				i++;
			}
		}
		//String s = new String();
		
		return br.toString();
	}
	

}
