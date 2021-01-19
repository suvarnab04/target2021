package curatedlist.tree;
/*
https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if( (p==null && q!=null) || (p!=null && q==null) ){
            return false;
        }
        if(p==null && q==null){
            return true;
        }

        if(p.val != q.val){
            return false;
        }

        return  isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args){
        SameTree st = new SameTree();
        TreeNode tree1 = new TreeNode(1);
        tree1.left= new TreeNode(2);
        tree1.right = new TreeNode((3));

        TreeNode tree2 = new TreeNode(1);
        tree2.left= new TreeNode(2);
        tree2.right = new TreeNode((3));

        System.out.println(st.isSameTree(tree1, tree2));
    }
}
