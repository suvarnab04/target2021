package problemsmisc.fastslowpointer;

public class PalindromicLinkedList {

    public static ListNode reverseList(ListNode head){

        ListNode prev = null;
        while(head!=null){
           ListNode next = head.next; //preserve head.next
           head.next = prev; // disconnect the next node from the list by storing the address of prev in head.next, make this next node new head
           prev = head; // this new node will become
           head= next; // head moves to next

        }
        head= prev;
       return head;

    }
    public static boolean isPalindrome(ListNode head){

        ListNode reverse = head;
        reverse = reverseList(reverse);

        while(head !=null && reverse!=null){

            if(head.value != reverse.value){
                return false;
            }
            head= head.next;
            reverse = reverse.next;
        }
        return true;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
      //  head.next.next.next.next = new ListNode(5);

        System.out.println("Is palindrome::" + isPalindrome(head));

        ListNode palin = new ListNode(1);
        palin.next = new ListNode(2);
        palin.next.next = new ListNode(2);
        palin.next.next.next = new ListNode(1);
     //   palin.next.next.next.next = new ListNode(1);

        System.out.println("Is palindrome::" + isPalindrome(palin));



    }
}
