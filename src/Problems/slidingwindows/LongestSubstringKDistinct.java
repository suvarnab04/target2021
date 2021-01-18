package Problems.slidingwindows;

import java.util.HashSet;

import java.util.Set;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        Set<Character> charsSeenSoFar = new HashSet<>();
        char[] strs = str.toCharArray();
        int maxSize =Integer.MIN_VALUE;

        int winStart =0;
        int winEnd =0;
        while(winEnd < strs.length ) {

            if (charsSeenSoFar.size() < k) {
                charsSeenSoFar.add(strs[winEnd]);
            }

            if(charsSeenSoFar.contains(strs[winEnd])){
                maxSize = Math.max(maxSize, winEnd - winStart + 1);
                winEnd++;
            }else{
                charsSeenSoFar.clear();
                winStart++;
                winEnd = winStart;
            }

        }

        return maxSize == Integer.MIN_VALUE ? 0 : maxSize;
    }

    public static void main(String[] args){
        String input1 = "araaci";
      //  System.out.println("The longest substring with no more tha 1 distinct character::"+ findLength(input1,1));

        String input2 = "araaci";
      //  System.out.println("The longest substring with no more tha 2 distinct character::"+ findLength(input2,2));
        String input3 = "cbbebi";
        System.out.println("The longest substring with no more tha 3 distinct character::"+ findLength(input3,3));



    }
}
