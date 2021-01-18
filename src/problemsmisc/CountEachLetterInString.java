package problemsmisc;

import java.util.Scanner;

public class CountEachLetterInString {
    public static void main(String[] args)
    {
        System.out.println("Enter the string::");
        String inputString = new Scanner(System.in).nextLine();
        int[] alphabetCounts = new int[26];

        for(int i=0; i < inputString.length(); i++){
            if(Character.isLetter(inputString.charAt(i))){
                alphabetCounts[inputString.charAt(i) - 'a']++;
            }
        }
        for(int i=0; i< alphabetCounts.length;i++){
            if(alphabetCounts[i] > 0){
                System.out.printf("letter %s found %d times\n", (char)('a' + i), alphabetCounts[i]);
            }
        }
    }
}
