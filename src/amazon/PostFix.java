package amazon;


import java.util.Stack;

abstract class Node {
    public abstract int evaluate();
    // define your fields here
    String val;
    Node left;
    Node right;
    Node(String val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

};
 class TreeNode extends Node{

    TreeNode(String val){
        super(val);
    }
    public int evaluate(){
        Stack<Node> stack = new Stack();
        stack.push(this);
        while(stack.peek().left!=null){
            Node peek = stack.peek();

            stack.push(peek.right);
            stack.push(peek.left);
        }

        while(!stack.isEmpty()){
            if(stack.size()==1) {
                return Integer.valueOf(stack.pop().val);
            }
            Node left = stack.pop();

            Node right = stack.pop();
            Node operator = stack.pop();
            int answer = 0;
            switch (operator.val) {
                    case "+":
                        answer = Integer.valueOf(left.val) + Integer.valueOf(right.val);
                        break;
                    case "-":
                        answer = Integer.valueOf(left.val) - Integer.valueOf(right.val);

                        break;
                    case "*":
                        answer = Integer.valueOf(left.val) *Integer.valueOf(right.val);
                        break;
                    case "/":
                        answer = Integer.valueOf(left.val) / Integer.valueOf(right.val);
                        break;


                }
                TreeNode n = new TreeNode(String.valueOf(answer));
                stack.push(n);

            }

        return 0;
    }
    public static boolean isOperator(String c){
        if(c== "+" || c=="-" || c=="*" || c=="/" || c=="%" || c== "^"){
            return true;
        }
        return false;
    }

}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class PostFix {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<Node>();
        for(int i=0;i< postfix.length;i++){
            String ch = postfix[i];
            Node node = new TreeNode(ch);
            if(!TreeNode.isOperator(ch)){
                stack.push(node);
            }else{
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            }

        }

        return stack.pop();

    }
public static void main(String[] args){
        PostFix obj = new PostFix();
        Node expTree = obj.buildTree(new String[]{"3","4","+","2","*","7","/"});
        int ans = expTree.evaluate();
        System.out.println(ans);
}

};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */