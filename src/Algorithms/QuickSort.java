package Algorithms;

public class QuickSort {
    public static void main(String [] args){
        int[] nums = {5,2,9,3,8,4,0,1,6,7};
        //int[] nums = {1,0,2};
        quickSort(0, nums.length-1, nums);

       for(int num : nums) {
           System.out.print(num+"\t");
       }

    }
    public static void quickSort(int left, int right, int[] nums){
        int pivot = partition(left, right,nums);
        if (left < pivot - 1) {
            quickSort(left, pivot - 1,nums);
        }
        if (right > pivot+1) {
            quickSort(pivot +1, right, nums);
        }
    }
    public static int partition(int low, int high, int[] nums){
        int pivot = nums[(low + high)/2];
        while(low < high){
            while(nums[low] < pivot){
                low++;
            }
            while(nums[high] >  pivot){
                high--;
            }
            if(low < high){
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
                low++;
                high--;
            }
        }
        return low;
    }

}
