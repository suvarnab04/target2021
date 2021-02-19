package dataStructures;

public class SinglyLinkedList<T> {
    Node headNode;
    int size;
    SinglyLinkedList(){
        headNode = null;
        size =0;
    }
    public boolean isEmpty(){
        return headNode == null;
    }
    public void printList(){
        System.out.print("\nList is::");
        if(headNode!=null){
            Node temp = headNode;
            while(temp !=null){
                System.out.print(temp.data +"-->");
                temp= temp.nextNode;
            }
        }
    }
    public void insertAtEnd(T data){
        Node newNode = new Node();
        newNode.data = data;

        if(headNode == null){//no node is present yet
            headNode = newNode;
            headNode.nextNode = null;

        }else {
            Node temp = headNode;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = newNode;
            newNode.nextNode = null;
        }
    }
    public void insertAtStart(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        headNode = newNode;
    }
    public boolean searchNode(T data) {
        // Write -- Your -- Code
        //isEmpty
        if(headNode == null){
            return false;
        }else{
            Node temp =headNode;
            while(temp !=  null){
                if(temp.data == data){
                    return true;
                }else{
                    temp = temp.nextNode;
                }
            }
        }
        //
        return false; //value not found
    }
    public void deleteByValue(T data) {
        // Write -- Your -- Code
        //empty list
        if(headNode == null){

        }else if(headNode.data.equals(data)){
            deleteHead();
        }else{

            //in between deletion
            Node current = headNode;
            Node nextNode = headNode.nextNode;
            while(nextNode != null ){
                if(nextNode.data.equals(data)){
                    current.nextNode = nextNode.nextNode;
                    nextNode = nextNode.nextNode;

                }else{
                    current = current.nextNode;
                    nextNode = nextNode.nextNode;
                }
            }
        }




    }
    public void deleteHead(){
        headNode = headNode.nextNode;
    }

    public int getLength(){
        Node n = headNode;
        int length =0;
        while(n!=null){
            length++;
            n= n.nextNode;
        }
        return length;
    }


}
class Node<T>{
    T data;
    Node nextNode;
}
