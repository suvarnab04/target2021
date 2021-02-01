package curatedlist.dynamicProgramming;

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
            for(int change =1;change< dp.length;change++){
                int min = -1;
                for(int c =0;c < coins.length; c++){
                    int coin = coins[c];
                    if(change - coin >= 0 ){
                        int remChange = dp[change-coin];
                        //i.e. we can not get a change for the remaining amount then we can not have change for the total amount
                        if(remChange >=0){
                            min = min ==-1? remChange +1  : Math.min(min, 1+ remChange)  ;
                        }
                    }
                }
                dp[change] = min ;
            }
            return dp[amount];
    }

    public static void main(String[] args){
        CoinChange ch = new CoinChange();
        System.out.println(ch.coinChange(new int[]{1},2));
    }
}
