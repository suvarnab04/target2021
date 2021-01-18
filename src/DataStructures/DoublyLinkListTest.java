package DataStructures;

public class DoublyLinkListTest {
    public static void main(String[] args){
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.insertAtHead(1);
        dll.printList();
        dll.insertAtHead(2);
        dll.printList();
    }
}
