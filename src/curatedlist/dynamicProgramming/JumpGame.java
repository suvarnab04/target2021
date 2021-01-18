package curatedlist.dynamicProgramming;
/*
https://www.youtube.com/watch?v=Zb4eRjuPHbM
https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastGoodIndex = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>= lastGoodIndex){
                lastGoodIndex = i;
            }
        }

        return lastGoodIndex == 0;
    }
}
