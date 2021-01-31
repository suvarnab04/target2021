package curatedlist.tree;

import java.util.LinkedList;
import java.util.Queue;
/*
https://leetcode.com/problems/validate-binary-search-tree/
https://backtobackswe.com/platform/content/test-a-tree-for-the-bst-property/video
 */
public class ValidBSTBFS {
    class AugNode{
        TreeNode node;
        long min;
        long max;

        public AugNode(TreeNode node, long min, long max){
            this.node = node;
            this.min = min;
            this.max = max;
        }

    }
    public boolean isValidBST(TreeNode root){

        if(root==null){
            return true;
        }
        Queue<AugNode> queue = new LinkedList<>();
        queue.add(new AugNode(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while(!queue.isEmpty()){
            AugNode augNode = queue.remove();
            if(augNode.node != null){

                if(augNode.node.val <= augNode.min || augNode.node.val >= augNode.max  ){
                    return false;
                }
                queue.add(new AugNode(augNode.node.left, augNode.min, augNode.node.val));
                queue.add(new AugNode(augNode.node.right, augNode.node.val, augNode.max));
            }

        }
        return true;
    }
}

