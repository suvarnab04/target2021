package Problems;
import DataStructures.Stack;

import java.util.Arrays;

class NextGreaterChallenge {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        for(int i=0; i< arr.length;i++){
            Stack<Integer> stack = new Stack((arr.length-1)-i);
            populateStack(arr, i, stack);
            int max = getNextMax(arr[i], stack);
            result[i] = max;

        }
        // Write -- Your -- Code
        return result;
    }
    public static void populateStack(int[] arr,int index,Stack<Integer> stack){

            for(int i=arr.length-1;i> index;i--){
            stack.push(arr[i]);
        }
    }
    public static int getNextMax(int curr, Stack<Integer> stack){
        while(!stack.isEmpty()){
            int pop = stack.pop();
            if(pop > curr){
                return pop;
            }
        }
        return -1;
    }
    public static  void main(String[] args){
        int[] arr ={4,6,3,2,8,1};
        int [] result = nextGreaterElement(arr);
        System.out.println(Arrays.toString(result));
    }
}