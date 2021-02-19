package dataStructures.trees;

import curatedlist.tree.TreeNode;
import dataStructures.Stack;
/*
https://leetcode.com/problems/binary-tree-preorder-traversal/
https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class TreeTraversal {
    public void postOrderTraversal(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        if(node==null){
            return ;
        }
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.push(pop);
            if(pop.left!=null){
                stack.push(pop.left);
            }
            if(pop.right!=null){
                stack.push(pop.right);
            }


        }
        while(!result.isEmpty()){
            System.out.println(result.pop().val);
        }

    }
    public void preOrderTraversal(Node node){
        Stack<Node> stack = new Stack();
        stack.push(node);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop.getData());
            if(node.getRightChild()!=null){
                stack.push(node.getRightChild());
            }
            if(node.getLeftChild()!=null){
                stack.push(node.getLeftChild());
            }
        }

    }
    public void inOrderTraversal(Node node){
        //travese till the left most then node and then right
        Stack<Node> stack = new Stack<>();
        String result = "";

        while(!stack.isEmpty() || node!=null){
            if(node != null ){
                stack.push(node);
                node = node.getLeftChild();
            }else{
                node = stack.pop();
                result+= node.getData();
                node = node.getRightChild();
            }
        }
        System.out.println("Inorder traversal::" +result);

    }
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        /*tree.add(1);
        tree.add(2)
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();*/
    }
}
