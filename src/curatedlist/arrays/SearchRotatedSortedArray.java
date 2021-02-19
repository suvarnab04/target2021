package curatedlist.arrays;

import java.util.Arrays;
/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
https://backtobackswe.com/platform/content/minimum-item-in-a-rotated-sorted-array/video
https://www.youtube.com/watch?v=QdVrY3stDD4
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){ // numbers on the right are less than mid
                left = mid +1;
            }else{
                right = mid;
            }
        }
        System.out.println("smallest item is at index::"+ left);
        //the index where left and right meet is the smallest element in the array
        int start = left;
        left =0;
        right = nums.length-1;

        if(target>= nums[start] && target <= nums[right] ){ //right half
            left = start ;
        }else{
            right = start; // left half
        }

        while(left<= right){
            int mid = (left + right )/2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

}
