package curatedlist.tree.trie;
class WordDictionary {
    class TrieNode{
        TrieNode[] child ;
        boolean isEndWord;
        public TrieNode(){
            child = new TrieNode[26];
            isEndWord = false;
        }
    };
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {

        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currNode = root;
        for(int i=0;i< word.length();i++){
            char ch = word.charAt(i);
            int index = ch -'a';
            if(currNode.child[index] == null){
                currNode.child[index] = new TrieNode();
            }
            currNode = currNode.child[index];
        }
        currNode.isEndWord = true;

    }

    public boolean search(String word) {

        TrieNode currNode = root;
        int i=0;
        while(i< word.length()){
            char ch = word.charAt(i);
            if(ch!= '.'){
                int index = ch -'a';
                if(currNode.child[index] == null){
                    return false;
                }
                currNode = currNode.child[index];
            }else{

                return match(currNode, word.substring(i, word.length()));
            }
            i++;
        }

        return currNode.isEndWord;
    }
    public boolean match(TrieNode node, String word) {
        //starts with a char
        System.out.println("word::"+word);

        for(int i=0;i< 26;i++){

            TrieNode childNode = node.child[i];
            if(childNode!= null){
                int w=0;
                while(w< word.length()){
                    char ch = word.charAt(w);
                    System.out.println("ch::"+ ch);
                    int index = ch - 'a';
                    if(ch == '.'){

                        match(childNode,word.substring(w+1));
                        w++;

                    }else if(childNode.child[index] != null){
                        childNode = childNode.child[index];
                        w++;
                    }else{
                        break;
                    }

                }
                if(w == word.length() && childNode.isEndWord){
                    return true;
                }
            }

        }
        return  false;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */