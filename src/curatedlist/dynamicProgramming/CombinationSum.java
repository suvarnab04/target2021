package curatedlist.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
https://www.youtube.com/watch?v=PomVtsn7ZoM
https://www.youtube.com/watch?v=IER1ducXujU
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        getCombinationSum(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    public void getCombinationSum(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target <0){
            return;
        }
        for(int i=start;i< candidates.length;i++){
            list.add(candidates[i]);
            getCombinationSum(candidates,i,target-candidates[i], list,result);
            list.remove(list.size()-1);
        }

    }

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
        for(int currTarget=1;currTarget<=target;currTarget++){
            for(int num=0;num< nums.length;num++){
                if(currTarget-nums[num] >=0){
                    dp[currTarget] = dp[currTarget] + dp[currTarget-nums[num]];
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
