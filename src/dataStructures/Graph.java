package dataStructures;


public class Graph {
    private int vertices;
    private DoublyLinkedList<Integer> adjacencyList[];


    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];
        for(int i=0; i< vertices;i++){
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }
    public int getVertices(){
        return vertices;
    }
    public DoublyLinkedList[] getAdjacencyList(){
        return adjacencyList;
    }
    public void addEdge(int source, int destination){
        if(source < vertices && destination < vertices){
            this.adjacencyList[source].insertAtEnd(destination);
           // this.adjacencyList[destination].insertAtEnd(source); //comment this for directed graph
        }
    }
    public void addEdge(int source, int destination, boolean isUndirected){
        if(source < vertices && destination < vertices){
            this.adjacencyList[source].insertAtEnd(destination);
            this.adjacencyList[destination].insertAtEnd(source);
        }
    }

    public void printGraph(){
        for(int i=0;i< vertices;i++){
            DoublyLinkedList<Integer> adjList = adjacencyList[i];
            System.out.print(i+"--->");
            adjList.printList();
            System.out.println();
        }
    }
    public String bfs(){
        String result="";
        Integer[] alreadyVisited = new Integer[vertices];
        int alreadyVisitedIndex= 0;


        Queue<Integer> queue = new Queue<>(vertices);

        for(int i=0; i< adjacencyList.length;i++) {

            if (!isAlreadyVisited(alreadyVisited, i)) {
                queue.enqueue(i);
            }


            while (!queue.isEmpty()) {

                int visit = queue.dequeue();
                result += visit;
                alreadyVisited[alreadyVisitedIndex++] = visit;

                DoublyLinkedList adjNodes = adjacencyList[visit];
                DoublyLinkedList.Node temp = adjNodes.getHeadNode();
                while (temp != null) {
                    //before enqueing check if the node is already visited
                    if (!isAlreadyVisited(alreadyVisited, (int) temp.data)) {
                        queue.enqueue((int) temp.data);
                    }
                    temp = temp.nextNode;
                }

            }
        }
        return result;
    }
    public String dfs(){


        String result="";
        Stack<Integer> stack= new Stack<>(vertices);
        Integer[] alreadyVisited = new Integer[vertices];

        int alreadyVisitedIndex =0;

        for(int i=0; i< adjacencyList.length;i++) {
            if(!isAlreadyVisited(alreadyVisited,i)) {
                stack.push(i);
                result += i;
            }

            while (!stack.isEmpty()) {

                int currentNode = stack.top();
                DoublyLinkedList<Integer> adjList = adjacencyList[currentNode];
                DoublyLinkedList.Node temp = adjList.getHeadNode();

                //if temp==null that means no mode node, stop there and go back to the previous node
                //if temp!=null that means edges are present, skip the ones those are already visited.
                while (temp != null && isAlreadyVisited(alreadyVisited, (int) temp.data)) {
                    temp = temp.nextNode;
                }
                if (temp != null) {
                    stack.push((int) temp.data);
                    result += (int) temp.data;
                } else {
                    alreadyVisited[alreadyVisitedIndex++] = stack.top();
                    stack.pop();
                }

            }
        }

        return result;
    }

    public boolean isAlreadyVisited(Integer[] alreadyVisited, int vertex){
        for(int i=0;i< alreadyVisited.length;i++){
            if(alreadyVisited[i]!=null && alreadyVisited[i].intValue() == vertex){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
       // graph.addEdge(0,1);
        graph.printGraph();
        System.out.println("bfs::"+ graph.bfs());
        System.out.println("dfs::"+ graph.dfs());


    }
}
