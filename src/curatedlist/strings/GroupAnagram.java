package curatedlist.strings;

import java.util.*;
/*
https://leetcode.com/problems/group-anagrams/
https://www.youtube.com/watch?v=ptgykfAEax8
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList();
       Map<String, List<String>> anagramMap = new HashMap<>();
       for(String str : strs){
           char[] chars = str.toCharArray();
           Arrays.sort(chars);
           String sorted = new String(chars);

           List<String> anagrams =anagramMap.getOrDefault(sorted, new ArrayList<>());
           anagrams.add(str);

           anagramMap.put(sorted,anagrams);

       }
        results.addAll(anagramMap.values());
       return results;
    }

}
