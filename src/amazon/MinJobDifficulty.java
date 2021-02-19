package amazon;
/*
https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

 */
public class MinJobDifficulty {
    public int minDifficulty(int[] jobDifficulty, int days) {

        int jobs = jobDifficulty.length;

        if (jobs < days){
            return -1;
        }
        int[] dp = new int[jobs + 1];



        for (int i = jobs - 1; i >= 0; --i)
            dp[i] = Math.max(dp[i + 1], jobDifficulty[i]);

        for(int i=0;i< dp.length;i++){
            System.out.print(dp[i]+",");
        }
        for (int day = 2; day <= days; ++day) {
            for (int i = 0; i <= jobs - day; ++i) {
               int maxd = 0;
                dp[i] = Integer.MAX_VALUE;
                for (int j = i; j <= jobs - day; ++j) {
                    maxd = Math.max(maxd, jobDifficulty[j]);
                    dp[i] = Math.min(dp[i], maxd + dp[j + 1]);
                }
            }
        }
        return dp[0];

    }
    public static void main(String [] args){
        MinJobDifficulty mjd = new MinJobDifficulty();
        mjd.minDifficulty(new int[]{11,111,22,222,33,333,44,444},6);
    }



}
