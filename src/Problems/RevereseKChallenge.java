package Problems;


import DataStructures.Queue;
import DataStructures.Stack;

class ReverseKChallenge {
    public static <V> void reverseK(Queue<V> queue, int k) {
        // Write -- Your -- Code
        Stack<V> stack = new Stack(k);

        while(!stack.isFull()){
            stack.push(queue.dequeue());
        }
        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
        queue.printQueue();
        for(int i=0;i< queue.getCurrentSize()-k;i++){
            queue.enqueue(queue.dequeue());
        }


    }
    public static void main(String[] args){
        Queue<Integer> queue = new Queue(5);


        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);


        reverseK(queue, 3);
        queue.printQueue();

    }
}
