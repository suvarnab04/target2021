package curatedlist.lowLevelDesign;

import java.util.*;
/*
https://leetcode.com/problems/lru-cache/
 */
class LRUCache {

       Map<Integer,ListNode> cache;
        ListNode head;
        ListNode tail;
        int capacity;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new java.util.HashMap<Integer,ListNode>();
            this.head = new ListNode();
            this.tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(cache.containsKey(key)){
                //move to head
                ListNode dll = cache.get(key);
                MoveToHead(dll);
                return dll.val;
            }
            return -1;
        }

        public void put(int key, int value) {

            if(cache.size()==capacity && !cache.containsKey(key)){
                ListNode last = removeLast();
                cache.remove(last.key);

            }
            ListNode dll  = cache.getOrDefault(key, new ListNode() );
            dll.key = key;
            dll.val = value;
            cache.put(key, dll);

            MoveToHead(dll);

        }
        public ListNode removeLast(){
            ListNode last = tail.prev;
            last.prev.next = tail;
            tail.prev = last.prev;

            return last;
        }
        public void MoveToHead(ListNode curr){

            ListNode next = curr.next;
            ListNode prev = curr.prev;

            if(next!=null && prev!=null){  //new node
                prev.next = next;
                next.prev = prev;
            }


            ListNode headNext = head.next;
            headNext.prev = curr;
            head.next = curr;
            curr.next = headNext ;
            curr.prev = head;
        }
        private class ListNode{
            int key;
            int val;
            ListNode prev;
            ListNode next;


        }
        public static void main(String[] args){
            LRUCache lru = new LRUCache(2);
            lru.put(1,1);
            lru.put(2,2);
            System.out.println(lru.get(1)==1);
            lru.put(3,3);
            System.out.println(lru.get(2)==-1);

        }

}

