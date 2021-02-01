package curatedlist.strings;
/*
https://www.youtube.com/watch?v=00FmUN1pkGE
https://leetcode.com/problems/longest-repeating-character-replacement/
https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int start = 0 ;
        int maxLength =0;
        int maxCount =0;
        int[] counts = new int[26];

        for(int end =0 ; end< s.length(); end++){
            int currCharCount = counts[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, currCharCount );
            if(end- start + 1 - maxCount > k ){
                counts[s.charAt(start) - 'A']--;
                start++;

            }
            maxLength = Math.max(maxLength, end-start+1);

        }

        return maxLength;
    }
}
