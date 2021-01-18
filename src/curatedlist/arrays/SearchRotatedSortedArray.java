package curatedlist.arrays;

import java.util.Arrays;
/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {
    /*public int search(int[] nums, int target) {
          for(int i=0; i< nums.length;i++){
              if(nums[i] == target){
                  return i;
              }
          }
          return -1;

      }*/
    //binary search
    public int search(int[] nums, int target) {

        int mid = (nums.length)/2;
        int rotatedIndex = findRotatedIndex(nums);

        System.out.println("rotated index::"+ rotatedIndex);

        int ret =-1;
        if(nums[rotatedIndex] == target){
            return rotatedIndex;
        }

        ret = binarySearch(nums, target, rotatedIndex+1, nums.length-1);

        if( ret ==-1){
            System.out.println(Arrays.toString(nums) +" target:"+target+" target not found!Checking in first half");
            return binarySearch(nums, target, 0,rotatedIndex-1);
        }

        return ret;
    }

    public int binarySearch(int[] nums, int target, int start, int end){


        if(end< start){
            return -1;
        }

        int mid = (start+end)/2;

        if(nums[mid] == target){
            return mid;
        }else if(target > nums[mid]){
            return binarySearch(nums, target, mid+1, end);
        }else{

            return binarySearch(nums, target, start, mid-1);
        }

    }
    public int findRotatedIndex(int[] nums){

        if(nums.length==1){
            return 0;
        }
        int i =0;
        while(i<= nums.length){

            int j = (i+1)%nums.length;
            if(nums[j] < nums[i]){
                return i;
            }
            i++;
        }
        return 0;
    }

}
