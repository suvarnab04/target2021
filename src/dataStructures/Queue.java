package dataStructures;

public class Queue<V> {
    public static final int DEFAULT_SIZE = 5;
    V[] arr;
    int maxSize;
    int front;
    int back;
    int currentSize;



    public Queue(){
       this(DEFAULT_SIZE);
    }
    public Queue(int maxSize){
        this.arr = (V[]) new Object[maxSize];;
        this.maxSize = maxSize;
        this.front =0;
        this.back =-1;
        this.currentSize =0;

    }
public int getCurrentSize(){
        return currentSize;
}
    public void enqueue(V num){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }

        back = getIndexInRange(back+1); // to keep back in range
        if(back >= maxSize) {//if back is greater than maxSize then go back to 0
            back =0 ;
        }
        arr[back] = num;

        currentSize++;

    }
    //remove from the front
    public V dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty!!");
            return null;
        }
        V remove = arr[front];
        front = getIndexInRange(front+1);
        currentSize--;

        return remove;
    }
    public V top(){
        return arr[front];
    }
    public void printQueue(){
        //System.out.println();
        System.out.print("FRONT::"+front+"\tBACK::"+back+"\tQUEUE::");
        int count =0;
        int tempFront = front;
        while(count < currentSize){
            System.out.print(arr[tempFront] +"--");
            tempFront = getIndexInRange(tempFront+1);
            count++;
        }
        System.out.println();
    }
    public int getIndexInRange(int index){
        return (index) %maxSize;
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize == DEFAULT_SIZE;
    }

    public static void main(String [] args){
        Queue<Integer> queue = new Queue();

        //System.out.println("Is queue Empty:: " + queue.isEmpty());
       // System.out.println("Is queue full:: " + queue.isFull());

        queue.enqueue(1);
        queue.printQueue();

        queue.enqueue(2);
        queue.printQueue();

        queue.enqueue(3);
        queue.printQueue();

        queue.enqueue(4);
        queue.printQueue();

        System.out.println("Removing "+ queue.dequeue()+" from the queue");
        queue.printQueue();

        queue.enqueue(5);
        queue.printQueue();

        queue.enqueue(6);
        queue.printQueue();

       // System.out.println("Is queue Empty:: " + queue.isEmpty());
        System.out.println("Is queue full:: " + queue.isFull());

        queue.dequeue();
        queue.printQueue();

        queue.enqueue(7);
        queue.printQueue();


    }

}
