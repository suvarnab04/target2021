package dataStructures.tries;

import java.util.ArrayList;

public class TrieMain {

    public static boolean hasChildren(TrieNode node){
        for(int i = 0; i< node.children.length; i++){
            if(node.children[i]!= null){
                return true;
            }
        }
        return false;
    }


    public static int  countWords(TrieNode root) {
    int count=0;

        if(root.isEndWord){
            count++;
        }
        for(int i=0;i< root.children.length;i++){

            if(root.children[i]!=null) {

                count += countWords(root.children[i] );

            }

        }
        return count;

    }
    //Recursive Function to generate all words
   // public static void getWords(TrieNode root, ArrayList< String > result, int level, char[] str)
    public static void getWords(TrieNode root, ArrayList< String > result, int level, char[] str) {

        // use this as helper function
        //get the children index
        ArrayList<Integer> notNullIndex = getNonNullChildren(root);
        for(int i : notNullIndex){
            str[level] = (char)('a'+i);

            if(root.children[i].isEndWord){
                result.add(String.valueOf(str));
            }
            if(hasChildren(root.children[i]))
                getWords(root.children[i], result, level+1, str);
            else {
               //str[level] =Character.MIN_VALUE;
                str[level] ='\0';
                level--;
            }
        }
        //str[level] =Character.MIN_VALUE;
        str[level] ='\0';
        level--;

    }
    public static ArrayList < String > findWords(TrieNode root)
    {
        ArrayList < String > result = new ArrayList < String > ();
        // write your code here
        getWords(root, result,0, new char[26]);

        return result;
    }
    public static ArrayList<Integer> getNonNullChildren(TrieNode root){
        ArrayList < Integer > result = new ArrayList();
        for(int i=0;i< root.children.length;i++){
            if(root.children[i] != null){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Trie trieEmpty = new Trie();

        //1. word not present
       System.out.println("deleted::" + trieEmpty.delete("room"));

        //2. no children present after leaf
        Trie trieLeaf = new Trie();
        trieLeaf.insert("bed");
        System.out.println("deleted::" + trieLeaf.delete("bed"));

        //3.children present after the end word eg trie= bedroom delete bed, here bedroom and bed are words in the trie
        //we only want to delete bed, in order to do so we will just unmark the end word of bed.
        Trie trieMiddle = new Trie();
        trieMiddle.insert("bed");
        trieMiddle.insert("bedroom");
        System.out.println("deleted::" + trieMiddle.delete("bed"));

        //4
        Trie trieMiddle1 = new Trie();
        trieMiddle1.insert("the");
        trieMiddle1.insert("their");
        System.out.println("deleted::" + trieMiddle1.delete("their"));

        Trie trieCount= new Trie();
        trieCount.insert("the");
        trieCount.insert("a");
        trieCount.insert("there");
        trieCount.insert("answer");
        trieCount.insert("any");
        trieCount.insert("by");
        trieCount.insert("bye");
        trieCount.insert("their");
        trieCount.insert("abc");

        System.out.println("Total words::" + countWords(trieCount.getRoot()));

        System.out.println("ALL Words::" + findWords(trieCount.getRoot()));
    }
}
