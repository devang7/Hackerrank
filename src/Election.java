import java.util.Enumeration;
import java.util.Hashtable;

public class Election {

	public static void main(String args[])
	{
		String s[] = {"A","A","B","C","C"};
		System.out.println(Election.electionWinner(s));
	}
	static String  electionWinner(String[] votes)
	{
		Hashtable<String,Integer> hs = new Hashtable<String,Integer>();
		int k = 1;
		for(int i = 0; i < votes.length; i++)
		{
			if(!hs.containsKey(votes[i]))
				hs.put(votes[i], k);
			else
			{
				int count = hs.get(votes[i]);
				hs.put(votes[i], count+1);
			}
		}
		Enumeration<String> e = hs.keys();
		//System.out.println(hs.toString());
		int min = 0;
		String min_s = "";
		while(e.hasMoreElements())
		{
			String t = e.nextElement();
			int value = hs.get(t);
			//System.out.println(value);
			if(value >= min)
			{
				
				if(value == min)
				{
					//System.out.println(t+" "+min_s);
					if(min_s.compareToIgnoreCase(t) < 0)
					{
						min = value;
						min_s = t;
					}
				}
				else
				{
					min = value;
					min_s = t;
					//System.out.println(min);
				}
				
			}
			
				
		}
		return min_s;

	}
}
