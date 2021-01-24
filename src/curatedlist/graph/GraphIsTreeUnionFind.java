package curatedlist.graph;

public class GraphIsTreeUnionFind {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind();

        for(int i=0;i< n;i++){
            uf.makeNode(i);
        }
        for(int i=0;i< edges.length;i++){
            if(!uf.union(edges[i][0], edges[i][1])){
                return false;
            }
        }
        System.out.println("checking parents");
        int parent = uf.findSet(0);
        for(int i=0;i< n;i++){
            if(uf.findSet(i)!=parent){
                return false;
            }
        }
        return true;
    }
}
