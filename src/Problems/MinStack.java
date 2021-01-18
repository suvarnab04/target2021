package Problems;

import DataStructures.Stack;

public class MinStack {
    int maxSize;
    Stack<Integer> stack;

    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
        this.stack = new Stack(maxSize);
    }
    //removes and returns value from stack
    public Integer pop(){
        // Write -- Your -- Code
        return stack.pop();
    }
    //pushes value into the stack
    public void push(Integer value){
        // Write -- Your -- Code
        //put the new value at its correct place, min should always be at the top
        //1. size is 0
        if(stack.isEmpty()){
            stack.push(value);
        }else if(value < stack.top() ){
            stack.push(value);
        }
        else{// rearrange the stack
            Stack<Integer> tempStack = new Stack<>(stack.getCurrentSize()); // copy of original stack
            while(!stack.isEmpty()){
                tempStack.push(stack.pop());
            }

            boolean found = false;
            while(!tempStack.isEmpty() && !found){

                int tempStackValue = tempStack.pop();

                if( value > tempStackValue){
                    stack.push(value);
                    stack.push(tempStackValue);
                    found = true;

                }else{
                    stack.push(tempStackValue);

                }
            }
            while(!tempStack.isEmpty()){
                stack.push(tempStack.pop());
            }

        }
        //size is 1 or more
    }
    //returns minimum value in O(1)
    public int min(){
        // Write -- Your -- Code
        return stack.top();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String [] args){
        MinStack minStack= new MinStack(5);
        minStack.push(1);
       minStack.push(10);
       minStack.push(2);
        minStack.push(7);
        minStack.push(5);


        while(!minStack.isEmpty()){
            System.out.println("|"+ minStack.pop()+"|");
        }
    }
}
