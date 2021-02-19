package microsoftOA;

import java.util.Arrays;
import java.util.Collections;

public class MinStepsToMakePilesEqualHeight {

    public static int minSteps(int[] input){
        if(input == null || input.length == 0 || input.length<2){
            return 0;
        }
        Arrays.sort(new int[][]{input}, Collections.reverseOrder());

        int minSteps = 0;

        for( int i=1; i<input.length; i++){
            if(input[i] < input[i-1]){
                minSteps += i;
            }
        }
        return minSteps;
    }

    public static void main(String[] args) {
        int[][] testcases = {{5, 2, 1},  {4,5,5,4,2}};
        for(int[] testcase: testcases)
            System.out.println(minSteps(testcase));
    }
}
