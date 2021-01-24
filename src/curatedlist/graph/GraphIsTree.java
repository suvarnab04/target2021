package curatedlist.graph;

import java.util.*;
/*
https://leetcode.com/problems/graph-valid-tree/
 */
public class GraphIsTree {
    static final String WHITE ="WHITE";
    static final String BLACK ="BLACK";
    static final String GREY ="GREY";
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjMap = new HashMap();
        for(int i=0;i< n;i++){
            adjMap.put(i, new HashSet());
        }
        for(int i=0;i< edges.length;i++){
            int first = edges[i][0];
            int sec = edges[i][1];

            adjMap.get(first).add(sec);
            adjMap.get(sec).add(first);

        }
        for(Map.Entry<Integer,Set<Integer>> entry  : adjMap.entrySet()){
            System.out.println();
            System.out.print(entry.getKey()+"::");
            for(int i: entry.getValue()){
                System.out.print(i+",");
            }
        }
        String[] status = new String[n];
        Arrays.fill(status,WHITE);

        /**
         if the graph is connected then we should be able to visit all nodes if we start from any node
         */
        if(status[0].equals(WHITE) && isCycle(-1,0, adjMap, status)){
            return false;
        }

        for(int i=0;i< n;i++){
            if(!status[i].equals(BLACK)){
                return false;
            }
            System.out.print("  i::"+i+"-"+status[i]);
        }
        return true;

    }
    public boolean isCycle(int prev,int node,  Map<Integer, Set<Integer>> adjMap,String[] status){
        System.out.println("prev::"+prev+ " node::"+ node+" status::"+status[node]);

        if(status[node].equals(GREY)){
            return true; //cycle detected
        }
        status[node] =GREY; //started processing the node

        for(int adj :  adjMap.get(node)){
            if(!status[adj].equals(BLACK) && adj!= prev){
                if(isCycle(node,adj, adjMap, status)){
                    return true;
                }
            }
        }
        status[node] = BLACK;
        return false;
    }
}
