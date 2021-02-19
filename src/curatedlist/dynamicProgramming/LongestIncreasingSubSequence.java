package curatedlist.dynamicProgramming;

import java.util.Arrays;

/*
https://backtobackswe.com/platform/content/longest-nondecreasing-subsequence/video
https://www.youtube.com/watch?v=fV-TF4OvZpk
https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];

        Arrays.fill(dp,1);
        int globalMax =1;
        for(int current=1;current< nums.length; current++ ){
            int max =1;
            for(int i=0;i<current;i++){
                if(nums[current]> nums[i]){ // strictly increasing
                    max = Math.max(dp[i]+1,max );
                }
            }
            dp[current] =max;
            globalMax = Math.max(globalMax,max);
        }
        return globalMax;
    }
    public static void main(String[] args){
        LongestIncreasingSubSequence lg = new LongestIncreasingSubSequence();
        System.out.println(lg.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
