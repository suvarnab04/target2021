package microsoftOA;

import curatedlist.tree.TreeNode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class VisibleNodesInBinaryTree {
    int count =0;
    public int goodNodes(TreeNode root) {

        getGoodNodes(root, Integer.MIN_VALUE);
        return count;
    }
    public void getGoodNodes(TreeNode node,int max){
        if(node == null){
            return;
        }
        if(node.val >= max){
            max= node.val;
            count++;
        }
        getGoodNodes(node.left,max);
        getGoodNodes(node.right, max);
    }
}
