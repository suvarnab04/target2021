package Problems;

public class Fibonacci {
    public static void main(String[] args){
        int count = 5;
        int firstNumber = 0;
        int secondNumber = 1;

        System.out.print(firstNumber +"\t" + secondNumber+"\t");

        fib(count, firstNumber, secondNumber);

        int index =4;
        System.out.println("\nfibonacci number at index " + index +" is::" +fibRec(index));
    }

    private static void fib(int count, int firstNumber, int secondNumber) {
        for (int i = 2; i < count; i++) {
            int sum = firstNumber + secondNumber;

            System.out.print(sum + "\t");
            //swap
            firstNumber = secondNumber;
            secondNumber = sum;


        }
    }
        private static int fibRec(int num){
            if(num ==0 ){
                return 0;
            }else if(num == 1){
                return 1;
            }else{
                return fibRec( num -1 ) + fibRec(num - 2);
            }
        }

}
