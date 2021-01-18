package Recursion;

public class Factorial {
    public static int factorial(int num){
        if(num == 0){
            return 1;
        }
        else return num * factorial(num-1);
    }
    public static void main(String[] args){
        int num = 3;
        System.out.printf("Fatorial of %d is:: %d",num, factorial(num));
    }
}
