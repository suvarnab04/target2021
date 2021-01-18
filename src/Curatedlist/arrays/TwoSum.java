package Curatedlist.arrays;

import java.util.HashMap;
import java.util.Map;
/*
https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    //if array is sorted// time complexity O(N)
    /*public int[] twoSum(int[] nums, int target) {



        Arrays.sort(nums);

        int start =0;
        int end = nums.length-1;

        while(start< end){

            int sum = nums[start] + nums[end];

            if(sum == target){
                return new int[]{start, end};
            }else if(sum > target){
                end--;
            }else{
                start++;
            }
        }
        return new int[] {-1, -1};
    }*/

    //Complexity O(N*N)
    /*public int[] twoSum(int[] nums, int target) {

        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }*/

    //complexity O(N)
    public static int[] twoSum(int[] nums, int target) {
        //for each index calculate the remaining sum i.e target- nums[i] and store that in hash map,
        Map<Integer, Integer> map = new HashMap(); //map to store (target-nums[i], i)

        for(int i=0;i< nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target-nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
    public static void main(String[] args){
        int[] results = twoSum(new int[]{2,7,11,15}, 9);

        System.out.println(results[0] + "\t" + results[1]);

    }
}
