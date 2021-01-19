package curatedlist.tree;

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
    public static void main(String[] args){
        MaximumDepth md = new MaximumDepth();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(15);

        System.out.println(md.maxDepth(root)); //3
    }
}
