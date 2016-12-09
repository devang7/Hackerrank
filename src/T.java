import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class T {
	
	public static void main(String args[])
	{
		String s = "I am using hackerrank to improve programming";
		String t = "am hackerrank to improve";
		System.out.println(Arrays.toString(T.missingWords(s, t)));
	}
	static String[] missingWords(String s, String t)
	{
		String org[] = s.split(" ");
		String n[] = t.split(" ");
		ArrayList<String> ans= new ArrayList<String>();
		int i=0,j=0;
		while(j<n.length){
			if(org[i].equals(n[j])){
				i++;
				j++;
			}
			else{
				ans.add(org[i]);
				i++;
			}
			
		}
		for(;i<org.length;i++)
			ans.add(org[i]);
		
		String a[] = new String[ans.size()];
		for(int k = 0; k < a.length; k++)
		{
			a[k] = ans.get(k);
		}
		
		return a;
		
	}
}
