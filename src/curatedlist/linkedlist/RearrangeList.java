package curatedlist.linkedlist;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class RearrangeList {
    public void reorderList(ListNode head) {

        if(head==null || head.next==null){
            return ;
        }
        ListNode firstList = head;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        System.out.println("middle of the list is::"+ slow.val);

        ListNode secondList = reverse(slow);
        System.out.println("first list");
        printList(firstList);
        System.out.println("\nsecond list");
        printList(secondList);

        while(firstList!=null && secondList.next!=null){
            ListNode firstNext = firstList.next;
            ListNode secNext = secondList.next;

            firstList.next = secondList;
            secondList.next = firstNext;

            firstList = firstNext;
            secondList = secNext;
        }

        // return head;

    }
    public void printList(ListNode head){
        //System.out.println();
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val +"-->");
            temp= temp.next;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev= head;
            head= next;
        }
        return prev;
    }
}
