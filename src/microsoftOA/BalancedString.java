package microsoftOA;

import java.util.HashSet;
import java.util.Set;

/**
 * A string is considered balanced when every letter in the string appears both in uppercase and lowercase
 * For example, CATattac is balanced (a, c, t occur in both cases). Madam is not (a, d only appear in lowercase).
 * Write a function that given a string returns the shortest balanced substring of that string.
 * Can this be solved with a sliding window approach?
 * Update:
 * More examples
 * “azABaabza” returns “ABaab”
 * “TacoCat” returns -1 (not balanced)
 * “AcZCbaBz” returns the entire string
 */
public class BalancedString {

    public static String solution(String s) {
        int minLength = Integer.MAX_VALUE;
        String minString ="" ;
        for(int start =0;start< s.length();start++){
            String expanded = expandAndCheck(start, s, minLength);
            if(expanded!="" && expanded.length() < minLength){
                minString = expanded;
                minLength = expanded.length();
               // System.out.println(expanded);
            }

        }
      return minLength == Integer.MAX_VALUE ? "-1" : minString;
    }

   public static String expandAndCheck(int start, String s, int minSeeen){
        int end = start;
        while(end< s.length()){
            String check = s.substring(start,end+1);

            //opytimization
            if(check.length()>=minSeeen){
                return "";
            }

                if (isBalanced(check)) {
                    return check;
                }

            end++;
        }
        return "";
   }
   public static boolean isBalanced(String str){
        Set<Character> lower = new HashSet<>();
       Set<Character> upper = new HashSet<>();

        for(int i=0;i< str.length();i++){
            if(Character.isLowerCase(str.charAt(i))){
                lower.add(str.charAt(i));

            }else{
                upper.add(str.charAt(i));
            }
        }
        if(lower.isEmpty() || upper.isEmpty()){
            return false;
        }
        if(lower.size()!= upper.size()){
            return false;
        }

      for(char ch : lower){
          if(!upper.contains(Character.toUpperCase(ch))){
              return false;
          }

      }

       return true;

   }
    public static void main(String [] args){
        System.out.println(solution("azABaabza"));
        System.out.println(solution("TacoCat"));
        System.out.println(solution("AcZCbaBz"));
    }
}
