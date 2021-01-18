package Curatedlist.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //buld a hashMap of num and its count
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList();

        for(int i=0;i< nums.length-2;i++){
            if(i==0 || i>0 && nums[i]!=nums[i-1]){
                int lo = i+1;
                int hi = nums.length-1;
                while(lo< hi){
                    int sum = 0-nums[i];
                    if(nums[lo]+ nums[hi] + nums[i] == 0){
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[lo]);
                        list.add(nums[hi]);

                        result.add(list);
                        while(lo<hi && nums[lo] == nums[lo+1]){
                            lo++;
                        }
                        while(lo<hi && nums[hi]== nums[hi-1]){
                            hi--;
                        }
                        lo++;
                        hi--;
                    }else if(nums[lo]+ nums[hi] > sum){
                        hi--;
                    }else{
                        lo++;
                    }
                }
            }
        }
        return result;
    }
}
