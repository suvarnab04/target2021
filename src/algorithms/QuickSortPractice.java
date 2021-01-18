package algorithms;

public class QuickSortPractice {
    public static void main(String[] args){
        int[] nums = {5,2,9,3,8,4,0,1,6,7};
        quickSort(nums, 0, nums.length-1);

        for(int num : nums) {
            System.out.print(num+"\t");
        }
    }
    public static void quickSort(int[] nums, int left, int right){

        int pivot = getPivot(nums, left, right);
        if(left < pivot -1){
            quickSort(nums, left, pivot-1);
        }
        if(right > pivot+1){
            quickSort(nums, pivot+1, right);
        }
    }
    public static int getPivot(int [] nums, int left, int right){
        int pivot = nums[(left+right)/2];
        while(left < right){ // this will ensure you cover all the elements
            while(nums[left] < pivot){
                left++;
            }
            while(nums[right] > pivot){
                right--;
            }
            if(left < right){
                //swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}

