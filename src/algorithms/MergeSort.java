package algorithms;

public class MergeSort {
    public static void main(String[] args){
        int[] nums = {5,2,9,3,8,4,0,1,6,7};
        //int[] nums = {1,0,2,5};
        mergeSort(nums,0, nums.length-1);

        for(int num : nums) {
            System.out.print(num+"\t");
        }
    }
    public static void mergeSort(int[] nums, int left, int right){
        if(left < right) { //divide into two subarray till the size is 1, left=right when there is only one element present
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

    }
    public static void merge(int [] nums, int left, int mid, int right){

        //get the number of elements in the left and right subarray
        /* the left array was created with elements from left to mid so the number of elements in this array can be
         calculated as (mid - left) +1 as size is one greater than the index, size of an array is +1 than the last index of the array
         for eg int [] nums ={2,9,5,4,8,1,6}, a[0]=2, a[1]=9, a[2]=5,a[3]=4,a[4]=8, a[5]=1,a[6]=6
          left= 0, right =6, mid = (0+6)/2= 3
          leftArray = elements from left till mid, right array = mid+1 till right
          leftArray =[2,9,5,4] rightArray =[8,1,6]
          leftArraySize = mid - left +1 = 3-0+1 = 4
          rigth array size = right- (mid+1)+1 = right - mid = 6-3= 3

        */
        int leftArraySize = mid - left +1;
        int rightArraySize = right - mid;

        int[] tempLeftArray = new int[leftArraySize];
        int[] tempRightArray = new int[rightArraySize];

        //copy data to the temp arrays so that we can compare the elements

        for(int i =0; i<leftArraySize;i++){
            tempLeftArray[i] = nums[left+i];
        }
        for(int j =0; j< rightArraySize;j++){
            tempRightArray[j] = nums[(mid+1)+j];
        }
        //traverse the elements in the temp arrays and put at correct place in the original array
        int i=0, j=0;
                //k=left;

        while(i< leftArraySize && j< rightArraySize){
            if(tempLeftArray[i] < tempRightArray[j]){
                nums[left] = tempLeftArray[i];
                i++;
            }else{
                nums[left] = tempRightArray[j];
                j++;
            }
            left++;
        }
        //if there are more elements remaining to compare in tempLeftArray/tempRightArray
        while(i < leftArraySize ){
            nums[left] = tempLeftArray[i];
            i++;
            left++;

        }
        while(j < rightArraySize ){
            nums[left] = tempRightArray[j];
            j++;
            left++;

        }
    }
}
