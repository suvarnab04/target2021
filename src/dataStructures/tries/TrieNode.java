package dataStructures.tries;

public class TrieNode {
    static final int ALPHABET_SIZE = 26;

    TrieNode [] children;
    boolean isEndWord;


    TrieNode(){
        children = new TrieNode[ALPHABET_SIZE];
        isEndWord = false;
    }
    public void markAsLeaf(){
        isEndWord = true;
    }
    public void unMarkAsLeaf(){
        isEndWord = false;
    }
}
