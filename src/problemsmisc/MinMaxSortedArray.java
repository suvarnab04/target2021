package problemsmisc;

import java.util.Arrays;

public class MinMaxSortedArray {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        //int[] arr = {1,2,3};
        findMaxMin(arr);
        System.out.println("Array:"+ Arrays.toString(arr));
    }
    //creating a new array, space complexity is
    public static void findMaxMin(int[] arr) {
        int cur_min = 0;
        int cur_max = arr.length -1;
        int [] result = new int[arr.length];
        int k=0;
        while(cur_min < cur_max){
            result[k++] = arr[cur_max--];
            result[k++] = arr[cur_min++];
        }
        result[k] = arr[cur_min];
        System.out.println("result:"+ Arrays.toString(result));
        for(int i=0;i< arr.length;i++){
            arr[i] = result[i];
        }


    }
    public static void findMaxMinOptimum(int[] arr) {
        //O(1), saving only the next element
        for (int i = 0; i < arr.length; i++){
            int minNext= arr[i+1];
            int min = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[i+1] = min;
            i++;
        }
    }
}
