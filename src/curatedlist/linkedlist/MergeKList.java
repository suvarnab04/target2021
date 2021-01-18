package curatedlist.linkedlist;

public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }

        ListNode l1 = lists[0];
        for(int i=1;i< lists.length;i++){
            ListNode l2 = lists[i];
            l1 = mergeList(l1, l2);
        }
        return l1;
    }
    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode temp = new ListNode(0);
        ListNode head = temp;

        while(l1!=null && l2!=null){
            if(l1.val< l2.val){
                head.next = l1;
                l1= l1.next;
            }else{
                head.next= l2;
                l2 = l2.next;

            }
            head= head.next;
        }
        if(l1!=null){
            head.next=l1;
        }else if(l2!=null){
            head.next = l2;
        }
        return temp.next;
    }
}
