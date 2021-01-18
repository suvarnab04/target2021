package Problems.slidingwindows;

import java.util.Arrays;

public class SubArray {

    //Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
    public static double[] findAverageOfSubArray(int[] array, int k){
            double[] results = new double[array.length-k+1];
            findAverageRec(array,k,0,results);
            return  results;
    }
    public static void findAverageRec(int[] array, int k, int currentIndex, double [] results){

        int sum = 0;

        for(int i=currentIndex ; i< (currentIndex+k);i++){

            sum += array[i];
        }
        results[currentIndex] = sum/5.0;

        if(currentIndex +k  < array.length) {
            findAverageRec(array, k, currentIndex + 1, results);
        }
    }
    public static double[] findAvgSlidingWin(int [] array, int k){
        double  windowSum=0;
        int winStart =0;
        double[] result = new double[array.length-k+1];
        for(int winEnd=0;winEnd<array.length;winEnd++){
            windowSum += array[winEnd];
            if(winEnd >= k-1){
                result[winStart] = windowSum/5;
                windowSum = windowSum - array[winStart];
                winStart++;
            }
        }
        return result;
    }
    public static int findMax(int[] array, int k){
        int max =0;
        int winStart =0;
        int sum =0;
        for(int winEnd =0;winEnd < array.length;winEnd++){
            sum += array[winEnd];
            if(winEnd >= k-1){
                max = Math.max(max, sum);
                sum = sum- array[winStart]; //subtract the first element of the window from the sum
                winStart++; //move the window by 1
            }

        }
      return max;
    }

    public static int findMinSubArray(int S, int[] array){
        int currSum =0;
        int winStart=0;
        int currMinSize = Integer.MAX_VALUE;

        for(int winEnd=0;winEnd< array.length;winEnd++){

            currSum += array[winEnd];

                while(currSum >= S){

                    currMinSize = Math.min(currMinSize, (winEnd-winStart)+1);
                    //move the window
                    currSum = currSum - array[winStart]; // as soon as we subtract the first number from the
                    // window the currSum will be less than sum and we will go to the next element
                    winStart++;

                }

        }
        return currMinSize == Integer.MAX_VALUE ? 0 : currMinSize;
    }
    public static int findMinSubArray1(int sum, int[] array){

        for(int i=1;i< array.length;i++){

            int count = findSmallestSubArrayHelper(array, sum, i);
            if(count>0){
                return count;
            }
        }
        return 0;
    }
    public static int findSmallestSubArrayHelper(int [] array, int sum, int subArraySize){
        int currSum =0;
        int winStart=0;

        for(int winEnd =0;winEnd< array.length;winEnd++){
            currSum+= array[winEnd];
            if(winEnd >= subArraySize-1){
                if(currSum >= sum){
                   return winEnd - winStart + 1;
                }
                currSum = currSum - array[winStart];
                winStart++;
            }
        }
        return 0;
    }

    public static void main(String[] args){

        int[] array={1, 3, 2, 6, -1, 4, 1, 8, 2};
        System.out.println(Arrays.toString(findAverageOfSubArray(array,5)));

        System.out.println(Arrays.toString(findAvgSlidingWin(array,5)));



        int[] input ={2, 1, 5, 1, 3, 2};
        System.out.println("Max sum is::" + findMax(input,3));

        int[] subArraySum = {3, 4, 1, 1, 6};
        System.out.println("Size of minimum subarray "+ findMinSubArray(8,subArraySum));

    }
}
