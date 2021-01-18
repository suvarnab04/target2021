package problemsmisc.slidingwindows;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {

    public static int findLength(String str) {
        int currMax = Integer.MIN_VALUE;
        int winStart=0;
        int winEnd = 0;
        char[] strs = str.toCharArray();
        Set<Character> charsSeenSoFar = new HashSet<>();
        while(winEnd < strs.length ){

            if(charsSeenSoFar.contains(strs[winEnd])){ // repetative char
                charsSeenSoFar.remove(strs[winStart]);
                winStart++;
            }else{
                charsSeenSoFar.add(strs[winEnd]);
                currMax = Math.max(currMax, charsSeenSoFar.size());
                winEnd++;
            }
        }
        return currMax;
    }
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
