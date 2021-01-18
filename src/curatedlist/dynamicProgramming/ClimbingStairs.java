package curatedlist.dynamicProgramming;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {

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
    public int climbStairsRec(int n) {
        if(n==0 || n ==1){
            return 1;
        }

        return  climbStairs(n-1) + climbStairs(n-2);

    }
}
