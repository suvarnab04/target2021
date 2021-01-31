package curatedlist.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * bottom up: https://www.youtube.com/watch?v=uHAToNgAPaM
 * topDown: https://www.youtube.com/watch?v=NFJ3m9a1oJQ&t=2s
 */
public class ClimbingStairs {
    public Map<Integer,Integer> cache = new HashMap();
    //bottom up
    public int climbStairsDP(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1 ; //there is only one way to get to step 0 i.e. to not climb the step
        dp[1] = 1; //there is only one way to get to step 1 i.e take 1 step

        for(int i=2;i<= n;i++){
            dp[i] = dp[i-1] + dp[i-2]; //at any step we can eaither reach by taking one step from previous step or take two steps
        }
        return dp[n];
    }
    public int climbStairsFibonacci(int n) {

        int num1 =0;
        int num2 =1;
        int i=0;
        int sum = 0;
        while(i<= n){
            sum = num1+num2;
            num2 = num1;
            num1 = sum;
            i++;
        }
        return  sum;

    }
    public int climbStairs(int n) {
        if(n==0){
            return 1;
        }
        if(n ==1){
            return 1;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }

        int steps =  climbStairs(n-1) + climbStairs(n-2);

        cache.put(n, steps);

        return cache.get(n);


    }
}
