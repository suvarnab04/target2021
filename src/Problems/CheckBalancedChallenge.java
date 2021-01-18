package Problems;

import DataStructures.Stack;

import java.util.*;

public class CheckBalancedChallenge {
    final static  Map<Character, Character> map = new HashMap<Character,Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        } };
    public static boolean isBalanced(String exp) {
       char[] exps = exp.toCharArray();
       Stack<Character> stack = new Stack<>(exps.length);

       for(int i=0;i<exps.length;i++){
           //check if its a open bracket. if open bracket the push onto the stack
           //if its a closing bracket then pop the element from stack and get the value from the map if the closing corresponds to the incoming closing then move to the next element
           //if it doesnt match then its not a balanced expression
           if(map.containsKey(exps[i])){ //that means its a opening bracket
               stack.push(exps[i]);
           }else{
               char closingBracket = exps[i];
               if(map.get(stack.pop()) != closingBracket){
                   return false;
               }
           }

       }

        // Write -- Your -- Code
        return stack.isEmpty();
    }
    public static void main(String[] args){
        String string =  "{[({})]}";
        System.out.print("Is balanced::" + isBalanced(string));

    }
}
