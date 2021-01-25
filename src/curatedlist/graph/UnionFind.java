package curatedlist.graph;
/*
https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/DisjointSet.java
https://www.youtube.com/watch?v=ID00PMy0-vE
 */
import java.util.HashMap;
import java.util.Map;
public class UnionFind {
    Map<Integer,Node> vertexNodeMap = new HashMap<>();
    class Node{
        int val;
        Node parent;
        int rank;
        Node(int val){
            this.val = val;
            parent = null;
            rank =0;
        }
    };
    public void makeNode(int val){
        Node node = new Node(val);
        node.parent = node; //node points to itself
        node.rank =0;
        vertexNodeMap.put(val, node);
    }
    public boolean union(int val1, int val2) {
        Node parent1 = findSet(vertexNodeMap.get(val1));
        Node parent2 = findSet(vertexNodeMap.get(val2));
        if(parent1== parent2) {
            return false; //both belong to same tree so union is not possible
        }


        if(parent1.rank == parent2.rank){ //pick any one, anyone can be the parent, who ever becomes parent increment the rank
            parent2.parent = parent1;
            parent1.rank = parent1.rank+1;
        }else if(parent1.rank > parent2.rank){
            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }

        return true;
    }
    //returns the root
    public int findSet(int val) {
        Node node = vertexNodeMap.get(val);
        return findSet(node).val;

    }
    public Node findSet(Node node) {

        if(node.parent == node) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

}