package day11.maxProfit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
	
	public static long findMaximumProfit() {
		
		int[] category = {1,1,2};
		int[] price = {1,1,2};
		int n = price.length;
		Set<Integer> uniqueCats = new HashSet<Integer>();
		for(int i: category) {
			uniqueCats.add(i);
		}
		
		long res = 0;
		int highestPreMult = uniqueCats.size();
		
		Arrays.sort(price);
		
		for(int i=n-1; i>0;i--) {
			if(i>= highestPreMult-1) {
				res+=highestPreMult*price[i];
			}else{
				res+=i*price[i];
			}
		}
		res+=price[0];
		System.out.println(res);
		return res;
		
	}
	public static void main(String[] args) {
		Solution2.findMaximumProfit();
	}
	
}
