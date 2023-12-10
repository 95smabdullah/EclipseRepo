package day11.maxProfit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	
	
	public static void findMaximumProfit() {
		int[] cat = {3,2,2,3};
		int[] price = {2,7,3,4};//6
		
		int n = cat.length;
		Set<Integer> soldCats = new HashSet<Integer>();
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> {
	        boolean sold1 = soldCats.contains(arr1[0]);
	        boolean sold2 = soldCats.contains(arr2[0]);
//	        System.out.println(arr1[1]+"  "+arr2[1]);

	        if (!sold1 && sold2) {
	            return -1;
	        } else if (sold1 && !sold2) {
	            return 1;
	        } else {
	            return Integer.compare(arr2[1], arr1[1]);
	        }
	    });
		for (int i = 0; i < n; i++) {
			System.out.println("offering");
	        pq.offer(new int[]{cat[i], price[i]});
//	        System.out.println(pq.peek()[0]+" price "+pq.peek()[1]);
//	        System.out.println("offered");
	        soldCats.add(cat[i]);
	        
	    }
		
		
		
		
//		int[][] items = new int[cat.length][2];
		
//		for(int i = 0; i<cat.length; i++) {
//			items[i][0] = cat[i];
//			items[i][1] = price[i];
//		}
		
		long maxProfit = 0;
//		Arrays.sort(items,Comparator.comparingInt(arr->arr[1]));
//		Arrays.sort(items, (arr1,arr2)->{
//			boolean sold1 = soldCats.contains(arr1[0]);
//		    boolean sold2 = soldCats.contains(arr2[0]);
//		    
//		    if (!sold1 && sold2) {
//		        return -1;
//		    } else if (sold1 && !sold2) {
//		        return 1;
//		    } else {
//		        return Integer.compare(arr1[1], arr2[1]);
//		    }
//		});
		
		while (!pq.isEmpty()) {
	        int[] item = pq.poll();
//	        System.out.println(item[0]);
//	        int currentCat = item[0];
	        int currentPrice = item[1];

	        System.out.println("Price "+currentPrice);
//	        System.out.println(soldCats.size());
	        if(pq.size()+1>=soldCats.size()) {
	        maxProfit += currentPrice * soldCats.size();
	        System.out.println(soldCats.size());
	        }else {
	        	maxProfit += currentPrice * (pq.size()+1);
	        	System.out.println("in else "+pq.size()+1);
	        }
	        System.out.println("mp "+maxProfit);
	    }
		
		
//		for(int i = 0; i<cat.length; i++) {
//			System.out.println(items[i][0]+" "+items[i][1]);
//			soldCats.add(items[i][0]);
//			maxProfit += items[i][1]*soldCats.size();
//			
			
			
//			System.out.println(items[i][0] + "  price - "+items[i][1]);
//		}
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
