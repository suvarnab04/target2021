package curatedlist.strings;
/*
https://leetcode.com/problems/valid-palindrome/
https://www.youtube.com/watch?v=3RQ5ADUKHsY
 */
public class Palindrome {
    //better aaproach
    public boolean isPalindrome(String s) {

        int start=0;
        int end = s.length()-1;
        while(start< end){
            while(start< end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start< end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if(start< end && Character.toLowerCase(s.charAt(start))!= Character.toLowerCase(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public boolean isPalindrome1(String s) {
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
