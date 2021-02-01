package curatedlist.arrays;
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class StockBuySell {

    //brute force
   /* public int maxProfit(int[] prices) {

        int max = 0;
        for(int i=0;i< prices.length;i++){
            int buy= prices[i];
            for(int j=i+1;j< prices.length;j++){
                int sell = prices[j];

                if(sell> buy){
                    max = Math.max((sell-buy), max);
                }
            }

        }
        return max;
    }
    */
    //O(N)
    public int maxProfit(int[] prices) {
        int maxProfit =0;
        int i=0;
        int min=Integer.MAX_VALUE;
        //pick up a minimum value if the new value is less than min see so far the new value becomes the min
        //if the new value is greater than min see so far then calculate the profit, maxProfit keeps track of the maximum profit seen so far.

        while(i< prices.length){
            if(prices[i]< min){
                min = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i]- min);
            i++;
        }
        return maxProfit;
    }

    /**
     * test cases
     [7,1,5,3,6,4] 5
     [7,6,4,3,1]  0
     */

}
