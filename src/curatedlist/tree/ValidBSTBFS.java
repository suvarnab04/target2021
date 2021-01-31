package curatedlist.tree;

import apple.laf.JRSUIUtils;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

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

