package curatedlist.tree;
/*
https://www.youtube.com/watch?v=mOdetMWwtoI
https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;

    }
    public int pathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0,  pathSum(root.left) );
        int right = Math.max(0, pathSum(root.right));

        maxSum = Math.max(maxSum,left+right+ root.val);

        return Math.max(left, right)+ root.val;
    }

}
