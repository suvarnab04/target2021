package microsoftOA;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class MaximumLengthOfConcatenatedStringWithUniqueChar {

    public int maxLength(List<String> arr) {
        List<String> seenSoFar = new ArrayList<>();
        seenSoFar.add("");
        int lengthSeen =0;
        for (String str : arr) {
            if (!isUnique(str)){
                continue;
            }
            List<String> currList = new ArrayList<>();
            /**
             * for each string in the result append the new string,
             *
             * if the appended string is unique then that will be part of the result
             */
            for (String seen : seenSoFar) {
                String appended = seen + str;

                if (isUnique(appended)){
                    lengthSeen = Math.max(lengthSeen, appended.length());
                    currList.add(appended);
                }
            }
            seenSoFar.addAll(currList);
        }

        return lengthSeen;
    }
    private boolean isUnique(String str) {
        if (str.length() > 26) return false;
        Set<Character> seen = new  HashSet();

        for (int i=0;i< str.length();i++) {
            if (seen.contains(str.charAt(i))){
                return false;
            }
            seen.add(str.charAt(i));

        }
        return true;
    }
    public static void main(String[] args){
        List<String> arr = new ArrayList<>();
        arr.add("cha");
        arr.add("r");
        arr.add("act");
        arr.add("ers");
       //arr.add("a");
        MaximumLengthOfConcatenatedStringWithUniqueChar m = new MaximumLengthOfConcatenatedStringWithUniqueChar();
        System.out.println(m.maxLength(arr));
    }
}
