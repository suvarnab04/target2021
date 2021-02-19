package linkedIn;
/*
https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */
public class FindSmallestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char ch : letters){
            if(ch - target >0){
                return ch;
            }
        }
        return letters[0];

    }
}
