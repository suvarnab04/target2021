package curatedlist.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://www.youtube.com/watch?v=4i6-9IzQHwo
 * https://backtobackswe.com/platform/content/longest-substring-without-repeating-characters/video
 *
 */
public class LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int start =0;
        int end = 0;
        int max =0;

        Set<Character> set = new HashSet();
        while(start< s.length() && end< s.length()){

            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
                max = Math.max(max, end-start);

            }else{

                set.remove(s.charAt(start));
                start++;

            }
            //end++;
        }
        return max;
    }
}
