package curatedlist.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
https://www.youtube.com/watch?v=PomVtsn7ZoM
 */
public class CombinationSum {

    public int combinationSum4(int[] nums, int target) {
        if(target == 0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        int result =0;
        for(int i=0;i< nums.length;i++){
            result = result + combinationSum4(nums,target-nums[i]);
        }
        return result;
    }
    public int combinationSumDP(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0] =1; // there is only only one way to get the sum 0 that is by not picking any of the numbers from nums[]
        for(int i=1;i<=target;i++){
            for(int j=0;j< nums.length;j++){
                int newTarget = i-nums[j];
                if(i-nums[j] >=0){
                    dp[i] = dp[i] + dp[i-nums[j]];
                }

            }
        }

        return dp[target];
    }
    public static void main(String[] args){
        CombinationSum cs = new CombinationSum();
       System.out.println( cs.combinationSumDP(new int[]{1,2,3}, 4));
    }
}
