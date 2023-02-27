package Coursework;

import java.util.*;

public class MinimumProductDifference {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 11};
        int minDiff = findMinProductDifference(arr);
        System.out.println("Minimum product difference: " + minDiff);
    }

    public static int findMinProductDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] subarray1 = Arrays.copyOfRange(arr, 0, n/2);
        int[] subarray2 = Arrays.copyOfRange(arr, n/2, n);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n/2; i++) {
            int diff = Math.abs(subarray1[i] * subarray2[i] - subarray1[n/2+i] * subarray2[n/2+i]);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

}
