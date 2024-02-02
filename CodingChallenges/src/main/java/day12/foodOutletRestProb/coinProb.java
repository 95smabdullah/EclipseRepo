package day12.foodOutletRestProb;

import java.util.ArrayList;
import java.util.List;

public class coinProb {
	public static void arrangeCoins(List<Long> coins) {
		for(long n:coins) {
			long k = (long)Math.sqrt(2*(long)n);
			long sum = k*(k+1)/2;
			if (sum>n) System.out.println((k-1));
			else System.out.println(k);
		}
	}
	
	public static void main(String[] args) {
		List<Long> coins = new ArrayList<Long>();
		coins.add((long)2);
		coins.add((long)5);
		coins.add((long)8);
		coins.add((long)3);
		
		arrangeCoins(coins);
	}
}
