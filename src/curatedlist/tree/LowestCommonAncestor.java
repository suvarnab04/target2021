package curatedlist.tree;

import java.util.Stack;

/**
 * https://backtobackswe.com/platform/content/lowest-common-ancestor-in-a-bst/video
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestorDFS(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p==null || q==null){
            return root;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp!=null){
                if(p.val < temp.val && q.val< temp.val){
                    stack.push(temp.left);
                }else if(p.val > temp.val && q.val> temp.val){
                    stack.push(temp.right);
                }else{
                    return temp;
                }
            }
        }
        return root;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val< root.val){ // both the values are in left sub tree, so we can further reduce the problem to left sub tree
            return lowestCommonAncestor(root.left, p,q);
        }

        if(p.val> root.val && q.val> root.val){
            return lowestCommonAncestor(root.right, p,q);
        }
        return root;


    }
}
