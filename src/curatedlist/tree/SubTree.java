package curatedlist.tree;
/*
https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s==null){
            return false;
        }
        if(isSame(s,t)){
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean isSame(TreeNode s, TreeNode t){
        if(s==null && t==null){ // you have reached the end of both the tree that means both trees matches each other
            return true;
        }
        if(s==null || t==null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    public static void main(String [] args){

    }
}
