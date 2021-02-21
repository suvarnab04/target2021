package problemsmisc;

import apple.laf.JRSUIUtils;
import curatedlist.tree.TreeNode;


public class UpsideDownTree {
    public TreeNode getUpsideDown(TreeNode root){
        if(root==null || (root.left==null&& root.right==null)){
            return root;
        }
        TreeNode newRoot = getUpsideDown(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.right=null;
        root.left= null;

        return newRoot;
    }

    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        tree.right = new TreeNode(3);
        UpsideDownTree up = new UpsideDownTree();
        System.out.println("new root::"+ up.getUpsideDown(tree).val);

    }
}
