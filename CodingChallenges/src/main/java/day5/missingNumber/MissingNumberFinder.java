package day5.missingNumber;

public class MissingNumberFinder {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1; 
        int expectedSum = (n * (n + 1)) / 2; 

        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 5, 1, 6}; // Missing number is 4
        int missingNumber = findMissingNumber(arr);
        System.out.println("The missing number is: " + missingNumber);
    }
}
