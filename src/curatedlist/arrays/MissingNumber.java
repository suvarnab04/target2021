package curatedlist.arrays;
/*
https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {

        int start = 0;
        while(start< nums.length){
            int j =nums[start];
            if(j < nums.length && nums[start]!= nums[j]){
                swap(nums, start, j);
            }else{
                start++;
            }
        }
        for(int i=0;i< nums.length;i++){
            if(nums[i] != i){
                return i;
            }
        }
        if(nums[nums.length-1] < nums.length){
            return nums.length;
        }
        return 1;

    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
