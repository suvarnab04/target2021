package dataStructures.tries;

public class Trie {
    private TrieNode root;

    Trie(){
        root = new TrieNode();
    }
    TrieNode getRoot(){
        return  root;
    }

    public int getIndex(char t){
        return t - 'a';
    }
    public void insert(String key){
        key = key.toLowerCase();
        TrieNode currentNode = root;
        for(int i=0;i< key.length();i++){
            int indexOfChar = getIndex(key.charAt(i));
            if(currentNode.children[indexOfChar] == null){

                currentNode.children[indexOfChar] = new TrieNode();
            }
            currentNode = currentNode.children[indexOfChar];

        }
        currentNode.markAsLeaf();

    }

    public boolean search(String key){
        TrieNode current = root;
        for(int i=0;i< key.length();i++){
            int indexOfChar = getIndex(key.charAt(i));
            if (current == null) {

                return false;
            }

            current = current.children[indexOfChar];
        }
        if(current.isEndWord){
            return true;
        }
        return false;
    }

    public boolean deleteHelper(TrieNode currentNode, String key, boolean deleteSelf){
        boolean deletechild = false;

        if(currentNode == null){
            return false; ///key does not exits,
        }
        if(key.length() == 0 && !currentNode.isEndWord){
            return false;
        }
        if(key.length() == 0 ){
            currentNode.unMarkAsLeaf();
            return true;


        }else{

            TrieNode child = currentNode.children[getIndex(key.charAt(0))];
            key = key.substring(1);
            deletechild = deleteHelper(currentNode, key, deleteSelf);

            if (deletechild && !hasNoChildren(child)) { //delete the node and if it has children then
                 currentNode.children[getIndex(key.charAt(0))] = null;
            }



            return deletechild;
        }

    }
    public boolean delete(String key){
        TrieNode currNode = root;
        return deleteHelper(currNode, key, false);

    }
    public boolean hasNoChildren(TrieNode node){
        for(int i = 0; i< node.children.length; i++){
            if(node.children[i]!= null){
                return false;
            }
        }
        return true;
    }



}
