package Problems.twopointers;

public class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
       // int[] result = new int[2];
        int start=0;
        int end = arr.length-1;
        int sum =0;
        while(start < end){
            sum = arr[start] + arr[end];
            if(sum > targetSum){
                end--;
            }else if(sum < targetSum){
                start++;
            }else{

                return new int []{start, end};
            }
        }
    return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
