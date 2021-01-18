package Problems;

public class CheckMid {
}
/*
class CheckMid {

    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        // Write -- Your -- Code
        //check if list is greater than two
        if(list.headNode== null || list.headNode.nextNode ==null || list.headNode.nextNode == null){
            return -1;
        }
        int nodesOnRight = 0;

        SinglyLinkedList<T>.Node currentNode = list.headNode.nextNode;

        boolean midFound =false;

        while(!midFound && currentNode!=null){

            int nodesOnLeft=0;
            nodesOnRight++;

            SinglyLinkedList<T>.Node tempNode = currentNode.nextNode;

            while(tempNode != null){
                nodesOnLeft++;
                tempNode= tempNode.nextNode;

            }
            if(nodesOnLeft - nodesOnRight <=1 ){
                midFound = true;
                break;
            }
            currentNode = currentNode.nextNode;

        }
        return midFound ? currentNode.data : -1;


    }
}
*/