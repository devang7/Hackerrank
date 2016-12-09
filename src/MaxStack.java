import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class MaxStack {
		public static void main(String[] args) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(br.readLine());
	        Stack<Integer> s = new Stack<Integer>(); 
	        MaxStack sol = new MaxStack();
	        int max = 0;
	        int flag = 0;
	        while(t != 0){
	            String si[] = br.readLine().split(" ");
	            int type = Integer.parseInt(si[0]);
	            if(type == 1)
	            {
	                 int data = Integer.parseInt(si[1]);
	                 s.push(data);
	                 if(data > max)
	                	 max = data;
	            }
	            else if(type == 2)
	            {
	                if(s.pop() == max)
	                {
	                	flag = 1;
	                }
	            }
	            else
	            {
	            	if(flag == 0)
	            		System.out.println(max);
	            	else
	            	{
	            		Iterator<Integer> it = s.iterator();
	            		System.out.println(sol.max(it));
	            	}
	               
	            }
	            //System.out.println(Arrays.toString(s.toArray()));
	            t--;
	        }
	        
	    }
	    public int max(Iterator<Integer> it)
	    {
	        int max = 0;
	        while(it.hasNext())
	        {
	        	int i = it.next();
	        	if(i > max)
	        		max = i;
	        }
	        return max;
	    }

}
