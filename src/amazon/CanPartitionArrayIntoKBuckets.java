package amazon;

import java.util.HashMap;

/**
 * leetcode 416
 * https://www.youtube.com/watch?v=qpgqhp_9d1s&list=PLH62zle5HycBxWWIzqgUpG5ShvLC5vABN&index=5
 */
public class CanPartitionArrayIntoKBuckets {
    //equal partition
    public boolean canPartition(int[] nums){
        int total =0;
        for(int i=0;i< nums.length;i++){
            total += nums[i]; //sum of all numbers in the array
        }
        if(total%2 != 0){
            return false;
        }
        return canPartition(nums, 0, 0,total, new HashMap<String, Boolean>());
    }

    /**
     *
     * @param nums
     * @param index
     * @param currSum
     * @param totalSum
     * @param state
     * @return true if we can partition in two buckets
     */
    public boolean canPartition(int[] nums, int index, int currSum , int totalSum, HashMap<String,Boolean> state){
        String currState = index +""+currSum;

        if(state.containsKey(currState)){
            return state.get(currState);
        }
        if(currSum * 2 == totalSum){
            return true;
        }
        if(currSum > totalSum/2 || index >= nums.length-1 ){
            return false;
        }
        //pick the number or dont pick the number

        boolean found = canPartition(nums, index+1,currSum, totalSum, state)
                || canPartition(nums, index+1, currSum + nums[index], totalSum, state);
        state.put(currState, found);

        return found;
    }
    //can partition nums into k buckets of equal sum
    public boolean canPartition(int[] nums, int k){
        int total =0;
        for(int i=0;i< nums.length;i++){
            total += nums[i];
        }
        if(total% k != 0){
            return false;
        }
        return canPartitionIntoKBuckets(nums, k,0, 0,total/k, new boolean[nums.length]);
    }
    public boolean canPartitionIntoKBuckets(int[] nums,int bucket, int index, int currSum, int totalSum, boolean[] used){
        if(bucket ==1){
            return true; //we have filled other buckets that means the last bucket can also be filled
        }
        if(currSum == totalSum){
            return canPartitionIntoKBuckets(nums,bucket-1,0,0, totalSum,used);
        }
        for(int i=0;i< nums.length;i++){
            if(!used[i]){
                used[i] = true;
                if(canPartitionIntoKBuckets(nums, bucket,i, currSum+ nums[i], totalSum, used)){
                    return true;
                }
                used[i] = false; //unselect the number
            }
        }
        return false;
    }
}
