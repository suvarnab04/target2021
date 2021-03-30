    package algorithms;
/*
10256 2986 8609 5162 4637 6932 5954 2825 4264 10177 1796 3125 2813 3877 pivot::13

3877 2986 8609 5162 4637 6932 5954 2825 4264 10177 1796 3125 2813 10256
pivot::6

3877 2986 2813 3125 1796 2825 5954 6932 4264 10177 4637 5162 8609 10256
pivot::10

3877 2986 2813 3125 1796 2825 5954 4637 4264 5162 6932 10177 8609 10256
pivot::8

 */
    public class QuickSort {
        public static void main(String[] args){
            int[] nums = {10256,2986,8609,5162,4637,6932,5954,2825,4264,10177,1796,3125,2813,3877};
            quickSort(nums, 0, nums.length-1);
           System.out.println();
            for(int num : nums) {
                System.out.print(num+"\t");
            }
        }
        public static void quickSort(int [] arr, int left, int right){
            if(left< right){
                int pivot = partition(arr, left, right);
                System.out.print("pivot::"+ arr[pivot] +" ");
                quickSort(arr, left, pivot-1);
                quickSort(arr, pivot+1, right);
            }
        }


        public  static  void swap(int A[],int i,int j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
        }

        public static int partition(int A[],int left,int right) {
            int pivot = left;
            left = left +1;

            while(left <= right) {
                while(left<=right && A[pivot] >= A[left]) {
                    left++;
                }
                while(right>=left && A[pivot] < A[right]) {
                    right--;
                }
                if(left < right) {
                    swap(A,left++,right--);
                }
            }
            if(A[pivot] > A[right]){
                swap(A,right,pivot);
                return right;
            }
            return pivot;
        }
        public static void quickSortMid(int[] arr, int left, int right) {
            if (arr == null || arr.length == 0)
                return;

            if (left >= right)
                return;

            // pick the pivot
            int middle = left + (right - left) / 2;
            int pivot = arr[middle];

            // make left < pivot and right > pivot
            int i = left, j = right;
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }

                while (arr[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }

            // recursively sort two sub parts
            if (left < j)
                quickSortMid(arr, left, j);

            if (right > i)
                quickSortMid(arr, i, right);
        }


    }

