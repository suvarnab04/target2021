package Problems.slidingwindows;

import java.util.HashSet;
import java.util.Set;

public class CharacterReplacement {

    public static int findLength(String str, int k) {
        int maxLength = Integer.MIN_VALUE;
        int winStart =0;
        int winEnd =0 ;
        char[] strs = str.toCharArray();

        char charToCheck ='\0';
        int skipChar = 0;

        while(winEnd< strs.length){

                charToCheck = strs[winStart];

                 if( strs[winEnd] == charToCheck){
                       winEnd++; //s

                 }else if(skipChar < k){
                    //skip k chars
                    winEnd++;
                    skipChar++;
                 }else{

                    winStart++;
                     winEnd = winStart;
                     skipChar = 0;
                }
                maxLength = Math.max(maxLength,winEnd-winStart);
            }


        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
        System.out.println(CharacterReplacement.findLength("01100011011", 2));
    }
}
