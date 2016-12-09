import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Correlation {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long psum = 0;
		int csum = 0;
		int msum = 0;
		int psumsq = 0;
		int csumsq = 0;
		int msumsq = 0;
		int pc = 0;
		int cm = 0;
		int pm = 0;
		int t = n;
 		while(n != 0)
		{
			String s[] = br.readLine().split("");
			int m = Integer.parseInt(s[0]);
			int p = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			psum += p;
			psumsq += p*p;
			pc += p*c;
			csum += c;
			csumsq += c*c;
			cm += c*m;
			msum += m;
			msumsq += m*m;
			pm += p*m;
			n--;
		}
 		//System.out.println(t*psumsq);
 		//System.out.println(psum*psum);
 		//System.out.println(Math.sqrt(t*psumsq-psum*psum));
 		double cor_pc = (t*pc - psum*csum)/((Math.sqrt(t*psumsq-psum*psum))*(Math.sqrt(t*csumsq-csum*csum)));
 		double cor_cm = (t*cm - csum*msum)/((Math.sqrt(t*csumsq-csum*csum))*(Math.sqrt(t*msumsq-msum*msum)));
 		double cor_pm = (t*pm - psum*msum)/((Math.sqrt(t*psumsq-psum*psum))*(Math.sqrt(t*msumsq-msum*msum)));
 		System.out.println(String.format("%.2f",cor_pm));
 		System.out.println(String.format("%.2f",cor_pc));
 		System.out.println(String.format("%.2f",cor_cm));
 		
	}
}
