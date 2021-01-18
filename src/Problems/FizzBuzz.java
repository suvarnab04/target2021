package Problems;

public class FizzBuzz {
    public static void main(String[] args){
        int[] numbers = new int [15];
        for(int i =1; i<= numbers.length; i++){
            String display = "";
            display += ( i%3 == 0 ) ? "FIZZ" : "";
            display += (i%5 ==0) ? "BUZZ" : "";
            System.out.print("\t" + (display.isEmpty() ? i : display));
        }
    }


}
