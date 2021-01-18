package Problems;

import java.util.Arrays;

public class MaxMin {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        //int[] arr = {1,2,3};
        findMaxMin(arr);
        System.out.println("array:"+ Arrays.toString(arr));
    }
        public static void findMaxMin(int[] arr){
            int max_cur = 0;
            int min_cur = 1;

            if(arr[1] > arr[0]){
                swap(arr, 0, 1);
            }

            boolean reachedEndOfArray = false;

            while(!reachedEndOfArray){
                int i=max_cur+1;
                int j=min_cur+1;

                while(i< arr.length){
                    if(arr[i] > arr[max_cur]){
                        swap(arr, max_cur, i);
                    }
                    i++;
                }
                while(j< arr.length){
                    if(arr[j] < arr[min_cur]){
                        swap(arr, min_cur, j);

                    }
                        j++;
                }
                max_cur = max_cur+2;
                min_cur = min_cur+2;
                if(max_cur == arr.length-1 || min_cur == arr.length-1){
                    reachedEndOfArray = true;
                }
            }

        }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }
}
