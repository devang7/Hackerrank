import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class TextEditor {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		Stack<String> st = new Stack<String>();
		String mains = new String("");
		while (q != 0)
		{
			String s[] = br.readLine().split(" ");
			int t = Integer.parseInt(s[0]);
			if(t == 1)
			{
				String in = s[1];
				st.add(mains);
				mains = mains+in;	
			}
			if(t == 2)
			{
				int k = Integer.parseInt(s[1]);
				st.add(mains);
				mains = mains.substring(0, mains.length() - k);
			}
			if(t == 3)
			{
				int f = Integer.parseInt(s[1]);
				System.out.println(mains.charAt(f-1));
			}
			if(t ==4)
			{
				if(!st.isEmpty())
					mains = st.pop();
			}
			q--;
		}
	}
}
