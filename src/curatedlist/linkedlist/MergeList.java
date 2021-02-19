package curatedlist.linkedlist;
/*
https://leetcode.com/problems/merge-two-sorted-lists/
https://www.youtube.com/watch?v=GfRQvf7MB3k
https://www.youtube.com/watch?v=K63Mjf-H0B0
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode(0);
        ListNode head = merge;
        while(l1!=null && l2!=null){
            if( l1.val <= l2.val){
                head.next = l1;
                l1= l1.next;
            }else{
                head.next = l2;
                l2= l2.next;
            }
            head= head.next;
        }
        if(l1!=null){
            head.next = l1;
        }else if(l2!=null){
            head.next = l2;
        }
        return merge.next;

    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2= new ListNode(1);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(8);
        MergeList m = new MergeList();
        ListNode node = m.mergeTwoLists(l1,l2);
        while(node!=null){
            System.out.println(node.val+"-->");
            node= node.next;
        }
    }

}
