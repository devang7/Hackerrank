import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Bracket so = new Bracket();
		while(t != 0)
		{
			String s = br.readLine();
			char a[] = s.toCharArray();
			Stack<Character> q = new Stack<Character>();
			char opening[] = new char[3];
			opening[0] = '(';
			opening[1] = '{';
			opening[2] = '[';
			char closing[] = new char[3];
			closing[0] = ')';
			closing[1] = '}';
			closing[2] = ']';
			int i;
			for(i = 0; i < a.length; i++)
			{
				if(so.isOpening(a[i],opening) != -1)
				{
					q.push(a[i]);
				}
				else
				{
					if(!q.isEmpty())
					{
						char top = q.peek();
						int k = so.isOpening(top,opening);
						if(a[i] == closing[k])
						{
							q.pop();
						}
						else
						{
							break;
						}
					}
					else
					{
						break;
					}
				}
				
			}
			if(a.length == i && q.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
			
			
			
			t--;
		}
			
		
	}
	public int isOpening(char a,char open[])
	{
		for(int i = 0; i < open.length; i++)
		{
			if(a == open[i])
			{
				return i;
			}
		}
		return -1;
	}

}
