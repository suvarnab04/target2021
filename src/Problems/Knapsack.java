package Problems;

public class Knapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity){
        return knapSackRec(profits, weights, capacity,0);
    }
    public int knapSackRec(int[] profits, int [] weights, int capacity, int currentIndex){

        if(currentIndex == 0){
            return 0;
        }
        int profit1 =0;
        //if(weights[currentIndex])
       // profit1 =
    return 0;
    }


    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);

    }
}
