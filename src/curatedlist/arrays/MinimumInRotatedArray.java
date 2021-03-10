package curatedlist.arrays;
/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
https://www.youtube.com/watch?v=IzHR_U8Ly6c
 */
public class MinimumInRotatedArray {
    //O(N)
    public int findMinO(int[] nums) {
        int i=0;
        while(i< nums.length){
            int j = (i+1) % nums.length; // go back to the 0th index if i reaches the last index.
            if(nums[i] < nums[j]){
                i++;
            }else{
                return nums[j];
            }
        }
        return -1;
    }
    //log(N), binary search
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }
        int left=0;
        int right= nums.length-1;
        while(left< right){
            int mid = (left+right)/2;

            if(mid>0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            }else if(nums[mid] > nums[right]){
                left=mid+1;
            }else{
                right= mid-1;
            }
        }
        return nums[left];
    }
}
