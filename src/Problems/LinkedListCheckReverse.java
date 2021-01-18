package Problems;

public class LinkedListCheckReverse {
}
/*
class CheckReverse {
    public static <T> void reverse(SinglyLinkedList<T> list){
        //Write -- Your -- Code
        SinglyLinkedList<T>.Node current = list.headNode;
        SinglyLinkedList<T>.Node next = current.nextNode;
        while(next!=null){
            //head node should point to temp's next
            //we want to make temp as our new head but before that we need to
            //save current headnode's address into temp's i.e. temp.nextNode should be headNode's address
            //step 1. extract the temp node
            //step 2. insert the extracted node at the head
            current.nextNode = next.nextNode; //link head to the temps's next node

            next.nextNode = null;
            insertAtHead(next, list);
            next = current.nextNode;
        }
    }
    public static<T> void insertAtHead(SinglyLinkedList<T>.Node newHeadNode,SinglyLinkedList<T> list){
        newHeadNode.nextNode = list.headNode;
        list.headNode = newHeadNode;

    }
}
*/
