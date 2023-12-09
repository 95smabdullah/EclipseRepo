package day10.longDecoderProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	static Map<Character,Integer> resultMap = new HashMap<Character, Integer>(26);
	static Map<String,String> cipher = new HashMap<String, String>(26);
	
	public static void frequency(String s) {
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i+2)=='#') {
				if(s.charAt(i+3)=='(') {
					int closingIndex = s.indexOf(")", i+4);
					int count = Integer.parseInt(s.substring(i+4,closingIndex));
					resultMap.compute((char)Integer.parseInt(s.substring(i, i+2)), (k,v)->(v==0)?count:v+count);
					if(closingIndex==s.length()-1) {
						break;
					}else {
						i = closingIndex;
					}
				}else {
					resultMap.compute((char)Integer.parseInt(s.substring(i, i+2)), (k,v)->(v==0)?1:v+1);
					
				}
			}else {
				
			}
		}
		
//		resultMap.forEach((k,v)-> System.out.println(k+" "+v));
		
	}

	public static void main(String[] args) {
		for(int i=97; i<=122; i++) {
			resultMap.put((char)i, 0);
		}
		String a  = "abcd()dfd(2)";
		int i = a.indexOf(')', 6);
//		System.out.println(i);
		for(int j = 0;j<a.length();) {
			System.out.println(j);
			j+=2;
			System.out.println(j);
			if(j==6) {
				System.out.println("it is 5"); 
				break;
			}
		}
				
		
//		System.out.println(resultMap.get('b'));
	}
}
