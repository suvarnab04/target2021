package curatedlist.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
https://leetcode.com/problems/merge-k-sorted-lists/
https://backtobackswe.com/platform/content/merge-k-sorted-lists/video
 */
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
};

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {

    if(lists == null || lists.length==0){
        return null;
    }
    ListNode dummyHead = new ListNode(0);
    ListNode dummyTail = dummyHead;
    int size = lists.length;

    PriorityQueue<ListNode> minHeap= new PriorityQueue<>(size,
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if(o1.val < o2.val){
                        return -1;
                    }else if(o1.val == o2.val){
                        return 0;
                    }else {
                        return 1;
                    }
                }
            });

        for(ListNode node: lists){
            if(node!=null){
                minHeap.add(node);
            }
        }
        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            dummyTail.next = minNode;
            dummyTail = minNode; //advance the tail pointer

            if(minNode.next!=null){
                minHeap.add(minNode.next);
            }
        }

        return dummyHead.next;
    }
}
