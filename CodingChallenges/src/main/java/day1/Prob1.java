package day1;

public class Prob1 {
//	    public static int arrangeCoins(int n) {
//	    	int result = 0;
//	    	for (int i = 1; i <= n; i++) {
//	    		if(n-i>=0) {
//	    			n-=i;
//	    			result = i;
//	    		}	
//			}
//	    	return result;
//
//
//	}
	
//	for (long n: coins) {
//		System.out.println((int)(-1 + Math.sqrt(1+8*n))/2);
//	}
	    
	public static int quadCoinSol(int n) {
		return (int)(-1 + Math.sqrt(1+4*2*n))/2;
	}
	public static void main(String as[])
	{
		System.out.println("hi");
//		int result=arrangeCoins(2);
		int result = quadCoinSol(Integer.MAX_VALUE-100000000);
		System.out.println("Result  "+result);
	}

}
