package Curatedlist.dynamicProgramming;
/*
https://www.youtube.com/watch?v=mFT2bIFKUFE
https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobbery2 {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return  nums[0];
        }
        if(nums.length ==2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
    }
    public int rob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for(int i=2;i< end;i++){
            dp[i] = Math.max(dp[i-2]+nums[i] , dp[i-1]);
        }
        return dp[end-1];
    }
    public static void main(String args[]){
        HouseRobbery2 hr = new HouseRobbery2();
       System.out.println( hr.rob(new int[]{1,2,3,1}));
    }
}

