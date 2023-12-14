package day11.leastCostPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution3 {
	public static int findMinCost() {
	
	int[] efficiencyL = {5,  6,10,  11,15,  16,19,  22,22,  25,27,  27,28,29,30,30,32,36,36,38,44,45,48,51,52,62,66,67,69,70,70,71,71,73,73,75,77,78,78,80,81,83,83,83,83,88,89,89,90,90,91,93,94,96,98,98,99};	
//	int[] efficiencyL = {1,1,2,3,3,4,4,5,7,10,11,12,12,13,14,15,17,19,19,20,22,26,27,31,32,33,34,35,35,36,37,37,37,38,39,42,46,49,49,50,52,53,54,54,54,55,55,56,59,60,61,61,62,63,63,64,64,64,64,65,68,69,69,69,71,71,74,76,77,78,78,78,78,78,79,80,82,82,82,83,83,84,87,88,88,90,90,92,94,95,96,96,100,100,100};
	int n = efficiencyL.length;
    Arrays.sort(efficiencyL);
    
    List<Integer> efficiency = Arrays.stream(efficiencyL)
			.boxed()
			.collect(Collectors.toCollection(ArrayList::new));
    
//    Remove duplicates that can be grouped together 
    int m = 0;
	while(m<n-2){
		if(efficiency.get(m)==efficiency.get(m+1)) {
			efficiency.remove(m);
			efficiency.remove(m);
			
			n = efficiency.size();
		}
		else {
			m+=2;
		}
	}
	

    List<Integer> leftDiffs = new ArrayList<Integer>();
    List<Integer> rightDiffs = new ArrayList<Integer>();
    List<Integer> leftDiffsF = new ArrayList<Integer>();
    List<Integer> rightDiffsF = new ArrayList<Integer>();
    List<Integer> rightDiffsF2 = new ArrayList<Integer>();
    int CumDiffs = Integer.MAX_VALUE;

    for (int i = 1; i < n; i++) {
    	int diff = Math.abs(efficiency.get(i) - efficiency.get(i-1));
    	if(i%2!=0) {
    		leftDiffs.add(diff);
    	}else {
    		rightDiffs.add(diff);
    	}
    }
    
    leftDiffsF.add(0);
    rightDiffsF.add(0);
    for(int i=0; i<leftDiffs.size(); i++) {
    	leftDiffsF.add(leftDiffs.get(i)+leftDiffsF.get(i));
    	rightDiffsF.add(rightDiffs.get(rightDiffs.size()-1-i)+rightDiffsF.get(i));
    }
//    System.out.println(rightDiffsF.get(rightDiffsF.size()-1));
//    int rightCumDiff = 0;
//    for(int i:rightDiffs) {
//    	rightCumDiff+=i;
//    }
//    System.out.println(rightCumDiff);
    
//    rightDiffsF2.add(rightCumDiff);
//    for(int i=0; i<rightDiffs.size(); i++) {
//    	rightDiffsF2.add(rightDiffsF2.get(i)-rightDiffs.get(i));
//    }
    
    for(int i=0; i<leftDiffsF.size(); i++) {
    	CumDiffs = Math.min(CumDiffs, leftDiffsF.get(i)+rightDiffsF.get(rightDiffsF.size()-1-i));
//    	CumDiffs = Math.min(CumDiffs, leftDiffsF.get(i)+rightDiffsF2.get(i));
    }
    
    
//  for(int i : efficiency) {
//	System.out.print(i+" ");
//}
//System.out.println("all");
//
//for(int i=0; i<leftDiffs.size(); i++) {
//	System.out.print(leftDiffs.get(i)+" ");
//}
//System.out.println("ld");

//for(int i=0; i<leftDiffsF.size(); i++) {
//	System.out.print(leftDiffsF.get(i)+" ");
//}
//	System.out.println("ldf");
//for(int i=0; i<rightDiffs.size(); i++) {
//   	System.out.print(rightDiffs.get(i)+" ");
//   	}
//System.out.println("rd");	
//for(int i=0; i<rightDiffsF.size(); i++) {
//	System.out.print(rightDiffsF.get(i)+"\t");
//	}
//System.out.println("rdf");
//for(int i=0; i<rightDiffsF2.size(); i++) {
//	System.out.print(rightDiffsF2.get(i)+"\t");
//	}
//System.out.println("rdf2");
    
    
//    System.out.println("e "+efficiency.size());
//    System.out.println("ld "+leftDiffs.size());
//    System.out.println("rd "+rightDiffs.size());
//    System.out.println("ldf "+leftDiffsF.size());
//    System.out.println("rdf "+rightDiffsF.size());
    
//    rightDiffsF.add(rightCumDiff);
    
    
//    for (int i = 0; i < n; i++) {
//    	
//    }
//    
//    
//    
//    
//    
//    for (int i = 0; i < n; i+=2) {
////        int cost = 0;
//        for (int j = i; j < n-1; j+=2) {
//        	if(i>0) {
//        		adj =  Math.abs(efficiency.get(j) - efficiency.get(j-1));
//        	}
//        	
//    1 1 1 3 3
//            
//        }
//        if(i!=0) {
//        	leftSum+=Math.abs(efficiency.get(i-1) - efficiency.get(i-2));
//        }else {
//        	rightSum+=Math.abs(efficiency.get(i+2) - efficiency.get(i+1));
//        }
//        cost+=leftSum;
//        minCost = Math.min(minCost, cost);
//    }
//    
//    return minCost;
	
return CumDiffs;
	}
	public static void main(String[] args) {
		System.out.println(Solution3.findMinCost());
	}
	
}
