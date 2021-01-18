package Curatedlist.arrays;


/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
/*
leftproduct will have the product of all the number on left side of the number
rightproduct will have the product of all the number on right side of the number
    */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int [] leftprod = new int[nums.length];
        int [] rightprod = new int[nums.length];

        int mul =1;
        for(int i=0;i< nums.length;i++){

            leftprod[i] = mul;

            mul = mul* nums[i];
        }
        mul=1;
        for(int i=nums.length-1;i>=0;i--){

            rightprod[i] = mul;

            mul = mul* nums[i];
        }
        for(int i=0;i< nums.length;i++){
            nums[i] = leftprod[i] * rightprod[i];
        }


        return nums;
    }
}