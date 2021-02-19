package curatedlist.binary;
/*
https://leetcode.com/problems/missing-number/submissions/
https://www.youtube.com/watch?v=YMYVYSWL93w
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int i=0;
        while(i< nums.length){
            int j= nums[i];
            if(j< nums.length-1 && nums[i]!= nums[j]  ){ //numbers are within the range and not sorted
                //swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }else{
                i++;
            }
        }
        for(i=0;i< nums.length;i++){
            if(i!= nums[i]){
                return i;

            }
            // System.out.print(nums[i] +",");
        }

        return nums.length;
    }

    public static void main(String[] args){
        MissingNumber mn = new MissingNumber();
        System.out.println(mn.missingNumber(new int[]{3,0,1}));

    }
}
