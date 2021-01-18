package problemsmisc;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){

        System.out.println("Enter the string to be checked::");
        Scanner input = new Scanner( System.in );

        System.out.println( "Is String a palindrome?  " + isPalindrome( input.nextLine() ));


    }
    public static boolean isPalindrome( String input ) {
        String reverseString = new StringBuilder( input ).reverse().toString();
        return input.equals(reverseString);

    }
}
