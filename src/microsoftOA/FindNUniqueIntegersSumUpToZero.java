package microsoftOA;
/*
https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 */
public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] nums = new int[n];
        if(n%2==0){
            fillArray(nums, n-1);

        }else{
            fillArray(nums, n-2);
            nums[n-1] = 0;
        }
        return nums;

    }
    public void fillArray(int[] nums,int max){
        int count=0;
        int j=1;
        while(count<=max){
            nums[count++] = j;
            nums[count++] = (-j);
            j++;
        }
    }
}
