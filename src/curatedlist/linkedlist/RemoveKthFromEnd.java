package curatedlist.linkedlist;
/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveKthFromEnd {
    public ListNode removeNthFromEnd1(ListNode head, int n) {

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
    /**
     more intutive solution:
     1. get the length
     2. have a dummy head to avoid next.next null pointer
     3. iterate length-n node
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n==0){
            return head;
        }
        //find the length of the list
        int length=getListLength(head);
        if(n > length){
            return head;
        }
        System.out.println(length);
        ListNode dummy =new ListNode(-1);
        dummy.next = head;

        ListNode dummyTemp = dummy;
        int i=0;
        while(i< length-n){
            dummyTemp = dummyTemp.next;
            i++;

        }
        dummyTemp.next = dummyTemp.next.next;
        return dummy.next;

    }
    public int getListLength(ListNode head){
        ListNode temp = head;
        int count =0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}
