package dataStructures.tries;

import java.util.ArrayList;

public class Sort {

    public static ArrayList<String> sortArray(String[] arr) {
        ArrayList<String> result = new ArrayList<String>();

        Trie sort = new Trie();

        for(String str : arr){
            sort.insert(str);
        }


        sortArrayHelper(sort.getRoot(),0,new char[26], result );

        // add your code here
        //get all the words, the words will be in sorted order


        return result;
    }
    public static void sortArrayHelper(TrieNode root, int level, char[] str, ArrayList<String> result){
        //1. get the children index which are not null
        ArrayList<Integer> childrenList = getChildren(root);


        for(int i : childrenList){

            str[level] = (char)('a' + i);
            if(root.children[i].isEndWord){
                result.add(String.valueOf(str));
            }
            //if more children are present the increase the level and call the function recursivly else decrease the level
            if(hasChildren(root.children[i])){
                sortArrayHelper(root.children[i],level+1,str,result );
            }else{
                str[level] ='\0';
                level--;
            }
        }
        str[level] ='\0';
        level--;
    }
    public static boolean hasChildren(TrieNode root){
        for(int i=0;i< root.children.length;i++){
            if(root.children[i] !=null){
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> getChildren(TrieNode root){
        ArrayList<Integer> childrenList = new ArrayList<>();
        for(int i=0;i< root.children.length;i++){
            if(root.children[i]!=null){
                childrenList.add(i);
            }
        }
        return childrenList;
    }
    public static void main(String[] args){
        String[] sort = {"the","a","there","answer","any","by","bye","their","abc"

        };
       ArrayList<String> sortedList = sortArray(sort);
       for(String str : sortedList){
           System.out.print(str +",");
       }


    }
}
