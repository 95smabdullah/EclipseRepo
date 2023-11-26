package day5.missingNumber;

import java.util.HashMap;

public class SumleeSubArray {
	 static int findSubarraySum(int arr[], int n, int sum)
	    {
	        HashMap<Integer, Integer> prevSum = new HashMap<>();
	        prevSum.put(0,1);
	        int res = 0;
	 
	       int currSum = 0;
	 
	        for (int i = 0; i < n; i++) {
	 currSum += arr[i];
	 int removeSum=currSum-sum;
	 if (prevSum.containsKey(removeSum))
	                res += prevSum.get(removeSum);
	           prevSum.put(currSum,prevSum.getOrDefault(currSum,0)+1);
	        }
	 
	        return res;
	    }

}
