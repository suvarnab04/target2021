package Problems;

import java.util.Arrays;

/*
Find Two Numbers that Add up to "n"
Solution 1: we can go over every element in arr1 and every element in arr2 and check the sum. The time complexity will be O(n sq)
Solution 2: We can sort the array in O(n log n) and then go over the sorted element to check the sum, that will be O(n) time
so the overall complexity will be O(n)
 */
public class CheckSum {
    public static void main(String[] args){
        int[] arr1 = {1, 21, 3, 14, 5, 60, 7, 6};
        int sum = 27;

        sort(arr1, 0, arr1.length-1);
        int [] nums = getSum(arr1, sum);
        System.out.println(Arrays.toString(arr1));
        System.out.print("Sum::" + sum +"\t");
        System.out.print(Arrays.toString(nums));


    }

    public static int[] getSum(int[] arr, int sum){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int tempSum = arr[i] + arr[j];
            if(tempSum < sum){
                i++;
            }else if(tempSum > sum){
                j--;
            }else{
                return new int[] {i,j};
            }
        }

        return arr;
    }
    public static void sort(int[] arr, int left, int right ){

            int pivot = partition(arr,left, right);
            if(left < pivot -1) {
                sort(arr, left, pivot - 1);
            }
            if(right> pivot+1) {
                sort(arr, pivot + 1, right);
            }


    }

    public static int partition(int[] arr, int low, int high ){
        int mid = (low + high)/2;

        while(low < high){
            while(arr[low] < arr[mid]){
                low++;
            }
            while(arr[high] > arr[mid]){
                high--;
            }
            if(arr[low] > arr[high]){
                int newlow = arr[high];
                arr[high] = arr[low];
                arr[low] = newlow;
                low++;
                high--;

            }
        }
        return low;
    }
}
