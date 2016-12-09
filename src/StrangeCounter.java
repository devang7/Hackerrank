import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StrangeCounter {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine());
		long slot = (long) (Math.log((t-1)/3 + 1) / Math.log(2));
		long start = (long) (3* (Math.pow(2, slot) - 1) + 1); 
		long value = (long) (3 * Math.pow(2, slot));
		//System.out.println(slot + " " + start + " " + value);
		long diff = value - (t - start);
		System.out.println(diff);
		
	}

}
