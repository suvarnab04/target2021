package curatedlist.tree;

public class TreeNode {
     public int val;
     public TreeNode left;
     public  TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public int getData(){
        return val;
    }
    public void setData(int val){
       this.val = val;
    }
    public TreeNode getLeftChild(){
        return left;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.left = leftChild;
    }

    public TreeNode getRightChild() {
        return left;
    }

    public void setRightChild(TreeNode rightChild) {
        this.right = rightChild;
    }
}
