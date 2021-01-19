package curatedlist.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
https://www.youtube.com/watch?v=XZnWETlZZ14
https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> nodes = new ArrayList();

            for(int i=0;i< size ;i++ ){

                TreeNode parent = queue.remove();
                nodes.add(parent.val);
                if(parent.left!=null){
                    queue.add(parent.left);
                }
                if(parent.right!=null){
                    queue.add(parent.right);
                }
            }
            list.add(nodes);

        }


        return list;

    }
}
