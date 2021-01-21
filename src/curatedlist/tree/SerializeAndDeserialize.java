package curatedlist.tree;

import java.util.LinkedList;
import java.util.Queue;
/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserialize {
    public static final String COMMA =",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String serializeTree = "";
        if(root == null){
            return serializeTree;
        }
        if(root!=null &&  root.left==null && root.right==null){
            return serializeTree+root.val+COMMA;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){

            for(int i=0;i< queue.size();i++){
                TreeNode node = queue.remove();
                if(node!=null){
                    serializeTree += node.val + COMMA;
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    queue.add(left);
                    queue.add(right);
                }else{
                    serializeTree += "null" + COMMA;
                }

            }


        }
        System.out.println(serializeTree);

        return serializeTree;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        String[] dataArr = data.split(COMMA);
        if(dataArr.length==1){
            return new TreeNode(Integer.valueOf(dataArr[0]));
        }

        return buildTree(0, dataArr);

    }
    public TreeNode buildTree(int index, String[] dataArr){
        if(index >= dataArr.length)
        {
            return null;
        }
        String rootVal = dataArr[index];

        TreeNode root = null;
        if(!rootVal.equals("null"))
            root = new TreeNode(Integer.valueOf(rootVal));

        int left = 2*index+1;
        int right = 2*index+2;

        if(root!=null){
            root.left = buildTree(left, dataArr);

            root.right = buildTree(right, dataArr);
        }

        return root;

    }
}
