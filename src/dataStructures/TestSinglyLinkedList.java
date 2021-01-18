package dataStructures;

public class TestSinglyLinkedList {
    public static void main(String[] args){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        //test isEmpty
        System.out.println("Checking if empty:"+ list.isEmpty());
        //add node
      //  list.insertAtStart(1);
      //  list.printList();
      //  list.insertAtStart(2);
      // list.printList();

        list.insertAtEnd(3);
        list.printList();
        list.insertAtEnd(4);
        list.printList();

    }
}
