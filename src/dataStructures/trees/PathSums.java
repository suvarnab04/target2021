package dataStructures.trees;

import curatedlist.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSums {
    /**
     * https://leetcode.com/problems/path-sum/
     */

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null){
            return false;
        }
        boolean isLeaf = root.left==null && root.right==null;
        if(isLeaf && targetSum == root.val){
            return true;
        }
        return hasPathSum(root.left, targetSum- root.val) || hasPathSum(root.right, targetSum - root.val);

    }
    /**
     * https://leetcode.com/problems/path-sum-ii/
     * https://www.youtube.com/watch?v=3B5gnrwRmOA&t=4s
     */

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        getPaths(root, targetSum, new ArrayList<Integer>(), result);
        return result;

    }
    public void getPaths(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result){

        if(root == null){
            return;
        }
        list.add(root.val);

        boolean isLeaf = root.left == null && root.right == null;

        if(isLeaf && root.val == targetSum){
            //we have found our result
            result.add(list);

        }

        getPaths(root.left, targetSum - root.val, new ArrayList<Integer>(list), result);

        getPaths(root.right, targetSum - root.val, new ArrayList<Integer>(list), result);
    }
}
