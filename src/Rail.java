import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Rail {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int k = Integer.parseInt(s[2]);
		int empty = n*m;
		Tracks div[] = new Tracks[n];
		int blocks = 0;
		while(k != 0)
		{
			String p[] = br.readLine().split(" ");
			int i = Integer.parseInt(p[0]);
			int start = Integer.parseInt(p[1]);
			int end = Integer.parseInt(p[2]);
			Tracks first = div[i-1];
			if(first == null)
			{
				Tracks t = new Tracks(start,end);
				div[i-1] = t;
				blocks = end-start+1;
				empty -= blocks;
			}
			else
			{
				Tracks temp = first;
				Tracks prev = null;
				while(temp != null)
				{
					int x = temp.start;
					int y = temp.end;
					if(x <= start && y >= end) //full overlap min
					{
						blocks = 0;
						break;
					}
					else if(x <= start && y >= start && y < end) //partial overlap 
					{
						blocks = end - temp.end + 1;
						temp.end = end;
						break;
					}
					else if(x >= end && y <= end) //partial overlap
					{
						blocks = temp.start - start + 1;
						temp.start = start;
						break;
					}
					else if(x > start && y < end) //full overlap max
					{
						
					}
					prev = temp;
					temp = temp.next;	
				}
				Tracks ni = new Tracks(start,end);
				prev.next = ni;	
			}
			k--;
		}
		
	}
	

}
class Tracks
{
	Tracks(int s,int e)
	{
		start = s;
		end = e;
		next = null;
	}
	int start;
	int end;
	Tracks next;
}
