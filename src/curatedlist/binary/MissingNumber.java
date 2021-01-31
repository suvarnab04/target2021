package curatedlist.binary;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int i=0;
        while(i< nums.length){
            int j= nums[i];
            if(j > nums.length-1 || nums[i]== nums[j]){ // if the next index is out of bound or number is at right index then move to the next number
                i++;
            }else if(nums[i]!= nums[j]){
                //swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }
            // i++;
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
