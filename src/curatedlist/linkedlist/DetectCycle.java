package curatedlist.linkedlist;
/*
https://leetcode.com/problems/linked-list-cycle/
 */
public class DetectCycle {
    public boolean hasCycle(ListNode head) {

        if(head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast= fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
