package Curatedlist.dynamicProgramming;
/*

https://www.youtube.com/watch?v=fV-TF4OvZpk
https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];

        dp[0] = 1;
        for(int current=1;current< nums.length; current++ ){
            int max =1;
            for(int i=0;i<current;i++){
                if(nums[current]> nums[i]){
                    max = Math.max(dp[i]+1,max );
                }

            }
            dp[current] =max;
        }
        int m = 1;
        for(int i=0;i< dp.length;i++){
            m = Math.max(m, dp[i]);
        }
        return m;
    }
    public static void main(String[] args){
        LongestIncreasingSubSequence lg = new LongestIncreasingSubSequence();
        System.out.println(lg.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
