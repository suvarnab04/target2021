package curatedlist.linkedlist;

import java.util.List;

/*
https://leetcode.com/problems/linked-list-cycle/
https://backtobackswe.com/platform/content/testing-for-cycles/video
https://leetcode.com/problems/linked-list-cycle-ii/
also check how to find head of the cycle
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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==  fast){
                slow = slow.next;
                int count = 1;
                while(slow!= fast){
                    slow = slow.next;
                    count++;
                }
                System.out.println("cycle length is::"+ count);
                ListNode left = head;
                ListNode right = head;
                int i=0;
                while(i< count){
                    right = right.next;
                    i++;
                }
                while(left!=right){
                    left = left.next;
                    right= right.next;

                }
                return left;
            }
        }
        return null;

    }
}
