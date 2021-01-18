package DataStructures;

import java.util.Scanner;

public class Stacks {
    public static void main(String[] args){
            StackOfIntegers stack = new StackOfIntegers(1);
            Scanner getOptions = new Scanner( System.in );
            System.out.println("1 Push \n2 Peek\n3 Pop\n4 Empty\n5 Print\n0 Exit");
            System.out.print("Enter the operation you want to perform on the stack:: ");
            int choice = getOptions.nextInt();
            while( choice != 0){
                switch (choice){

                    case 1:
                        stack.push(3);
                        stack.push(6);
                        break;
                    case 2:
                        System.out.println("\nelement at the top :: " + stack.peek());
                        break;
                    case 3:
                        stack.pop();
                        break;
                    case 4:
                        break;
                    case 5:
                        stack.printStack();
                        break;


                }
                System.out.print("Enter the operation you want to perform on the stack::(1 Push 2 Peek 3 Pop 4 Empty 5 Print 0 Exit) ");
                choice = getOptions.nextInt();
            }

    }
}
 class StackOfIntegers {
    private int[] elements;
    private int top = -1; //number of elements in the stack
     private static final int DEFAULT_CAPACITY = 16;
    StackOfIntegers(){
         this.elements = new int[DEFAULT_CAPACITY];
    }
    StackOfIntegers( int size ){
       this.elements = new int[size];

    }
    public int getSize(){
        return top;
    }
    public void push( int element ){
        if(top == elements.length -1 ){
            int [] temp = new int[elements.length *2]; //double the size of the array
            System.arraycopy(elements,0,temp,0,elements.length);
            elements = temp;

        }
        System.out.printf("Push %d on to the stack\n", element);
        elements[++top] = element;


    }
    public int peek(){
        return elements[ top  ];
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        System.out.println("Removing element at the top");
        return elements [top--];
    }
    public boolean isEmpty(){
        return this.top == -1;
    }
    public int empty(){
        return this.top = -1;
    }
    public void printStack(){
        for(int i = top ;i > -1 ; i--){
            System.out.println("|" + elements[i] + "|");
        }
    }
}
