import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class BucketProb {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a[] = br.readLine().split(" ");
		int n = Integer.parseInt(a[0]);
		int b = Integer.parseInt(a[1]);
		Comparator<Node> comp = new NodeCompare();
		Double bucket[] = new Double[b];
		PriorityQueue<Node> pq = new PriorityQueue<Node>(10,comp);
		Hashtable<Double,Node> hs = new Hashtable<Double,Node>();
		Hashtable<Integer,Double> hb = new Hashtable<Integer,Double>();
		for(int i = 0; i < n; i++)
		{
			String s[] = br.readLine().split(" ");
			Node temp = new Node(Integer.parseInt(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2]),Double.parseDouble(s[3]));
			pq.add(temp);	
			hs.put(Double.parseDouble(s[3]), temp);
			hb.put(Integer.parseInt(s[0]), Double.parseDouble(s[3]));
		}	
		for(int i = b-1; i >= 0; i--)
		{
			bucket[i] = pq.remove().z; 
		}
		//System.out.println(Arrays.toString(bucket));
		String f = new String("F");
		String si = "";
		int flag = 0;
			while(flag != 1)
			{
				if(br.ready())
				{
					si = br.readLine();
				}
				else
				{
					flag = 1;
					si = br.readLine();
				}
				String d[] = si.split(" ");
				//System.out.println(Arrays.toString(d));
				if(f.equalsIgnoreCase(d[0]))
				{
					//call F function
					int l = Integer.parseInt(d[1]);
					int i = Arrays.binarySearch(bucket,hb.get(l));
					//System.out.println(Arrays.binarySearch(bucket, -55.9));
					//System.out.println(i);
					if(i < 0)
						System.out.println("Point doesn't exist in the bucket.");
					else
					{
						Node t = hs.get(bucket[i]);
						System.out.println(t.k + " = ("+String.format("%.3f", t.x)+","+String.format("%.3f", t.y)+","+String.format("%.3f", t.z)+")");
					}
				}
				else
				{
					//call R function
					int t = Integer.parseInt(d[1]);
					int i = Arrays.binarySearch(bucket, hb.get(t));
					if(i < 0)
						System.out.println("Point doesn’t exist in the bucket.");
					else if(!pq.isEmpty())
					{
						//System.out.println(hb.get(t));
						System.out.println("Point id "+t+" removed.");
							for(int j = i; j > 0; j--)
							{
								Double temp = bucket[j-1];
								bucket[j-1] = bucket[j];
								bucket[j] = temp;
							}
							bucket[0] = pq.remove().z;
							
						//	System.out.println(Arrays.toString(bucket));
					
					}
					else
					{
						System.out.println("No more points can be deleted.");
					}
				}
				//q--;
			}
			//br.close();
		}
		
}

class NodeCompare implements Comparator<Node>
{
	public int compare(Node x,Node y)
	{
		if(x.z < y.z)
			return 1;
		if(x.z > y.z)
			return -1;
		return 0;
	}
}
class Node
{
	int k;
	double x;
	double y;
	double z;
	Node(int ki,double xi,double yi,double zi)
	{
		k = ki;
		x = xi;
		y = yi;
		z = zi;
	}
}