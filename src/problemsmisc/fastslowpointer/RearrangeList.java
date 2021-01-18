package problemsmisc.fastslowpointer;

public class RearrangeList {

    public static void reorder(ListNode head) {

        //1. find middle of the list
        ListNode middle = findMiddle(head);
        System.out.println("Middle node is::"+ middle.value);
        //2 reverse the second half of the list
        ListNode secondHalf = reverseList(middle);
        System.out.println("second half::");
        printList(secondHalf);

        System.out.println("\nfirst half::");
        printList(head);

        ListNode firstHalf = head;
        //3 traverse through first half and second half
        while(firstHalf !=null && secondHalf!=null){
           ListNode firstNext = firstHalf.next;
           ListNode secNext = secondHalf.next;

           firstHalf.next = secondHalf;
           secondHalf.next= firstNext;

           firstHalf = firstNext;
           secondHalf = secNext;

        }
        if(firstHalf !=null){ //in case of even length linkedlist,
            firstHalf.next=null;
        }
        System.out.println("\nRearranged list::");
        printList(head);

    }
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev= head;
            head= next;
        }
        return prev;
    }
    public static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void printList(ListNode head){
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        //head.next.next.next.next = new ListNode(10);
      //  head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);

    }
}
