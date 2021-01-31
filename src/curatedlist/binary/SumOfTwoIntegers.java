package curatedlist.binary;
/*
https://leetcode.com/problems/sum-of-two-integers/
https://www.youtube.com/watch?v=qq64FrA2UXQ
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        //get the carry using & operator and shift left
        //get the sum using XOR operator
        while(b!=0) {
            int carry = a & b;
           // carry = carry << 1;

            int sum = a ^ b;
            b = carry << 1;
            a = sum;
        }

        return a;

    }
    public static void main(String[] args){
        SumOfTwoIntegers si = new SumOfTwoIntegers();
        si.getSum(3,1);
    }
}
