package curatedlist.tree;
/*
https://leetcode.com/problems/validate-binary-search-tree/
https://backtobackswe.com/platform/content/test-a-tree-for-the-bst-property/video
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        return isValidBSTHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }
    public boolean isValidBSTHelper(TreeNode root, long min, long max) {
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }


        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right,root.val,max);

    }
}
