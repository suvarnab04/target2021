package Curatedlist.dynamicProgramming;

import java.util.Arrays;
/*
https://leetcode.com/problems/coin-change/
https://www.youtube.com/watch?v=jgiZlGzXMBw
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int [] dp = new int[amount+1];

        dp[0] =0;

        for(int i =1;i< dp.length;i++){
            filldp(i,dp, coins, amount);

        }
        return dp[dp.length-1];
    }
    public void filldp(int dpIndex,int[] dp, int[] coins, int amount){
        int min = -1;
        for(int i=0;i< coins.length;i++){
            int coinPicked = coins[i];
            if(dpIndex-coinPicked >= 0 ){
                int temp = dp[dpIndex-coinPicked];
                if(temp!=-1){
                    min = min <0 ? temp+1 : Math.min(min,temp+1);
                }
            }
        }
        dp[dpIndex] = min;

    }
    public static void main(String[] args){
        CoinChange ch = new CoinChange();
        System.out.println(ch.coinChange(new int[]{1},2));
    }
}
