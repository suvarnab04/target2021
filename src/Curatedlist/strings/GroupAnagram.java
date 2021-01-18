package Curatedlist.strings;

import java.util.*;
/*
https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> results = new ArrayList();
        List<String> alreadySeen = new ArrayList();
        for(int i=0;i< strs.length;i++){
            if(!alreadySeen.contains(strs[i])){
                List<String> list = new ArrayList();
                list.add(strs[i]);
                alreadySeen.add(strs[i]);
                for(int j=i+1;j< strs.length;j++){
                    if(isAnagram(strs[i], strs[j])){
                        list.add(strs[j]);
                        alreadySeen.add(strs[j]);
                    }
                }
                results.add(list);
            }
        }

        return results;
    }
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        int[] schar = new int[128];
        int[] tchar = new int[128];

        for(int i=0;i< s.length();i++){
            schar[s.charAt(i)]++;
            tchar[t.charAt(i)]++;
        }
        for(int i=0;i< s.length();i++){
            if(schar[s.charAt(i)] != tchar[s.charAt(i)]){
                return false;
            }
        }
        return true;
    }
}
