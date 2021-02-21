package microsoftOA;

import java.util.Arrays;
import java.util.List;

public class PartitionArrayIntoKWithEqualSum {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total =0;
        for(int i=0;i< nums.length;i++){
            total += nums[i];
        }
        if(total% k != 0){
            return false;
        }
        Arrays.sort(nums);
        return canPartitionIntoKBuckets(nums, k,nums.length-1, 0,total/k, new boolean[nums.length]);

    }
    public boolean canPartitionIntoKBuckets(int[] nums,int bucket, int index, int currSum, int totalSum, boolean[] used){
        if(bucket ==0){
            return true; //we have filled other buckets that means the last bucket can also be filled
        }
        if(currSum == totalSum && canPartitionIntoKBuckets(nums,bucket-1,nums.length-1,0, totalSum,used)){
            return true;
        }
        for(int i=index;i>= 0;i--){
            if(!used[i] && currSum+nums[i] <= totalSum){
                used[i] = true;
                //(i-1) will check the next item
                //currSum+num[i] adding the current item to the bucket

                if(canPartitionIntoKBuckets(nums, bucket,i-1, currSum+ nums[i], totalSum, used)){
                    return true;
                }

                used[i] = false; //unselect the number
            }
        }
        return false;
    }
    public static void main(String[] args){
        PartitionArrayIntoKWithEqualSum p = new PartitionArrayIntoKWithEqualSum();
       boolean ans = p.canPartitionKSubsets(new int[]{5,2,5,5,5,5,5,5,5,5,5,5,5,5,5,3},15);
       System.out.println(ans);

    }

}
