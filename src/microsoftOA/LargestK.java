package microsoftOA;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that, given an array A of N integers, returns the largest integer K > 0 such
 * that both values K and -K exist in array A.
 * If there is no such integer, the function should return 0.
 */
public class LargestK {
    private static int largestNum(int[] nums) {
        int result = 0;
        Set<Integer> inv = new HashSet<>(); //keeps inverse of seen number for eg -1 for 1
        for(int i=0;i<nums.length;i++) {
            inv.add(-1 * nums[i]);
            if(inv.contains(nums[i])) {
                result = Math.max(result, Math.abs(nums[i]));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = { 3, 2, -2, 5, -3 }; //3
        int[] nums2 = { 1, 2, 3, -4 };//0
        System.out.println(largestNum(nums1));
        System.out.println(largestNum(nums2));
        System.out.println("-------------------------------------");

    }
}
