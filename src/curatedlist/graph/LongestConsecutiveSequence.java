package curatedlist.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://www.youtube.com/watch?v=P6RZZMu_maU
https://leetcode.com/problems/longest-consecutive-sequence/
consecutive sequence is any sequence in which the numbers are consecutive but need not to be present one after other
1, 10,2,25 -- 1,2 is the consecutive sequence
Step1: create node for each number, node points to itself i.e. the parent of node is node itself, and add it to
the map of val-->Node
Step2: Union
 smallest parent become the parent of other node.
 */
public class LongestConsecutiveSequence {
    /**
     * more intuitive approach
     * @param nums
     * @return
     */

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        int longest =0;
        for(int i=0;i< nums.length;i++){
            int num = nums[i];
            if(!set.contains(num-1)){
                //keep looking for the consecutive number
                int length =0;
                while(set.contains(num)){
                    length++;
                    num = num+1;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
    public int longestConsecutive1(int[] nums) {
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



            unionSet(node, prev);
            unionSet(node, next);

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
