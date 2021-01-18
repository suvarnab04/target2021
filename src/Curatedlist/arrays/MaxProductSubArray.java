package Curatedlist.arrays;

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {

        int result = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for(int  i=1;i< nums.length;i++){
            int temp = Math.max(nums[i], Math.max(maxProd * nums[i],minProd * nums[i])); // we need to use temp here so that we dont override maxProd
            minProd = Math.min(nums[i], Math.min(maxProd* nums[i], minProd*nums[i])); // we need to
            maxProd = temp;
            result = Math.max(result, maxProd);
        }
        return result;
    }
}
