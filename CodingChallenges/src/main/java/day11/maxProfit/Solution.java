package day11.maxProfit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	
	
	public static void findMaximumProfit() {
		int[] cat = {3,2,2,3};
		int[] price = {2,7,3,4};
		
		int[][] items = new int[cat.length][2];
		
		for(int i = 0; i<cat.length; i++) {
			items[i][0] = cat[i];
			items[i][1] = price[i];
		}
		Set<Integer> soldCats = new HashSet<Integer>();
		long maxProfit = 0;
		Arrays.sort(items,Comparator.comparingInt(arr->arr[1]));
		
		for(int i = 0; i<cat.length; i++) {
			soldCats.add(items[i][0]);
			maxProfit += items[i][1]*soldCats.size();
			
			
			
//			System.out.println(items[i][0] + "  price - "+items[i][1]);
		}
		System.out.println(maxProfit);
		
		
//		Map<Integer,Integer> myMap = IntStream.range(0, cat.length)
//		.boxed()
//		.collect(Collectors.toMap(i->cat[i], i->price[i]));
//		
//		Map<Integer,Integer> sortedMap = myMap.entrySet().stream()
//											.sorted(Map.Entry.comparingByValue())
//											.collect(Collectors.toMap(
//													Map.Entry::getKey,
//													Map.Entry::getValue,
//													(e1,e2) -> e1,
//													HashMap::new));
//		sortedMap.forEach((k,v)->System.out.println(k+"  price-> "+v));
	}
	
	
	public static void main(String[] args) {
		Solution.findMaximumProfit();
	}
}
