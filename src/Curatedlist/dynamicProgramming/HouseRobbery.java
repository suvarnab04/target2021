package Curatedlist.dynamicProgramming;

/**
 * https://www.youtube.com/watch?v=xlvhyfcoQa4
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobbery {
    public int rob(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }


        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i< nums.length;i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        int max =0 ;
        for(int i=0;i< dp.length;i++){
            if(dp[i]> max){
                max = dp[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        HouseRobbery hr = new HouseRobbery();
        System.out.println(hr.rob(new int[]{1,2,3,1}));
    }
}
