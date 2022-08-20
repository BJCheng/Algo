package SlidingWindow;

import java.util.Arrays;

public class MaximumSubarrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here
        int i=0, j=0, max=Integer.MIN_VALUE, sum=0;
        while(j < arr.length) {
            sum += arr[j];
            while(j-i+1 > k) {
                sum -= arr[i];
                i++;
            }
            max = Math.max(max, sum);
            j++;
        }
        String a = "";
        for(char c: a.toCharArray()) {
            System.out.println(c);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(MaximumSubarrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
    }
}
