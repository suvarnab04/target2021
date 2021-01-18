package curatedlist.linkedlist;
/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveKthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null && n==1){
            return null;
        }

        ListNode node=head;
        int length =0;

        while(node!=null){
            length++;
            node = node.next;

        }

        System.out.println(length);
        int i=1;
        ListNode temp = head;
        while(i< length-n){
            temp= temp.next;
            i++;

        }
        System.out.println("we are at"+ temp.val);
        if(n==  length){//delete head
            temp = temp.next;
            return temp;
        }

        temp.next = temp.next.next;

        return head;
    }
    //one pass
    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        if(head.next == null && n==1){
            return null;
        }

        ListNode start = head;
        ListNode slow = start;
        ListNode fast = start;

        int i=1;
        while(fast!=null && i<= n+1){
            fast= fast.next;
            i++;
        }
        if(fast==null){
            //i is the length of the list
            System.out.println(i-1);
            //delete head
            if((i-1) == n){
                return slow.next ;
            }

        }
        while(fast!=null){
            slow = slow.next;
            fast= fast.next;
        }
        slow.next = slow.next.next;
        return start;
    }
}
