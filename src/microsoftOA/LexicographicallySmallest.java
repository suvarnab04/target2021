package microsoftOA;
/*
Given a string str, the task is to find the lexicographically smallest string that can be formed
by removing at most one character from the given string.
iterate over the string and when you get a char that is larger than the next char break from the loop
get substring 0-i and i+1- length()
 */
public class LexicographicallySmallest {
    public static String smallestString(String str) {
        int i=0;
        while(i< str.length()-1){
            if(str.charAt(i) > str.charAt(i+1)) {
                break;
            }
            i++;
        }
        return str.substring(0,i) + str.substring(i+1, str.length());
    }
    public static void main(String [] args){

    }
}
