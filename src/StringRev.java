
public class StringRev {
	
	public static void main(String args[]) throws Exception
	{
		System.out.println(StringRev.reverseStr(("abe")));
		
	}
	static String reverseStr(String s)
	{
		char a[] = s.toCharArray();
		char temp;
		for(int i = 0, j = a.length - 1; i < a.length/2; i++,j--)
		{
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		return new String(a);
	}

}
