package curatedlist.graph;

import java.util.*;
/*
https://leetcode.com/problems/clone-graph/
https://backtobackswe.com/platform/content/clone-a-graph/video
 */
class Node {
    public int val;

    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }


        Queue<Node> queue = new LinkedList();
        queue.add(node);

        Map<Node,Node> nodeCopy = new HashMap();
        nodeCopy.put(node, new Node(node.val));


        while(!queue.isEmpty()){

            Node curr = queue.remove();



            for(Node neighbor : curr.neighbors){

                if(!nodeCopy.containsKey(neighbor)){

                    nodeCopy.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                nodeCopy.get(curr).neighbors.add(nodeCopy.get(neighbor));
            }


        }

        return nodeCopy.get(node);


    }
}
