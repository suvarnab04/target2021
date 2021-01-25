package curatedlist.graph;

import java.util.HashMap;
import java.util.Map;
/*
https://leetcode.com/problems/longest-consecutive-sequence/
consecutive sequence is any sequence in which the numbers are consecutive but need not to be present one after other
1, 10,2,25 -- 1,2 is the consecutive sequence
Step1: create node for each number, node points to itself i.e. the parent of node is node itself, and add it to
the map of val-->Node
Step2: Union
 2.1 for each number in the array check if node for next = (num+1) or prev =num(-1) is present in the map.
 for eg for num 2, check if node for 1 or node for 3 are present in the map. If present that means nums[] has that
 number so that will be part of our answer
 2.2 both next and prev are not present then we dont have anything to process move to the next number in the array
 2.3 if both prev and next are present in the map, then get the parents for both and the smaller parent becomes the parent of bigger node.
 2.4 if only prev is present the depending on which is smaller amongst the node and prev becomes the parent
 2.5.if only next is present then smallest parent become the parent of other node.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        UnionFind unionFind = new UnionFind();
        for(int i=0;i< nums.length;i++){
            unionFind.makeNode(nums[i]);
        }
        //union
        int max = Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            unionFind.union(nums[i]);
            int childCount = unionFind.getChildCount(nums[i]);
            if(childCount >max){
                max = childCount;
            }
        }

        return max;

    }
    public class UnionFind{
        Map<Integer,Node> nodesMap = new HashMap();
        class Node{
            public int val;
            public Node parent;
            public int children; //helps to keep track how many nodes are present in the tree
        };
        public void makeNode(int val){
            Node node = new Node();
            node.val = val;
            node.parent = node;
            node.children =1; // when a node is created only 1 node is present in the tree
            nodesMap.put(val, node);
        }
        public void union(int val){

            Node node = nodesMap.get(val);
            Node prev = nodesMap.get(val-1); // get the node for previous number
            Node next = nodesMap.get(val+1); // get the node for next number

            if(prev == null && next == null){ //if next and prev are not present then these cant be part of the result
                return;
            }

            if(prev!=null && next!=null){ // if both are present then join them and create one tree
                unionSet(prev, next);

            }else if(prev!=null){ // join node and prev val
                unionSet(node, prev);
            }else{
                unionSet(node, next); // join node and next
            }

        }
        public void unionSet(Node node1, Node node2){
            Node parent1 = find(node1);
            Node parent2 = find(node2);
            if(parent1 == parent2){ // if parents are same then they are in the same set, nothing to do here
                return;
            }
            int cnt = parent1.children + parent2.children; // get the count of both parents before merging
            if(parent1.val < parent2.val){
                parent2.parent = parent1;
                parent1.children = cnt;
            }else{
                parent1.parent = parent2;
                parent2.children= cnt;
            }

        }
        //returns the parent
        public int getChildCount(int val){
            Node node = nodesMap.get(val);
            return find(node).children;
        }
        public Node find(Node node){
            Node parent = node.parent;
            if(node == parent){
                return node;
            }
            node.parent = find(node.parent);
            return node.parent;
        }
    };
}
