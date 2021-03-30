package algorithms;

public class FindDuplicate {
   int duplicate =-1;
        /*public int findDuplicate(int[] nums) {

            for(int i=0;i< nums.length;i++){
                int index = Math.abs(nums[i]) -1;
                if(nums[index] <0){
                    return Math.abs(nums[i]);
                }
                nums[index] = -1 * nums[index];
            }
            return -1;
        }*/
        public int findDuplicate(int[] nums) {
             quickSort(nums, 0, nums.length-1);
             return duplicate;
        }
        void quickSort(int[] nums, int left, int right){

            if(left < right){
                int partition = partition(nums, left, right);
                if( (partition+1<=right && nums[partition] == nums[partition+1]) || (partition-1>=left && nums[partition]== nums[partition-1])){
                    duplicate = nums[partition];
                    return ;
                }

                if(nums[partition]-1 == partition){

                     quickSort(nums, partition+1, right);
                }else{


                      quickSort(nums, left, partition-1);
                }


            }

        }
        int partition(int[] nums, int left,int right){
            int pivot = left;
            left= left+1;
            while(left< right){
                while(left<=right && nums[left]< nums[pivot]){
                    left++;
                }
                while(left<=right && nums[right]> nums[pivot]){
                    right--;
                }
                if(left< right && nums[left]> nums[right]){
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }
            if(nums[right]< nums[pivot]){
                swap(nums, right, pivot);
            }
            return right;
        }
        public void swap(int[] nums, int left, int right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right]= temp;
        }
        public static void main(String[] args){
            FindDuplicate fd = new FindDuplicate();
            //[3,1,3,4,2]
            System.out.println("duplicate::" +fd.findDuplicate(new int[]{1,3,4,2,2}));
            System.out.println("duplicate::" +fd.findDuplicate(new int[]{3,1,3,4,2}));
        }
    }
