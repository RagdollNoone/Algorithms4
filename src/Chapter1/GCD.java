package Chapter1;

public class GCD {

	public static int GCD(int p, int q)
	{
		if(q == 0) return p;
		
		int r = p % q;
		return GCD(q, r);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p = 16;
		int q = 8;
		
		int result = GCD(p, q);
		
		return;
	}

}
