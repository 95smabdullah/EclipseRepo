package day8.longestSubString;

import java.util.HashSet;

public class Solution {
	public static int lenOfLongestSubString(String s) {
		int i = 0;
		int j = 0;
		int result = 0;
		
		HashSet<Character> hash_set = new HashSet<Character>();
		while(j<s.length()) {
			System.out.println("i "+i+" and j "+j);
			if(!hash_set.contains(s.charAt(j))) {
				hash_set.add(s.charAt(j));
				j++;
				result = Math.max(hash_set.size(), result);
//				System.out.println(hash_set.toString());
				
			}else {
				hash_set.remove(s.charAt(i));
				i++;
				
				
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lenOfLongestSubString(s));
	}
} 
// 
