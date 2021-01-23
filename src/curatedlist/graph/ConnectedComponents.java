package curatedlist.graph;

import java.util.*;

/*
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
https://www.youtube.com/watch?v=709q5pkG40s
 */
public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap();
        for(int i=0;i<edges.length;i++){
            int first = edges[i][0];
            int sec = edges[i][1];
            Set<Integer> set1 = map.getOrDefault(first,new HashSet());
            set1.add(sec);

            map.put(first, set1);

            Set<Integer> set2 = map.getOrDefault(sec,new HashSet());
            set2.add(first);
            map.put(sec, set2);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i< n;i++){

            if(!visited[i]){
                dfs(i, visited, map);
                count++;
            }

        }
        return count;
    }
    public void dfs(int i, boolean[] visited,Map<Integer, Set<Integer>> map ){
        Stack<Integer> stack = new Stack();
        stack.push(i);

        while(!stack.isEmpty()){
            int visit = stack.pop();

            visited[visit] = true;
            Set<Integer> neighbors = map.get(visit);
            if(neighbors!=null && !neighbors.isEmpty()){
                for(int n :  neighbors){
                    if(!visited[n])
                        stack.push(n);
                }

            }

        }

    }
}
