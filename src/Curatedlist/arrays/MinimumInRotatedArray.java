package Curatedlist.arrays;

public class MinimumInRotatedArray {
    public int findMin(int[] nums) {
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
}
