package curatedlist.strings;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * https://www.youtube.com/watch?v=y2BD4MJqV20
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

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int length = right - left - 1;
        if (maxLen < length) {
            lo = left + 1;
            maxLen = length;
            maxString = s.substring(left+1, right);
        }
    }
    public static void main(String[] args){
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("cbbd"));
        //bacabab
    }
}
