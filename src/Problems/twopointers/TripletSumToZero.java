package Problems.twopointers;

import java.util.*;

public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {


        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i< arr.length;i++){
            if(i>0 && arr[i] == arr[i-1]){ //current char is same as previous char then skip
                continue;
            }
            searchPair(-(arr[i]),arr, i+1, results);
        }



        return results;
    }
    public static void searchPair(int targetSum, int [] arr, int start,List<List<Integer>> results ){
            int end = arr.length-1;
            while(start< end){
                int sum = arr[start] + arr[end];
                if(sum > targetSum){
                    end--;
                }if(sum< targetSum){
                    start++;
                }else if(sum == targetSum){
                    //triplet found;
                    int first = -(targetSum);
                    int sec = arr[start];
                    int thrd = arr[end];
                    List<Integer> triplet = new LinkedList<>();
                    triplet.add(first);
                    triplet.add(sec);
                    triplet.add(thrd);
                    results.add(triplet);
                    //increment start but check if the next element is not same as the current, to avoid duplicate
                   start++;
                   end--;
                    while(start< end && arr[start] == arr[start-1]){
                        start++; //to check the remaining elements but skip the duplicates
                    }
                    while(start< end && arr[end] == arr[end+1]){
                        end--; // to check the remaining elements but skip the duplicates
                    }
                }
            }
    }
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);

        int smallestDifference = Integer.MAX_VALUE;
        for(int i=0;i< arr.length;i++){
            int start = i+1;
            int end= arr.length-1;

            while(start< end){
                //triplet  arr[i], arr[start] arr[end]

                int tripletSum = arr[i] + arr[start] + arr[end];
                int targetDiff = targetSum - tripletSum;

                if(targetDiff == 0){
                    return tripletSum; //sum of all triplets which is same as the targetSum
                }
                if(targetDiff > 0){
                    start++;
                }else{
                    end--;
                }

                smallestDifference = Math.min(Math.abs(smallestDifference), Math.abs(targetDiff));

            }
        }
        return targetSum-smallestDifference;
    }
    public static void dutchNotionalFlag(int[] arr){

      /*  int currMin =0;
        int currMinIndex =0;

        while(currMinIndex < arr.length){

            for(int j=currMinIndex; j< arr.length;j++){
                    if(arr[j] == currMin){
                       //swap
                        int temp = arr[j];
                        arr[j] = arr[currMinIndex];
                        arr[currMinIndex] = temp;
                        currMinIndex++;
                    }
            }
            currMin++;
        }*/
        int start =0;
        int end= arr.length-1;
        int min=0;
        int max= 2;

        while(start< end){
            while(arr[start] == min) {
                start ++;
            }
            while(arr[end] == max){
                end--;
            }

            //swap
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            if(arr[start] == arr[end]){
                start++;
                end--;
            }
        }
    }
    public static void swap(int [] arr, int start, int end){
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
       // System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));

        System.out.println(TripletSumToZero.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));

       // int[] arr = {1,0,2,1,0};
        int[] arr = {2,2,0,1,2,0};
        System.out.println("dutch notional flag input::"+Arrays.toString(arr));
        TripletSumToZero.dutchNotionalFlag(arr);
        System.out.println("dutch notional flag output::"+Arrays.toString(arr));
    }
}
