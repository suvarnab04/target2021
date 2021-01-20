package curatedlist.tree;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
https://backtobackswe.com/platform/content/tree-reconstruction/video
 */

import java.util.HashMap;
import java.util.Map;

public class TreeConstructionFromPreOrderInOrder {
    int preOrderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        TreeNode root = buildNode(0, inorder.length-1, preorder, inorderIndexMap);
        return root;


    }
    public TreeNode buildNode(int inorderStart, int inorderEnd,int [] preOrder, Map<Integer,Integer> inorderIndexMap){
        if(inorderStart > inorderEnd){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preOrderIndex]);
        preOrderIndex++;
        if(inorderStart == inorderEnd){
            return root;
        }

        int rootIndexInInOrder = inorderIndexMap.get(root);
        root.left = buildNode(inorderStart,rootIndexInInOrder-1,preOrder, inorderIndexMap );
        root.right= buildNode(rootIndexInInOrder+1,inorderEnd,preOrder, inorderIndexMap );

        return root;

    }
}
