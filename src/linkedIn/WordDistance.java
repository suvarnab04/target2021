package linkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/shortest-word-distance-ii/
 */
public class WordDistance {
    Map<String, List<Integer>> map = new HashMap();

    public WordDistance(String[] words) {
        for(int i=0; i< words.length;i++){
            List<Integer> list = map.getOrDefault(words[i], new ArrayList());
            list.add(i);
            map.put(words[i],list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> index1 = map.get(word1);

        List<Integer> index2 = map.get(word2);
        int min = Integer.MAX_VALUE;

        for(int l1 : index1){
            for(int l2 : index2){
                int curr = Math.abs(l1-l2);
                min = Math.min(min, curr);
            }
        }
        return min;
    }
}
