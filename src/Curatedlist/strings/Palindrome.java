package Curatedlist.strings;
/*
https://leetcode.com/problems/valid-palindrome/
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();

        StringBuilder str = new StringBuilder();

        for(int i=0;i< arr.length;i++){
            if(Character.isLetterOrDigit(arr[i])){
                str.append(arr[i]);
            }
        }
        String filterredString = str.toString();
        String rev = str.reverse().toString();

        return filterredString.equals(rev);
    }
}
