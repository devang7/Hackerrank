import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IceCreamParlour {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		int b[] = new int[n];
		String s[] = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
			b[i] = i+1;
		}
		IceCreamParlour ic = new IceCreamParlour();
		ic.mergeSort(a, 0, n-1, b);
	}
	public void mergeSort(int a[],int start,int finish,int b[])
	{
		System.out.println("s:"+start+"f:"+finish);
		if((finish - start) <= 1)
		{
			//sort 2 numbers
			if(finish-start == 0)
			{
				return;
			}
			else
			{
				if(a[start] > a[finish])
				{
					int temp = a[start];
					a[start] = a[finish];
					a[finish] = temp;
				}
				return;
			}
		}
		else
		{
			int mid = (start+finish)/2;
			mergeSort(a,start,mid,b);
			mergeSort(a,mid+1,finish,b);
			merge(a,start,mid,finish,b);
		}
		System.out.println(Arrays.toString(a));
	}
	public void merge(int a[],int start,int mid,int finish, int b[])
	{
		int aux[] = new int[finish-start+1];
		int sa = mid+1;
		int j = 0;
		System.out.println("st: "+start+"mid:"+mid+"fin:"+finish);
		System.out.println(Arrays.toString(a));
		while(start != mid+1 && sa != finish+1)
		{
			System.out.println("st: "+start+"mid:"+mid+"fin:"+finish);
			System.out.println(Arrays.toString(a));
			if(a[start] < a[sa])
			{
				aux[j++] = a[start];
				start++;
			}
			else
			{
				aux[j++] = a[sa];
				sa++;
			}

		}
		System.out.println(Arrays.toString(aux) + "start:"+start+"mid:"+mid+"sa:"+sa);
		if(start != mid+1)
		{
			while(start != mid+1)
			{
				System.out.println(Arrays.toString(aux) + "start:"+start+"mid:"+mid+"sa:"+sa);
				aux[j++] = a[start++];
				start++;
			}
		}
		else if(sa != finish+1)
		{
			while(sa != finish)
			{
				aux[j++] = a[sa++];
				sa++;
			}
		}
		for(int i = 0; i < aux.length; i++)
		{
			a[start] = aux[i];
			start++;
		}
	}
	

}
