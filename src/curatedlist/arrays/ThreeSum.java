package curatedlist.arrays;

import java.util.*;
/*
Method 1: extend two sum to get three sum
Method 2: Two pointers -use HashSet to handle duplicates
Method 3: Two pointers - handle duplicates in the code by skipping the index if nums[i] == nums[i-1] or
nums[start]== nums[start+1] or nums[end] = nums[end-1]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum1(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList();

        for(int i=0;i< nums.length-2;i++){
            if(i==0 || i>0 && nums[i]!=nums[i-1]){ //to handle duplicate numbers
                int start = i+1;
                int end = nums.length-1;

                while(start< end){

                    int sum = nums[i] + nums[start]+ nums[end];

                    if(sum == 0){

                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[start]);
                        list.add(nums[end]);

                        result.add(list);
                        while(start<end && nums[start] == nums[start+1]){
                            start++;
                        }
                        while(start<end && nums[end]== nums[end-1]){
                            end--;
                        }
                        start++;
                        end--;
                    }else if(sum > 0){
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }
        return result;
    }
    /**
     using HashSet() to handle duplicates
     */

    public List<List<Integer>> threeSum(int[] nums) {
        //buld a hashMap of num and its count
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet();

        for(int i=0;i< nums.length-2;i++){
            if(i==0 || i>0 && nums[i]!=nums[i-1]){ //to handle duplicate numbers
                int start = i+1;
                int end = nums.length-1;

                while(start< end){

                    int sum = nums[i] + nums[start]+ nums[end];

                    if(sum == 0){

                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[start]);
                        list.add(nums[end]);

                        result.add(list);

                        start++;
                        end--;
                    }else if(sum > 0){
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }
        return new ArrayList(result);
    }
}
