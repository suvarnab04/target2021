package Curatedlist.strings;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */

public class LongestPalindrome {
    private int lo, maxLen;
    private String maxString= "";
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {

            extendPalindrome(s, i, i); //assume odd length, try to extend Palindrome as possible

            extendPalindrome(s, i, i+1); //assume even length.


        }
        System.out.println(maxString);
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int end, int start) {
        while (end >= 0 && start < s.length() && s.charAt(end) == s.charAt(start)) {
            end--;
            start++;
        }
        int length = start - end - 1;
        if (maxLen < length) {
            lo = end + 1;
            maxLen = length;
            maxString = s.substring(end+1, start);
        }
    }
    public static void main(String[] args){
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("cbbd"));
        //bacabab
    }
}
