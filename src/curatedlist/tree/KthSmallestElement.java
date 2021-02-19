package curatedlist.tree;
/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
https://www.youtube.com/watch?v=C6r1fDKAW_o&t=491s
 */
public class KthSmallestElement {

    public int kthSmallest(TreeNode root, int k) {
        int nums[] = new int[2]; //keep the track of count and the node
        traverse(root, k, nums);
        return nums[1];
    }
    public void traverse(TreeNode root, int k, int[] nums){
        if(root==null){
            return;
        }
        traverse(root.left,k, nums);
        nums[0]++;
        if(nums[0] == k){
            nums[1] = root.val;
            return;
        }
        traverse(root.right, k, nums);
    }
}
