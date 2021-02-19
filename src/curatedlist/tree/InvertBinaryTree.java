package curatedlist.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */

public class InvertBinaryTree {
    public TreeNode invertTreeBFS(TreeNode root) {
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr!= null){
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;

                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.right);
        invertTree(root.left);

        return root;

    }
    public static void main(String[] args){
        InvertBinaryTree ibt = new InvertBinaryTree();
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);

        tree.right = new TreeNode(7);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(9);


        ibt.invertTree(tree);
        ibt.printTree(tree);

    }
    public void printTree(TreeNode node){

        if(node == null){
            return;
        }
        System.out.print(node.val+",");
        printTree(node.left);
        printTree(node.right);
    }
}
