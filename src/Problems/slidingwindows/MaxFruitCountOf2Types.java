package Problems.slidingwindows;

import java.util.HashSet;
import java.util.Set;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int currentMax = Integer.MIN_VALUE;
        int winStart=0;
        int winEnd =0;
        Set<Character> fruitsPicked = new HashSet<>();
        while(winEnd < arr.length){

            if(fruitsPicked.size() < 2){
                fruitsPicked.add(arr[winEnd]);
            }

            if(fruitsPicked.contains(arr[winEnd])){
                currentMax = Math.max(currentMax, winEnd-winStart+1);
                winEnd++;
            }else{
                fruitsPicked.remove(arr[winStart]);
                winStart++;
                //winEnd= winStart;
            }

        }
        return currentMax == Integer.MIN_VALUE ? 0: currentMax;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
