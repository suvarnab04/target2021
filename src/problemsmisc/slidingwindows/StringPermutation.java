package problemsmisc.slidingwindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutation {

    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> patternCharCountMap = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
              patternCharCountMap.put(c, patternCharCountMap.getOrDefault(c,0)+1);
        }

        char[] strs = str.toCharArray();
        int start=0;

        int matchCount=0;
        for( int end =0;end < strs.length; end++ ){
            char currentChar = strs[end];
            //if the char is present in the map the decrement the count for it,
            //if the count after decrementing is 0 that means we have found a match for the char
            //if match is equal to the sixe of the map that means we have see all the chars in the pattern


            if(patternCharCountMap.containsKey(currentChar) ){
                patternCharCountMap.put(currentChar, patternCharCountMap.get(currentChar)-1);
                if(patternCharCountMap.get(currentChar)==0){
                    matchCount++;
                }
            }
            if(matchCount == patternCharCountMap.size()){
                return true;
            }
            //slide the window
            if(end >= pattern.length()-1){
                char prevChar = strs[start];
                if(patternCharCountMap.containsKey(prevChar)){
                    if(patternCharCountMap.get(prevChar)==0) {
                        matchCount--;
                    }
                    patternCharCountMap.put(prevChar, patternCharCountMap.get(prevChar)+1);
                }
                start++;
            }
            //if no match found end will go to the next char in the strs.

        }

        return matchCount >0 ? true : false;
    }
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> list = new ArrayList<>();
        //1. create a map of count of the characters in the pattern
        Map<Character, Integer> charCountMap = new HashMap<>();
        for(int i=0;i< pattern.length();i++){
            char c = pattern.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c,0)+1);
        }
        char[] strs = str.toCharArray();
        int start=0;
        int end=0;
        //1. traverse the str
        while(end < strs.length){
            //if the char is no in the map the skip the char
            char currChar = strs[end];

            int currCharCountInMap = charCountMap.getOrDefault(currChar,0);

            if(currCharCountInMap > 0){
                //if char is present in the map then decrement its count.
                charCountMap.put(currChar,charCountMap.getOrDefault(currChar,0)-1);
            }else{
                start++;
                end = start;

            }
        }
        return list;
    }

    public static void main(String[] args){
       System.out.println("Is permutation present::" + findPermutation("aaacb", "acb"));
     //   System.out.println("Is permutation present::" + findPermutation("bcdxabcdy", "bcdyabcdx"));
       // System.out.println("Is permutation present::" + findPermutation("odicf", "dc"));
      //  System.out.println("Is permutation present::" + findPermutation("oidbcaf", "abc"));
    }
}
