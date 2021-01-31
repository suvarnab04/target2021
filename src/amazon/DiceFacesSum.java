package amazon;

import java.util.HashMap;
import java.util.Map;
/*
https://www.youtube.com/watch?v=hKAZ929nnqc
https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class DiceFacesSum {
    Map<String, Integer> map = new HashMap<>();

    public int numRollsToTarget(int d, int f, int target) {


        if(d ==0 && target ==0){
            return 1;
        }
        if(target<0 || target > d*f ){
            return 0;
        }

        String key = ""+ d+f+ target;
        if(!map.containsKey(key)){
            int sum =0;
            for(int i =1 ;i <= f; i++){
                sum += numRollsToTarget(d-1, f, target-i);
                sum %= 1000000007;
            }
            map.put(key , sum);
        }

        return map.get(key);
    }
    public int numRollsToTargetdp(int d, int f, int t) {
        int[][]dp = new int[d+1][t+1];
        dp[0][0] =1;

        for(int dice=1;dice<=d;dice++){ //dice

            for(int target=0; target<=t;target++){ //calculate the value for d[row][col]

                for(int face=1;face<=f;face++){
                    if(target >= face) {
                        dp[dice][target] = dp[dice][target] + dp[dice - 1][target - 1];
                    }

                }
            }


        }


        return dp[d][t];

    }

    public static void main(String [] args){
        DiceFacesSum ds = new DiceFacesSum();
        System.out.println(ds.numRollsToTarget(2, 6, 7));
    }

}
