package problemsmisc;

import dataStructures.DoublyLinkedList;
import dataStructures.Graph;
import dataStructures.Queue;
import dataStructures.Stack;



public class GraphProblems {

    public static void removeEdgeChallenge(Graph g, int src, int dest){

       System.out.println("Graph before deleting src:: "+ src+"\t" +"dest:: "+ dest);
        g.printGraph();

        DoublyLinkedList childList = g.getAdjacencyList()[src];
        childList.deleteLink(dest);

        System.out.println("Graph after deleting src:: "+ src+"\t" +"dest:: "+ dest);
        g.printGraph();

    }
    public static int findShortestPathLength(Graph g, int source, int destination){
        //do bfs from the source
        //when we traverse level wise each node will have the shortest path from the source.
        //if there are more paths present through the same nodes in that case we will skip those nodes as the nodes are already visited.
        //we use an array to keep the distance of current node from source.
        //for the current node we add 1 to the parent[distance] that will be the distance for the current node
        Queue<Integer> queue = new Queue<>(g.getVertices());
        boolean[] alreadyVisited = new boolean[g.getVertices()];

        queue.enqueue(source);
        alreadyVisited[source] = true;

        int[] distance= new int[g.getVertices()];

        while(!queue.isEmpty()){
            int top = queue.dequeue();

            DoublyLinkedList list = g.getAdjacencyList()[top];
            DoublyLinkedList.Node temp = list.getHeadNode();
            while(temp!=null ){
               if(!alreadyVisited[(int) temp.data] ) {
                   queue.enqueue((int) temp.data);
                   distance[(int) temp.data] = distance[top]+1;
                   alreadyVisited[(int) temp.data] = true;
               }
               temp = temp.nextNode;
            }
        }
         return distance[destination];
    }

    public static boolean isTree(Graph g){
        //1. each node has one parent except root, root has 0 parent
        //2. no cycles are present
        //3. graph is connected, i.e there is an incoming edge for each vertex ecpet root. Root doesnt have ant incoming edge
        if(!hasOneParent(g) ){
            return false;
        }
        if(!isConnected(g)){
            return false;
        }

        return true;
    }
    public  static boolean isConnected(Graph g){
        boolean isConnected = false;
        int i=0;
        while(!isConnected && i< g.getVertices()) {
            isConnected = isConnectedGraph(g, i);
            i++;

        }
        return isConnected;
    }
public static boolean isConnectedGraph(Graph g, int vertex){
        /*
        traverese bfs for each node, if the number of nodes visited is equal to total
        vertices that means the graph is conncted
         */
        Queue<Integer> queue = new Queue<>(g.getVertices());
        Integer[] alreadyVisited = new Integer[g.getVertices()];
        int alreadyVisitedIndex = 0;

            queue.enqueue(vertex);
            alreadyVisited[alreadyVisitedIndex++] = vertex;

            while(!queue.isEmpty()){
                int top = queue.dequeue();
                DoublyLinkedList childList = g.getAdjacencyList()[top];
                DoublyLinkedList.Node temp = childList.getHeadNode();
                while(temp!=null){
                    queue.enqueue((int) temp.data);
                    alreadyVisited[alreadyVisitedIndex++] = (int) temp.data;
                    temp = temp.nextNode;
                }
            }


        return (alreadyVisitedIndex == g.getVertices());
}
    public static boolean hasOneParent(Graph g){
        //keep an array of vertices to keep track how many times it has appeared in the adjacency list
        //vertex with one parent should appear only once
        //if the count becomes 2 that means the vertex/node has two parents

        int[] parents = new int[g.getVertices()];
        for(int parent=0;parent< g.getVertices();parent++){

            DoublyLinkedList childList = g.getAdjacencyList()[parent];
            DoublyLinkedList.Node temp = childList.getHeadNode();

            while(temp!=null){
                int node = (int)temp.getData();
                parents[node] = parents[node] +1;
                if(parents[node] >1){
                    return false;
                }
                temp = temp.nextNode;
            }
        }


        return true;
    }

    public static boolean checkPath(Graph g, int source, int destination){
        Stack<Integer> stack = new Stack<>(g.getVertices());
        Integer[] alreadyVisited= new Integer[g.getVertices()];
        int alreadyVisitedIndex = 0;

        stack.push(source);
        alreadyVisited[alreadyVisitedIndex++] = source;
        while(!stack.isEmpty()){
            int top = stack.top();
            if( top == destination){
                return true;
            }

            DoublyLinkedList list = g.getAdjacencyList()[top];
            DoublyLinkedList.Node temp = list.getHeadNode();

            while(temp!=null && isAlreadyVisited(alreadyVisited, (int) temp.data)){
                temp = temp.nextNode;
            }
            if(temp!=null){
                stack.push((int)temp.data);
                alreadyVisited[alreadyVisitedIndex++] = (int) temp.data;
            }else{

                alreadyVisited[alreadyVisitedIndex++] = stack.top();
                stack.pop();

            }
        }
        return false;

    }

    public static int checkNumEdges(Graph g){
        //bfs implementation

       int sum =0;
        for(int i=0;i< g.getVertices();i++){
            DoublyLinkedList list = g.getAdjacencyList()[i];
            DoublyLinkedList.Node temp = list.getHeadNode();
            while(temp!=null){
                sum++;
                temp = temp.nextNode;
            }

        }
        return sum/2;
    }

    public static int findMotherVertex(Graph g){
        //logic
        /*
        1. for each vertex get all the possible paths, if the path has covered all the nodes i.e
        the number of nodes traversed is equal to the vertices then that vertex is mother vertex.
         */
        for(int i=0;i< g.getVertices();i++){ // pass each vertex to findMotherVertexRec() to get all possible paths, if any path whose length is equal to the number
            // of vertices is found then return
            int  noOfNodesVisited = findMotherVertexRec(i, g);
            if(noOfNodesVisited == (g.getVertices())){
                return i;
            }
        }
        return -1;
    }

    public static int findMotherVertexRec(int currentVertex, Graph g){
        //stack to keep the verices
        int result=0;
        int vertices = g.getVertices();
        Stack<Integer> stack = new Stack<>(vertices);
        Integer[] alreadyVisitedNodes = new Integer[vertices];
        int alreadyVisitedIndex= 0;

        Integer[] parentNodes = new Integer[vertices];
        int parentNodeIndex= 0;

        //an array to keep track of already visited nodes

        /**
         * perform dfs for each incoming vertex.
         */
        stack.push(currentVertex);
        result++;
        alreadyVisitedNodes[alreadyVisitedIndex++] = currentVertex;

            while(!stack.isEmpty()){
                int top = stack.top();

                DoublyLinkedList<Integer> list = g.getAdjacencyList()[top];
                DoublyLinkedList.Node temp = list.getHeadNode();

                while(temp!=null && isAlreadyVisited(alreadyVisitedNodes, (int)temp.data)){ // check all possible paths
                    temp = temp.nextNode;
                }
                if(temp!=null){
                    stack.push((int)temp.data);
                    result++;
                    alreadyVisitedNodes[alreadyVisitedIndex++] = (int)temp.data;
                    parentNodes[parentNodeIndex++] = top;
                }else{
                    if(!isAlreadyVisited(alreadyVisitedNodes, stack.top())){ //for the leaf node there is no adjacency list, so mark this as visited
                        alreadyVisitedNodes[alreadyVisitedIndex++] = stack.top();
                    }
                    result--; //null is reached tht means we have reached the leaf node
                    stack.pop();

                }
                if(result == g.getVertices()){
                    return result;
                }
            }

      //  System.out.println(result);
        return result;
    }
    public static boolean detectCycle(Graph g){
        String result ="";
        Stack<Integer> stack = new Stack(g.getVertices());

        Integer[] alreadyVisitedNodes = new Integer[g.getVertices()];
        int alreadyVisitedSize = 0;

        Integer[] parentNodes = new Integer[g.getVertices()];
        int parentIndex = 0;


        for(int i=0;i<g.getVertices();i++){
            if(!isAlreadyVisited(alreadyVisitedNodes, i)){
                stack.push(i);
                alreadyVisitedNodes[alreadyVisitedSize++] = i;
            }
            while(!stack.isEmpty()){
                int top = stack.top();
                DoublyLinkedList adjList = g.getAdjacencyList()[top];
                DoublyLinkedList.Node temp = adjList.getHeadNode();

                while(temp!=null && isAlreadyVisited(alreadyVisitedNodes,(int)temp.getData())) {

                    temp= temp.nextNode;

                }
                if(temp!=null){
                    parentNodes[parentIndex++] = top; //the current node at top is the parent to the node that we are going to push
                    //but before pushing the node we are going to check if cycle is present, in the incoming child's adjacency list if we find the parent
                    // that mean the child points back to the parent


                    if (isCycle(parentNodes,parentIndex, g.getAdjacencyList()[(int)temp.getData()])){
                        return true;
                    }
                    stack.push((int)temp.getData());
                    alreadyVisitedNodes[alreadyVisitedSize++] = (int)temp.getData();

                }else{

                    if(!isAlreadyVisited(alreadyVisitedNodes,stack.top() )){
                        alreadyVisitedNodes[alreadyVisitedSize++] = (int)temp.getData();
                    }
                    //before poping from the stack update the parent nodes too
                    removeParent(parentNodes,parentIndex, stack.top());
                    stack.pop();
                }
            }


        }
        return false;
    }
    public static void removeParent(Integer[] parentNodes,int parentIndex,int parent){
        for(int i=parentIndex-1;i>= 0;i--){
            if(parentNodes[i] !=null && parentNodes[i] == parent){
                parentNodes[i] = null;
                parentIndex--;
            }
        }
    }
    public static boolean isCycle(Integer[] parentNodes,int parentIndex, DoublyLinkedList childList ){

            for(int i=0; i< parentIndex;i++ ){

                DoublyLinkedList.Node temp = childList.getHeadNode();
                while(temp!=null){
                    if(parentNodes[i] != null &&  parentNodes[i] == (int)temp.data){
                        return true;
                    }
                    temp=temp.nextNode;
                }
            }

        return false;
    }
    public static boolean isAlreadyVisited(Integer[] alreadyVisited, int vertex){
        for(int i=0;i< alreadyVisited.length;i++){
            if(alreadyVisited[i] !=null && alreadyVisited[i].intValue() == vertex){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){

        //no cycle
      /*  Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(3,1);
        System.out.println(detectCycle(graph));*/

        //cycle
        /*Graph graph = new Graph(3);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        System.out.println(detectCycle(graph));*/

        //mother vertex grap 1, MV=-1
       /* Graph graph = new Graph(4);
        graph.addEdge(1,2);
        graph.addEdge(3,0);
        graph.addEdge(3,1);*/

        //mother vertex grap 1, MV=3
       /* Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(3,0);
        graph.addEdge(3,1);*/

       // System.out.println(findMotherVertex(graph));
       /* Graph graph = new Graph(3);
        graph.addEdge(0,1);
        graph.addEdge(1,2);

        System.out.println(checkNumEdges(graph));*/

        //check path
        /*Graph g1 = new Graph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        */
         //isTree
       /* Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        System.out.println("Is graph a tree: " + isTree(graph));*/


        //shortest path
        Graph graph = new Graph(6);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        System.out.println("Is graph a tree: " + findShortestPathLength(graph, 1,5));
    }
}
