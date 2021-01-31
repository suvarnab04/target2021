package ben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    /**
     * for each number find two more numbers such that sum of all three numbers is zero
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            twoSum(nums, i+1, nums[i] , result);
        }
        return result;
    }
    public void twoSum(int [] nums, int start, int firstNum,  List<List<Integer>> result ) {
        int end = nums.length - 1;
        while (start < end) {

            int curSum = nums[start] + nums[end] + firstNum;
            if (curSum == 0) {
                //add to  the list
                List<Integer> l = new ArrayList<>();
                l.add(firstNum);
                l.add(nums[start]);
                l.add(nums[end]);
                result.add(l);
                end--;
            } else if (curSum > 0) {
                end--;
            } else {
                start++;
                if(nums[start-1] == nums[start]){
                    start++;
                }
            }
        }

    }

    /**
     * sort the array
     * pick number from the start from the array and end of the array is sum of those two numbers is 0 then add them to the list
     * if sum of those two numbers is greater than zero that means we need a smaller number so we decrement the end
     * if sum is smaller than 0 that means we a need a bigger number to increase our sum, so we increment the start.
     * @param nums
     * @return
     */
    public List<List<Integer>> twoSum(int [] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();

            while (start < end) {

                    int sum = nums[start] + nums[end];
                    if (sum == 0) {
                        //add to  the list
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[start]);
                        l.add(nums[end]);
                        result.add(l);
                        end--;
                    } else if (sum > 0) {
                        end--;
                    } else {
                        start++;
                        if(nums[start-1] == nums[start]){
                            start++;
                        }
                    }
                }

return result;

    }
    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        /*List<List<Integer>> result = ts.twoSum(new int[]{-3, -1, 1, 0, 2, 10, -2, 8});
        for(List<Integer> list : result){
            System.out.print("<"+list.get(0)+","+list.get(1)+">,");
        }*/

        List<List<Integer>> results = ts.threeSum(new int[]{-3, -1, 1, 0, 2, 10, -2, 8});
        for(List<Integer> list : results){
            System.out.print("<"+list.get(0)+","+list.get(1)+","+ list.get(2)+">,");
        }
    }
}
