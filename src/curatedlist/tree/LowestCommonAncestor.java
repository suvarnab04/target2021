package curatedlist.tree;

/**
 * https://backtobackswe.com/platform/content/lowest-common-ancestor-in-a-bst/video
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestor {
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
