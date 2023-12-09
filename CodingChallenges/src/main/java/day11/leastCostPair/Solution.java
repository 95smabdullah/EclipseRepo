package day11.leastCostPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	
	public static void findMinCost() {
	int[] effs = {2,13,12,6,9,3,2};
//	int[] effs = {4,1, 2,9,8};
	
//	1 2 4 8 9
	
	List<Integer> effsArray = Arrays.stream(effs)
			.boxed()
			.collect(Collectors.toCollection(ArrayList::new));
	
	Collections.sort(effsArray);
	int n = effsArray.size();
	
	int leftEdgeCost = Math.abs( effsArray.get(0)-effsArray.get(1));
	int rightEdgeCost = Math.abs( effsArray.get(n-2)-effsArray.get(n-1) );
	int maxEdgeCost = 0;
	int excludeIndex = 0;
	
	if(leftEdgeCost>rightEdgeCost) {
		maxEdgeCost = leftEdgeCost;
		excludeIndex = 0;
		
	}else{
		maxEdgeCost = rightEdgeCost;
		excludeIndex = n-1;
	}
	
	
	
	int pairCost = 0;
	for(int i=2;i<n-2;i++) {
		int leftCost = Math.abs(effsArray.get(i)-effsArray.get(i-1));
		int rightCost = Math.abs(effsArray.get(i)-effsArray.get(i+1));
		if((leftCost > maxEdgeCost || rightCost > maxEdgeCost) && leftCost+rightCost > pairCost) {
			pairCost = leftCost+rightCost;
			excludeIndex = i;
		}else if((leftCost > maxEdgeCost || rightCost > maxEdgeCost) && leftCost+rightCost == pairCost) {
			if (i%2 == 0) {
				excludeIndex = i;
			}
		}
		
		
	}
//	for(Integer i : effsArray) {
//		System.out.println(i);
//	}
//	System.out.println(effsArray.get(excludeIndex));
	effsArray.remove(excludeIndex);
	int result = 0;
	for (int i = 1; i<effsArray.size();) {
		result += effsArray.get(i)- effsArray.get(i-1);
		i+=2;
		
	}
	
	System.out.println(result);
//	for(Integer i : effsArray) {
//		System.out.println(i);
//	}
	
	
	}
	
	public static void main(String[] args) {
		Solution.findMinCost();
	}
	
}
