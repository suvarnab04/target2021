package problemsmisc;

public class MinDeletion {


    public int minDeletionSize(String[] A) {

        int stringSize = A[0].length();

        boolean[] indexToBeDeleted = new boolean[stringSize];

        boolean isSorted = false;
        int index = 0;

        while(!isSorted ||index < A.length-2 ){

            String word1 = getModifiedString(A[index],indexToBeDeleted);
            String word2 = getModifiedString(A[index+1],indexToBeDeleted);

            int charIndex = 0;

            while(charIndex < stringSize ){
                //if the first char are same then check for the remaining char
                //if the first char of word 1 is smaller than word 2
                if(word1.charAt(charIndex)== word2.charAt(charIndex)){ //check if we are suppose to delete the index
                    isSorted = true;
                    charIndex++;
                }else if(word1.charAt(charIndex) < word2.charAt(charIndex)){// word2 is greater than word1 // nothing to do here
                    isSorted = true;
                    break;
                }
                else if(word1.charAt(charIndex) > word2.charAt(charIndex)){ //check if we are suppose to delete the index

                    indexToBeDeleted[charIndex] = true;
                    charIndex++;
                    isSorted = false;
                }
            }//end of while
            if(!word1.equals(getModifiedString(word1,indexToBeDeleted))){
                index = 0;
            }else{
                index++;
            }
        }//end of for word1

        int count=0;

        for(int i=0;i< indexToBeDeleted.length;i++){

            if(indexToBeDeleted[i]){
                count++;
            }
        }
        return count;


    }


    public String getModifiedString(String word, boolean [] indexToBeDeleted ){

        String newString="";
        for(int i=0;i< indexToBeDeleted.length;i++){
            if(indexToBeDeleted[i]){
                newString += "\0";
            }
            else{
                newString += word.charAt(i);
            }
        }
        return newString;
    }
    public int getCharTotal(String word){

        int total=0;
        for(int i=0;i< word.length();i++){
            total += word.charAt(i) - 'a';
        }
        return total;
    }

public static void main(String[] args){
        String[] strs = {"zyx","wvu","tsr"};
        /*
        ["ca","bb","ac"]
["zyx","wvu","tsr"]
         */
        System.out.println(new MinDeletion().minDeletionSize(strs));

        String name = "suvarna bothe";
        String firstName = name.split(" ")[0];
}
}
