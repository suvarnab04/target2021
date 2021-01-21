package curatedlist.tree.trie;
/*
https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {
    public static final int SIZE =26;
    private TrieNode root;

    class TrieNode{
        TrieNode[] child;
        boolean isEndWord;


        TrieNode(){
            child = new TrieNode[SIZE];
            isEndWord = false;
        }
        public void markAsEndWord(){
            isEndWord = true;
        }
        public void unmarkAsEndWord(){
            isEndWord = false;
        }
    };

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();

    }

    /** Inserts a word into the trie. */
    public void insert(String word1) {
        String word =  word1.toLowerCase();
        TrieNode currentNode=  root;
        for(int i=0;i< word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(currentNode.child[index] == null){
                currentNode.child[index] = new TrieNode();
            }
            currentNode = currentNode.child[index];

        }
        currentNode.markAsEndWord();

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currNode = root;
        for(int i =0;i< word.length();i++){
            char ch = word.charAt(i);
            int index = ch -'a';
            if(currNode.child[index] == null){
                return false;
            }
            currNode = currNode.child[index];

        }
        if(currNode.isEndWord){
            return true;
        }

        return false;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;

        for(int i=0;i< prefix.length();i++){
            char ch = prefix.charAt(i);
            int index = ch -'a';
            if(currNode.child[index] == null){
                return false;
            }
            currNode = currNode.child[index];

        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */