package curatedlist.arrays;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/contains-duplicate/
 */

public class ContainsDuplicate {

/* public boolean containsDuplicate(int[] nums) {

        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[i]== nums[j]){
                    return true;
                }
            }
        }
        return false;
    }*/

    //cyclic sort O(N)// thi will work if the numbers are 1-n

    /*public boolean containsDuplicate(int[] nums) {

        if(nums.length <=1){
            return false;
        }
        int i=0;
        while(i< nums.length){
            int j= nums[i]-1;
            if(nums[i] == nums[j]){
                return true;
            }else if(nums[i] != nums[j]){
                //swap
                swap(nums, i, j);
            }else{
                i++;
            }
        }
        return false;
    }
   public void swap(int[] arr, int i, int j){
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
   }*/
    //hashMap O(N)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}