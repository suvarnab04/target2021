package Curatedlist.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
top down https://www.youtube.com/watch?v=LPs6Qo5qlJM
https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    private Map<String, Boolean> map = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
            if(wordDict.contains(s)){
                return true;
            }
            if(map.containsKey(s)){ // this string was already seen
                return map.containsKey(s);
            }
            for(int i=1;i<= s.length();i++){
                String left = s.substring(0,i);
                String right = s.substring(i);
                if(wordDict.contains(left) && wordBreak(right, wordDict)){
                    map.put(s,true);
                    return true;
                }
            }
            map.put(s, false);
            return false;
    }


    public static void main(String[] args){
        WordBreak wb = new WordBreak();
        String s="cars";
        List<String> l = new ArrayList();
        l.add("car");
        l.add("ca");
        l.add("rs");
        System.out.println(wb.wordBreak(s, l));
    }
}
