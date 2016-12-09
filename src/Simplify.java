import java.util.Stack;

public class Simplify {

	public static void main(String args[])
	{
		Simplify e = new Simplify();
		String t = "(A((B)))";
		System.out.println(e.parser(t));
	}
	public String simplify(String input)
	{
		char a[] = input.toCharArray();
		if(a[0] == '(')
		{
			int i = 1;
			while(a[i] != ')')
			{
				i++;
			}
			return input.substring(1,i)+input.substring(i+1);
		}
		return input;
		
		
	}
	public String parser(String input)
	{
		char a[] = input.toCharArray();
		int i = 0;
		while(i < a.length)
		{
			if(a[i] == '(')
			{
				int j = getLast(a,i);
				StringBuilder br = new StringBuilder();
				br.append(input.substring(0, i+1));
				br.append(simplify(input.substring(i+1,j)));
				br.append(input.substring(j));
				input = new String(br);
				a = input.toCharArray();
			}
			i++;
		}
		return input;
	}
	public int getLast(char a[], int start)
	{
		Stack<Character> st = new Stack<Character>();
		st.push(a[start]);
		int i = start+1;
		while(!st.isEmpty())
		{
			if(a[i] == '(')
				st.push('(');
			else if(a[i] == ')')
				st.pop();
			i++;
		}
		return i;
	}
}
