import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Twitter {
	
	   	public static void main(String args[]) 
		{
			/*String input = "(AB)C((DE)F)";
			ExpTree e = new ExpTree();
			System.out.println(e.reverse(input));
			System.out.println(e.simplify(input));*/
			Twitter e = new Twitter();
	        
			/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));*/
	        Scanner sc = new Scanner(System.in);
	        String t = sc.nextLine();
	        ArrayList<String> an = new ArrayList<String>();
	        try{
	             while(t != null)
	            {
	            
	            String in = e.spaceParser(t);
			int i = in.indexOf("/");
			String command = in.substring(i+1, in.length());
			String input = in.substring(0,i);
			char a[] = e.compress(command).toCharArray();
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
	        an.add(ans.trim());
	       // System.out.print(ans.trim()+"\n");
	            t = sc.nextLine();
	            
	        }
	            
	        }
	        catch(Exception ex)
	            {
	            
	        }
	        System.setProperty("line.separator","\n");
	        PrintWriter pw = new PrintWriter(System.out);
	        for(int i = 0; i < an.size();i++)
	            {
	           pw.println(an.get(i));
	        }
	        pw.flush();
	       
			
			//System.out.println(e.compress("RRSSSRSRRSSS"));
			
		}
		public String compress(String command)
		{
			StringBuilder br = new StringBuilder();
			char a[] = command.toCharArray();
	        int i = 0; 
	        while(i < a.length){
	            if(a[i] == 'S'){
	                br.append(Character.toString(a[i]));
	                int j = i+1;
	                while(j < a.length && a[j] == 'S'){
	                    j++;
	                }
	                i = j;
	                
	            }
	            else{
	                br.append(Character.toString(a[i]));
	                i++;
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
	        char temp[] = new char[a.length];
	        Arrays.fill(temp,' ');
	        int j = 0;
	        for(int i = 0; i < a.length; i++){
	            if(a[i] != '!'){
	                temp[j++] = a[i];
	            }
	        }
			String s = new String(temp).trim();
			return s;
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
			return br.toString();
		}
	}


