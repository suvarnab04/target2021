package curatedlist.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> adjList = new HashMap();
        for(String word : words){

            for(int i=0;i< word.length()-1;i++){
                char curr = word.charAt(i);
                char next = word.charAt(i+1);
                if(curr!=next){

                    Set<Character> adjs = adjList.getOrDefault(curr, new HashSet());
                    if(!adjs.contains(next)){
                        adjs.add(next);
                    }
                    adjList.put(curr, adjs);
                }
            }
        }
        for(Map.Entry<Character,Set<Character>> entry : adjList.entrySet()){
            System.out.println("\n");

            System.out.print(entry.getKey()+"-" );
            for(char ch : entry.getValue()){
                System.out.print(ch+",");
            }

        }

        Set<Character> setsWithZeroIndegree = new HashSet();
        Map<Character, Integer> wordToIndegree = new HashMap();

        for(String word : words){

            for(int i=0;i< word.length()-1;i++){
                char curr = word.charAt(i);
                char next = word.charAt(i+1);
                if(curr != next){
                    int currIn = wordToIndegree.getOrDefault(curr,0);
                    int nextIn = wordToIndegree.getOrDefault(next,0)+1;
                    if(currIn == 0){
                        setsWithZeroIndegree.add(curr);
                    }
                    if(setsWithZeroIndegree.contains(next)){
                        setsWithZeroIndegree.remove(next);
                    }
                    wordToIndegree.put(curr, currIn);
                    wordToIndegree.put(next, nextIn);
                }
            }
        }
        for(Map.Entry<Character,Integer> entry : wordToIndegree.entrySet()){

            System.out.println(entry.getKey() + "\t" + entry.getValue());

        }
        return "";
    }
    public static void main(String [] args){
        AlienDictionary ad = new AlienDictionary();
        ad.alienOrder(new String[]{"wrt","wrf"});

    }

}
