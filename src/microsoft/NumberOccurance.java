package microsoft;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/discuss/interview-question/1037927/Microsoft-Online-Assessment-Codility
 */
public class NumberOccurance {
    public int getOccurance(int[] nums){
        Map<Integer,Integer> occuranceMap = new HashMap<>();
        int count =0;
        for(int num : nums){
            occuranceMap.put(num, occuranceMap.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry :  occuranceMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(key == value){
                count++;
            }


        }
        return count;


    }
    public static void main(String[] args){
        NumberOccurance mo = new NumberOccurance();
        System.out.println(mo.getOccurance(new int[]{2,2,4,5,3,3,3}));
    }
}
