package microsoftOA;

import curatedlist.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        List<Integer> results = new ArrayList();

        getGoodNodes(root, new ArrayList(), results);
        return results.size();
    }
    public void getGoodNodes(TreeNode node, List<Integer> seen, List<Integer> result){
        if(node == null){
            return;
        }
        if(isGoodNode(node.val,seen)){
            seen.add(node.val);
            result.add(node.val);
        }
        getGoodNodes(node.left, new ArrayList(seen), result);
        getGoodNodes(node.right, new ArrayList(seen), result);


    }
    boolean isGoodNode(int val, List<Integer> seen){

        for(int s : seen){
            if(val < s){
                return false;
            }
        }
        return true;
    }
}
