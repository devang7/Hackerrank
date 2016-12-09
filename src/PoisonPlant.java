import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PoisonPlant {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split(" ");
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = Integer.parseInt(s[i]);
            
        }
       int b[] = new int[n];
       int top = 0;
       int min = 0;
       for(int i = 1; i < n; i++)
       {
    	   int j = i-1;
    	   while(j != top - 1)
    	   {
    		   if(a[i] > a[j])
    		   {
    			   b[i] = b[i]+1;
    			   break;
    		   }   
    		   else
    		   {
    			   if(b[i] < b[j])
    				   b[i] = b[j];
    		   }
    		   j--;
    	   }
    	   if(j == top - 1)
    	   {
    		   top = i;
    		// System.out.println(top);
    	   } 
    	   if(min < b[i])
    		   min = b[i];
       }
       System.out.println(min);
        
	}
}
