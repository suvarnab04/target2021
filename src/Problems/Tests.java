package Problems;

import DataStructures.Stack;

public class Tests {

    public static void main(String[]args){

        String expression="921*-8-4+";
        char[] arr  = expression.toCharArray();
        Stack<Integer> stack = new Stack(arr.length);

        for(int i= 0; i< arr.length;i++){
            //push on the stack till you get the operand
            if(Character.isDigit(arr[i])){
                stack.push(Character.getNumericValue(arr[i]));
            }else{
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                int result = performOperation(firstOperand, secondOperand, arr[i]);
                System.out.println("FirstOperand::"+ firstOperand +"\tSecondOprand::"+ secondOperand+"\t operator::"+ arr[i] +"\t result::"+ result);
                stack.push(result);
            }

        }
        System.out.println(stack.pop());


    }
    public static boolean isOperator (char c){
        char[] operators ={'+','-','*','/'};
        for(int i=0;i< operators.length;i++){
            if(operators[i] == c){
                return true;
            }
        }
        return false;
    }
    public static int performOperation (int firstOperand, int secondOperand,char operation){
        switch(operation){
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                return firstOperand / secondOperand;
            case '%':
                return firstOperand % secondOperand;
            default:
                return -1;
        }
    }
}
