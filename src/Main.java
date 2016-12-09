import java.util.Enumeration;
import java.util.Hashtable;

public class Main{
String input=new String("abbaaaa");
int n;
String s=new String();
Hashtable<String, Integer> hmap = new Hashtable<String, Integer>();
void getInput()
{
input="eaaabbbaac";
n=input.length();
input="#"+input+"@";
System.out.println(input);
for(int i=1;i<=n;i++){
for(int j=0;j<n;j++)
{
int start=i-j;
int end=i+j;
if(start>=1 && end<=n)
{
if(input.charAt(start)==input.charAt(end))
{
String s=new String();
s=input.substring(start,end+1);
hmap.put(s,start);
}
else
{
break;
}
}
}
}
for(int i=1;i<=n;i++){
for(int j=0;j<=n;j++)
{
int start=i;
int end=i+j;
if(start>=1 && end<=n)
{
if(input.charAt(start)==input.charAt(end))
{
String s=new String();
s=input.substring(start,end+1);
hmap.put(s,start);
}
else
{
break;
}
}
}
}
//System.out.println(hmap.toString());
Enumeration<Integer> e = hmap.elements();
int counter = 0;
while(e.hasMoreElements())
{
	counter++;
	e.nextElement();
}
	System.out.println(counter);
}
public static void main(String args[])
{
Main m=new Main();
m.getInput();
}



}