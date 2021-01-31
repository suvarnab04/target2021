package curatedlist.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }
    public int maxDepthBFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int depth =0;
        if(root == null){
            return 0;
        }
        queue.add(root);

        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i=0;i< size;++i){
                TreeNode pop = queue.remove();
                if(pop.left!=null){
                    queue.add(pop.left);
                }
                if(pop.right!=null){
                    queue.add(pop.right);
                }
            }
        }
        return depth;

    }
    public static void main(String[] args){
        MaximumDepth md = new MaximumDepth();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(15);

        System.out.println(md.maxDepth(root)); //3
    }
}
