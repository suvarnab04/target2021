package Problems;

public class RemoveDuplicatesFromList {
}
/*
class RemoveDuplicatesChallenge {
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        // Write -- Your -- Code
        SinglyLinkedList<T>.Node nodeToBeChecked = list.headNode;


        while(nodeToBeChecked.nextNode != null){
            SinglyLinkedList<T>.Node prev = nodeToBeChecked;
            SinglyLinkedList<T>.Node current = prev.nextNode;

            while(prev.nextNode!= null){


                if(current.data.equals(nodeToBeChecked.data)){

                    prev.nextNode = current.nextNode;
                    current = current.nextNode;

                }else{
                    prev = prev.nextNode;
                    current = current.nextNode;
                }


            }
            nodeToBeChecked = nodeToBeChecked.nextNode;

        }
    }
}
*/

