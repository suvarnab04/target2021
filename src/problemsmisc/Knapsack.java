package problemsmisc;

public class Knapsack {
    public int solveKnapsack(int[] profits, int[] weights, int maxWeight){

        int[][] dp = new int[weights.length+1][maxWeight+1];
        //weights.length+1 will give us cushioning at the top with 0s so that we dont go out of bound
        int items = weights.length;

       for(int item =1;item<= items; item++) {
           for (int maxW = 1; maxW <= maxWeight; maxW++) {
               int weight = weights[item-1];
               int profit = profits[item-1];
               if(item==0 || maxW==0){
                   dp[item][maxW] =0;
               }
               else if ( maxW >= weight) {
                   //select the item or not select the item, if we select the item the check the previous item as well
                   //Math.Max((item not selected so use the previous item))
                   dp[item][maxW] =Math.max(dp[item-1][maxW],profit + dp[item-1][maxW-weight]);
               }else {
                   dp[item][maxW] = dp[item - 1][maxW];
               }
           }
       }
       for(int  item =0;item<= weights.length;item++){
           System.out.println();
           for(int maxW= 0;maxW<= maxWeight; maxW++){
               System.out.print(dp[item][maxW] +" ");

           }
       }
       return dp[weights.length][maxWeight];
    }



    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {60,50,70,30};
        int[] weights = {5,3,4,2};
        int maxProfit = ks.solveKnapsack(profits, weights, 5);
        System.out.println("Total knapsack profit ---> " + maxProfit);

    }
}
