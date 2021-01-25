package dataStructures.tries;

import java.util.Arrays;

public class DictWord {


    public static boolean isFormationPossible(String[] dict,String word) {

        if(word.length() < 2 || dict.length < 2){
            return false;
        }
        //1. build a trie
        Trie dictTrie = new Trie();
        for(String str : dict){
            dictTrie.insert(str);
        }

        for(int i=0;i< word.length();i++){
            String firstWord = word.substring(0,i);
            String secondWord = word.substring(i, word.length());

            if(dictTrie.search(firstWord) && dictTrie.search(secondWord)){
                return true;
            }
        }

        return false;
    }

        public static void main(String args[]){
        // Input dict (use only 'a' through 'z' and lower case)
        String dict[] = {"the", "hello", "there", "answer","any", "dragon", "world", "their",  "inc"};


        System.out.println("Keys: "+ Arrays.toString(dict));

        String formation ="helloworld";
       System.out.println("formation::"+ formation+ "\nIs formation possible ?" + isFormationPossible(dict, "helloworld"));

    }


}
