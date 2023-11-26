package day5.missingNumber;

import java.util.HashMap;

public class SubarrayCountWithSumK {
    public static int countSubarraysWithSumK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        
        // Map to store cumulative sum frequencies
        HashMap<Integer, Integer> sumFrequencyMap = new HashMap<>();
        sumFrequencyMap.put(0, 1); // Initialize with 0 to handle subarrays starting from the beginning
        
        for (int num : nums) {
            sum += num;
            
            // Check if (sum - k) has occurred before
            if (sumFrequencyMap.containsKey(sum - k)) {
                count += sumFrequencyMap.get(sum - k);
            }
            
            // Update the frequency of the current cumulative sum
            sumFrequencyMap.put(sum, sumFrequencyMap.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 9;
        int result = countSubarraysWithSumK(nums, k);
        System.out.println("Count of subarrays with sum " + k + ": " + result);
    }
}

