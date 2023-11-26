package day4.hthm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumAllPairs {
    public List<int[]> twoSum(int[] nums, int target) {
        // Create a HashMap to store elements and their indices.
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the difference between target and current element.

            // Check if the complement (the needed value to reach the target) is in the HashMap.
            if (map.containsKey(complement)) {
                // If it is, we found a pair that adds up to the target.
                // Add both indices to the result list.
                result.add(new int[] {map.get(complement), i});
            }

            // Add the current element and its index to the HashMap.
            map.put(nums[i], i);
        }

        return result; // Return the list of all pairs of indices.
    }

    public static void main(String[] args) {
        TwoSumAllPairs twoSumAllPairs = new TwoSumAllPairs();
        int[] nums = {2, 7, 11, 15, 3, 8, 9, 2, 8};
        int target = 10;
        List<int[]> pairs = twoSumAllPairs.twoSum(nums, target);

        for (int[] pair : pairs) {
            System.out.println("Pair: [" + pair[0] + ", " + pair[1] + "]");
        }
    }
}
