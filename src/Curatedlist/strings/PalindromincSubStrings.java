package Curatedlist.strings;
/*
https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromincSubStrings {
    private int count =0;
    public int countSubstrings(String s) {

        for(int i=0;i< s.length();i++){
            extendPalin(s, i, i);
            extendPalin(s, i+1,i);
        }
        return count;
    }
    public void extendPalin(String s, int start, int end){
        while(start< s.length() && end>=0 && s.charAt(start) == s.charAt(end)){
            count++;
            start++;
            end--;
        }
    }
}
