package Problems;

public class LargestBranch {
    public void largestBranch(int [] arr){

        int i=0;
        int left =1;
        int right= 2;
        int leftSum =0;
        int rightSum =0;

        leftSum = getTreeSum(arr, 1);
        rightSum = getTreeSum(arr, 2);
        if(leftSum == rightSum){
            System.out.println("");
        }else if(leftSum> rightSum){
            System.out.println("Left");
        }else{
            System.out.println("Right");
        }


    }
    public int getTreeSum(int[] arr,int parentIndex){

        if(parentIndex > arr.length-1 || arr[parentIndex] ==-1) {
        return  0;
        }
        int leftChild = 2*parentIndex+1;
        int rightChild = 2* parentIndex+2;
        int sum =0;
        if(parentIndex< arr.length)
            sum = arr[parentIndex] + getTreeSum(arr, leftChild) + getTreeSum(arr, rightChild);

        return sum;

    }
}
