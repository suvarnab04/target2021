package Problems;

public class CheckLoopInLinkedList {
}
/*class CheckLoop {
    //Detects loop in the given linked list
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        //Write -- Your -- Code
        boolean isLoop = false;
        SinglyLinkedList<T>.Node temp = list.headNode;
        while(!isLoop && temp!=null){
            if(temp.nextNode == list.headNode){
                isLoop = true;
            }
            temp = temp.nextNode;
        }
        return isLoop;
    }
}
*/

