package microsoftOA;

import java.util.Scanner;

public class MinDeletionToObtainStringInRightFormat {
    public static int minStep(String str) {

        int indexA = -1;
        int indexB = str.length();
        while(str.charAt(indexA+1) == 'A'){
            indexA++;
        }
        while(str.charAt(indexB-1) == 'B'){
            indexB--;
        }
        if(indexA < indexB-1){
            return deleteAorB(str.substring(indexA+1,indexB));
        }else{
            return 0;
        }
    }
    public static int deleteAorB(String str){
        int delCountA =0;
        int delCountB =0;

        int indexA =0;

        int indexB = str.length()-1;
        for(int i=indexA; i< str.length()-1;i++){
            if(str.charAt(i) != 'A'){
                delCountB++;
            }
        }
        for(int i=indexB;i> 0;i--){
            if(str.charAt(i) != 'B'){
                delCountA++;
            }
        }
        return Math.min(delCountA, delCountB);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        System.out.println(minStep(str));
    }
}
