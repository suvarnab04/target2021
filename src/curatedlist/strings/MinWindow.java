package curatedlist.strings;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow1(String src, String target) {
        int[] tarr = new int[26];
        for (int i = 0; i < target.length(); i++) {
            tarr[target.charAt(i)-'A']++;
        }

        int counter = target.length(), start = 0, end = 0, window = Integer.MAX_VALUE, head = -1;

        while (end < src.length()) {
            char endChar = src.charAt(end++);
            if (tarr[endChar -'A'] > 0) {
                counter--;
            }
            tarr[endChar -'A']--;

            while (counter == 0) {
                if (end - start < window) {
                    window = end - (head = start);
                }

                char startChar = src.charAt(start);
                if (tarr[startChar -'A'] == 0) {
                    counter++;
                }
                tarr[startChar -'A']++;
                start++;
            }
        }
        return head == -1 ? "" : src.substring(head, head + window);
    }
    public String minWindow(String s, String t) {

        Map<Character, Integer> targetMap = new HashMap();
        for(int i=0;i< t.length();i++){
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i),0)+1);
        }
        int start =0;
        int end =0;
        int windowLen = Integer.MAX_VALUE;
        String ans ="";
        Map<Character, Integer> windowMap = new HashMap();
        while(end < s.length()){
            // window not found, keep expanding
            while(end < s.length() && !isWindowMatchesTarget(targetMap, windowMap)){
                windowMap.put(s.charAt(end), windowMap.getOrDefault(s.charAt(end),0)+1);
                end++;
            }

            //window found, shrink remove the element from start
            while(isWindowMatchesTarget(targetMap, windowMap)){
                if(end -1-start+1 < windowLen){
                    windowLen = end -1-start+1;
                    ans = s.substring(start, end);
                }
                windowMap.put(s.charAt(start), windowMap.getOrDefault(s.charAt(start),0)-1);

                start++;
            }

        }


        return ans;
    }
    public boolean isWindowMatchesTarget(Map<Character, Integer> targetMap, Map<Character, Integer> windowMap ){
        for(Map.Entry<Character, Integer> entry : targetMap.entrySet()){
            char ch = entry.getKey();
            int count = entry.getValue();
            if(windowMap.getOrDefault(ch, 0) < count){
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
        MinWindow win = new MinWindow();
        System.out.println(win.minWindow("ADOBECODEBANC", "ABC"));
    }
}
