package dataStructures.Trees;


import dataStructures.Stack;

public class BinarySearchTree {
    Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int value){
        if(isEmpty()){
            root = new Node(value);
            return;

        }
        Node currentNode = root;

        while( currentNode!= null) {

            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            if (value < currentNode.getData()) {
                //go to the right side
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return;
                }
                currentNode = leftChild;
            } else {
                //go to the right side
                if(rightChild == null){
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return;
                }
                currentNode = rightChild;
            }
        }
    }
    public void add(int value){
        if(isEmpty()){
            root = new Node(value);
            return;

        }
        addRec(getRoot(), value);
    }
    private Node addRec(Node currentNode, int value){
        if(currentNode == null){
            return new Node(value);
        }
        if(value < currentNode.getData()){
            currentNode.setLeftChild(addRec(currentNode.getLeftChild(),value));
        }else if(value > currentNode.getData()){
            currentNode.setRightChild(addRec(currentNode.getRightChild(),value));
        }else{
            //value already exists
            return currentNode;
        }
        return currentNode;
    }
    public boolean search(int value){
        if(isEmpty()){
            return false;
        }
        Node currentNode = root;
        while(currentNode!=null){
            if(value == currentNode.getData()){
                return true;
            }else if(value < currentNode.getData()){
                currentNode = currentNode.getLeftChild();
            }else{
                currentNode = currentNode.getRightChild();
            }
        }

        return false;
    }
    public boolean searchRec(Node currentNode, int value){
        if(currentNode== null){
            return false;
        }
        if(currentNode.getData() == value){
            return true;

        }else if(value < currentNode.getData()){
            return searchRec(currentNode.getLeftChild(), value);
        }

        return searchRec(currentNode.getRightChild(), value);


    }
    public void printTree(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.getData() + " , ");
        printTree(node.getLeftChild());
        printTree(node.getRightChild());

    }
    public boolean delete(int value, Node currentNode){
        //1.deletion at leaf node
        //2. deletion of parent node with one child
        //3. deletion of parent node with two children
       if(root == null){
           return false;
       }

       //traverse till the value is found
        Node parent = null;
        while(currentNode!=null && currentNode.getData()!=value){
            parent = currentNode;
            if(currentNode.getData() > value){
                currentNode = currentNode.getLeftChild();
            }else{
                currentNode = currentNode.getRightChild();
            }
        }
        if(currentNode == null){ // we have traversed the tree but couldnt find the value
            return false;
        }
        //leaf node both left and right child are null
        if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
            //only one node root is present
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            }else if(currentNode.getData() < parent.getData()){ //its a left child
                parent.setLeftChild(null);
                return true;
            }else{//its a right child
                parent.setRightChild(null);
                return true;
            }
        }else if(currentNode.getRightChild() == null ){ //parent with one child
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            } else if(currentNode.getData() < parent.getData()){
               parent.setLeftChild(currentNode.getLeftChild());
           }else{
               parent.setRightChild(currentNode.getLeftChild());
           }
        }else if(currentNode.getLeftChild() == null){
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            }else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild( currentNode.getRightChild());
                return true;
            }else{
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }
        }else{
            //the currentnode has both left and right children.
            //find the least value in the right sub tree of currentnode,
            // coz that value will be greater than left child and smaller than the right child
            //the left most in the right sub tree is the least element
            Node leastNode = findLeastNode(currentNode.getRightChild());
            //call delete to delete the leaf node()
            delete(leastNode.getData(), root);
            currentNode.setData(leastNode.getData());
            return true;

        }
        return false;
    }
    public Node findLeastNode(Node currentNode){
       Node temp = currentNode;
        while(currentNode.getLeftChild()!=null){
            currentNode = currentNode.getLeftChild();
        }
        return currentNode;
    }
    public Node findLeastNodeAndDeleteLeaf(Node parent,Node curr){
        Node temp = curr;
        while(temp.getLeftChild()!=null){
            parent = temp;
            temp = temp.getLeftChild();
        }
        if(temp.getData() > parent.getData()){
            parent.setRightChild(null);
        }else{
            parent.setLeftChild(null);
        }
        return temp;
    }
    public int findMin(Node root){
        if(root==null){
            return -1;
        }
        Node temp = root;
        while(temp.getLeftChild() != null){
            temp = temp.getLeftChild();
        }
        return temp.getData();
    }
    public int findKthMax(Node node, int k){
        //findKthRec(root.getRightChild(), 0,k);
        Stack<Node> stack = new Stack();
        int count = 0;
        while(node!= null || !stack.isEmpty()){

            if(node != null){
                stack.push(node);
                node = node.getRightChild();
            }else{
                node = stack.pop();
                count++;
                if(count == k){
                    return node.getData();
                }
                node = node.getLeftChild();
            }
        }
        return -1;
    }
    public Node  findKthRec(Node root, int count, int k) {
        if(root == null){
            return null ;
        }

        Node node = findKthRec(root.getRightChild(), count,k);

        if(count != k){
            count++;
            node = root;
        }
        if(count == k){
            return node;
        }
        else {
            return findKthRec(root.getLeftChild(), count, k);
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
    public String checkAncestors(Node root, int k){
        String path = "";

        Node node = root;
        boolean found = false;
        while(node!= null){


            if(node.getData() == k){
                return path;
            }
            path +=node.getData()+",";
            if(k > node.getData()){
                node = node.getRightChild();
            }else{
                node = node.getLeftChild();
            }

        }
        return "";
    }
    public int heightOfBSTRec(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max( heightOfBSTRec( root.getLeftChild() ), heightOfBSTRec( root.getRightChild() ) );
    }
    public String findKNodes(Node root, int k) {
        return findKNodesRec(root, 1, k);
    }
    public String findKNodesRec(Node root, int level, int k){
        if(root == null){
            return "";
        }

        if(level == k){
            return root.getLeftChild() +","+root.getRightChild()+",";
        }else {
            findKNodesRec(root.getLeftChild(), level++, k);
            findKNodesRec(root.getRightChild(), level++, k);
        }
        return "";
    }
    public static Node insertionRec(Node currNode, int val){
        if(currNode == null){
            return new Node(val);
        }
        if(val > currNode.getData()){
            currNode.setRightChild(insertionRec(currNode.getRightChild(), val));
        }else if(val < currNode.getData()){
            currNode.setLeftChild(insertionRec(currNode.getLeftChild(), val));
        }else{
            return currNode;
        }
        return currNode;
    }
    public static String findKNodesRec(Node node, int k){
        StringBuilder result = new StringBuilder("");

        findKRec( node,  k, result);
        return result.toString();
    }
    public static void  findKRec(Node node, int k, StringBuilder result) {


        if (node == null) {
            return ;
        }
        if (k==0) {
            result.append(node.getData()+",");
        }
        else {

            findKRec(node.getLeftChild(), k - 1, result);
            findKRec(node.getRightChild(), k - 1, result);
        }





    }
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
       // System.out.println("\nBST");
        bst.printTree(bst.getRoot());

        bst.add(3);
       // System.out.println("\nBST");
        bst.printTree(bst.getRoot());

        bst.add(8);
        System.out.println("\nBST");
        bst.printTree(bst.getRoot());

        int searchkey =1;
        System.out.println("Key::"+ searchkey+"\tFound key:: "  + bst.search(searchkey) );
        System.out.println("Key::"+ searchkey+"\tFound key Rec:: "  + bst.searchRec(bst.getRoot(),searchkey) );


        searchkey =3;
        System.out.println("Key::"+ searchkey+"\tFound key:: " + bst.search(searchkey) );
        System.out.println("Key::"+ searchkey+"\tFound key Rec:: "  + bst.searchRec(bst.getRoot(),searchkey) );

        //bst for deletion
        //1.one node, delete root
        BinarySearchTree del1 = new BinarySearchTree();
        del1.add(1);
        System.out.println("1. deleted ::" +del1.delete(1, del1.getRoot()));

        //2.left leaf node
        BinarySearchTree del2 = new BinarySearchTree();
        del2.insert(3);
        del2.insert(1);
        del2.insert(5);
        System.out.println("2. deleted ::" +del2.delete(1, del2.getRoot()));
        //3.right leaf node
        System.out.println("3. deleted ::" +del2.delete(5, del2.getRoot()));

        //4. parent with one node on left
        //5. parent with one node on right

        //findKth
        BinarySearchTree bsT = new BinarySearchTree();

        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);

        System.out.println(bsT.findKthMax(bsT.getRoot(),3));

        BinarySearchTree bstFindKNodes = new BinarySearchTree();

        bstFindKNodes.add(6);
        bstFindKNodes.add(4);
        bstFindKNodes.add(9);
        bstFindKNodes.add(5);
        bstFindKNodes.add(2);
        bstFindKNodes.add(8);
        bstFindKNodes.add(12);
        bstFindKNodes.add(10);
        bstFindKNodes.add(14);

        System.out.println("Printing k nodes");
         System.out.println(bsT.findKNodesRec(bstFindKNodes.getRoot(),2));


    }

}
