import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bst {
	
	Trees root = null;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split(" ");
		Bst bi = new Bst();
		for(int i = 0; i < n; i++)
		{
			bi.makeBst(Integer.parseInt(s[i]));
		}
		//System.out.println(bi.getRoot());
		System.out.println(bi.traverse(bi.getRoot(),-1));
		//bi.answer(bi.getRoot(),n);
		
	}
	public Trees getRoot()
	{
		return root;
	}
	/*public int answer(Trees i,int n)
	{
		int sum = 0;
		int count = 0;
		Queue<Nod> p = new LinkedList<Nod>();
		//int visited[] = new int[n];
		//Arrays.fill(visited, -1);
		if(i != null)
		{
			if(i.left != null)
				count++;
			if(i.right != null)
				count++;
		}
		return sum;
	}*/
	public int traverse(Trees i,int counter)
	{
		//System.out.println("Test:"+i.value);
		int count1 = 0;
		int count2 = 0;
		counter = counter + 1;
		if(i.left == null && i.right == null) //leaf
		{
			//System.out.println(i.value);
			//System.out.println(counter);
			return counter;
		}	
		else
		{
			//counter = counter + 1;
			if(i.left != null)
			{
				count1 = traverse(i.left,counter);
			}	
			if(i.right != null)
			{
				//counter = 0;
				count2 = traverse(i.right,counter);
			}
			return count1+count2+counter;
		}
	}
	public Trees makeBst(int v)
	{
		Trees temp = new Trees(v);
		if(root == null)
		{
			//System.out.println("In");
			root = temp;
		}
		else
		{
			Trees i = root;
			Trees prev = null;
			int flag = 0;
			while(i != null)
			{
				if(v < i.value)
				{
					//go left;
					prev = i;
					flag = 1;
					i = i.left;
				}
				else
				{
					//go right;
					prev = i;
					flag = 2;
					i = i.right;
				}
			}
			if(flag == 1)
				prev.left = temp;
			else if(flag == 2)
				prev.right = temp;
		}
		return root;
	}

}
class Nod
{
	Nod(int v, int l)
	{
		val = v;
		level = l;
	}
	int val;
	int level;
}
class Trees
{
	Trees(int vi)
	{
		value = vi;
		left = null;
		right = null;
	}
	int value;
	Trees left;
	Trees right;
}
