package day8._3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
	
	public static List<List<Integer>> threeSum(int[] nums){
		
		HashSet<List<Integer>> resultSet = new HashSet<List<Integer>>();
		if (nums==null || nums.length<3) return new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i:nums) {
//			System.out.println(i);
			
		}
		
		for(int i = 0; i<nums.length-2; i++) {
			int left = i+1;
			int right = nums.length-1;
//			System.out.println(left+","+right);
			while (left<right){
				int sum = nums[i]+nums[left]+nums[right];
			if(sum == 0) {
				resultSet.add(Arrays.asList(nums[i],nums[left],nums[right]));
				left++;
				right--;
			}else if(sum < 0) {
				left++;
			}else right--;
				
		}
		
		}
		return new ArrayList<>(resultSet);
		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] nums = {0,1,-1};
		List<List<Integer>> x = threeSum(nums);
		for(List l : x) {
			System.out.println(l.toString());
		}
		
	}
}
	
