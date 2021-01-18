package Curatedlist.linkedlist;
/*
https://leetcode.com/problems/reverse-linked-list/
 */
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
};
public class ReverseLinkedList {


        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while(head!= null){
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head= next;
            }
            return prev;
        }

    public static void main(String[] args){

    }
}
