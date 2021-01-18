package dataStructures;

public class DoublyLinkedList<V> {
     public class Node{
        public V data;
        public Node prevNode;
        public Node  nextNode;
         public V getData(){
             return data;
         }
    }

    Node headNode;

    DoublyLinkedList(){
        headNode = null;
    }

    public Node getHeadNode(){
        return headNode;
    }

    public void printList(){
        Node temp = headNode;
        //System.out.print("\nLIST::");

        if(headNode == null){
            return;
        }
        while(temp != null){
            System.out.print(temp.data +" <-->");
            temp = temp.nextNode;
        }

    }
    public void insertAtHead(V data){
        //create newNode,prevNode and nextNode of this newNode points to null
        Node newNode = new Node();
        newNode.prevNode = null;
        newNode.nextNode = null;
        newNode.data = data;
        if(headNode != null){ //if head is already there, append the new node at the start and make this newNode
            //headNode,
            headNode.prevNode = newNode;
            newNode.nextNode = headNode;
        }

        headNode = newNode;

    }
    public void insertAtEnd(V data){
        if(headNode== null){
            insertAtHead(data);
            return;
        }
        Node newNode = new Node();
        newNode.prevNode=null;
        newNode.nextNode = null;
        newNode.data = data;
        Node tempNode = headNode;
        while(tempNode.nextNode!=null){
            tempNode=tempNode.nextNode;
        }
        tempNode.nextNode = newNode;
        newNode.prevNode = tempNode;
    }
    public boolean isEmpty(){
        return headNode == null ;
    }
    public void deleteLink(V val){
        if(isEmpty()){
            return;
        }
        //head
        if(headNode.data == val){
            headNode = null;
        }else{
            Node temp = new Node();
            while(temp!=null){
                if(temp.data == val){
                    //previousnode
                    Node previousNode = temp.prevNode;
                    Node nextNode = temp.nextNode;
                    if(nextNode == null) {
                        //tail
                        previousNode.nextNode = null;
                    }else{
                        previousNode.nextNode = nextNode;
                        nextNode.prevNode = previousNode;
                    }
                    //link previous node and next node
                }
                temp = temp.nextNode;
            }
        }

    }

}

