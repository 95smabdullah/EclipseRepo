package day1;

import java.util.List;
import java.util.Scanner;

public class Prob2 {
	public static int[] numberOfWays(int[][] queries){
		
		int[] result = new int[queries.length];
		int j = 0;
		for (int[] dims : queries) {
			int minDim=dims[0]<dims[1]?dims[0] : dims[1];
			for (int i=1;i<=minDim;i++) {	
				result[j]+=(dims[0]-i+1)*(dims[1]-i+1);
			}
			j++;	
		}
		return result;
	}
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter no. of test cases");
	int n = s.nextInt();
//	int[][] queries = {{5,3},{3,4},{6,5},{2,1},{2,3}};
	int[][] queries = new int[n][2];
	System.out.println("Enter rows and columns separated by space");
	for(int i = 0;i<n;i++) {
		System.out.println("Enter rows and colums");
		queries[i][0]=s.nextInt();
		queries[i][1]=s.nextInt();
		
	}
	
	
	int[] result = numberOfWays(queries);
	
	for (int i : result) {
		System.out.println("results "+i);
	}
}
}
