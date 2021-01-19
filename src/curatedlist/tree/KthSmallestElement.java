package curatedlist.tree;
/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElement {
    int result = Integer.MIN_VALUE;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }
    public void traverse(TreeNode root, int k){
        if(root==null){
            return;
        }
        traverse(root.left,k);
        count++;
        if(count == k){
            result = root.val;
        }
        traverse(root.right, k);
    }
}
