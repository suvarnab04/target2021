package Recursion;

import java.util.Arrays;
import java.util.Locale;

public class IterativeClass {
    public static int countDigits(int num){
        int count =0;
        while(num > 0)
        {
            count++;
            num/=10;

        }
        return count;
    }
    public static int countDigitsRec(int num){
       if(num == 0) {
           return 0;
       }else {

           return 1 + countDigits(num / 10);
       }

    }
    public static int fibonacci(int n){

        if(n <= 1){
            return n;
        }
        return fibonacci(n-2) + fibonacci(n-1);
    }

    public static int gcd(int num1, int num2) {
        // Write your code here

        return gcdRec(num1, num2,Math.min(num1,num2));
    }
    public static int gcdRec(int num1, int num2, int divisor ){
        if(divisor <= 1){
            return -1;
        }
        if(num1 % divisor == 0 && num2 % divisor==0){
            return divisor;
        }else{
            return gcdRec(num1, num2,divisor-1);
        }
    }
    public static boolean isPrime(int num){
        return isPrime(num, num-1);
    }
    public static boolean isPrime(int num, int divisor){
        if(divisor==1){
            return true;
        }
        if(num % divisor == 0){
            return false;
        }else {
            return isPrime(num, divisor-1);
        }
    }
    public static int decimalToBinary(int n){
        return Integer.valueOf(decToBinRec(n));
    }
    public static String decToBinRec(int num){
        if(num == 1){
            return 1+"";
        }
        if(num/2 != 0){
            return decToBinRec(num/2) +""+num%2;
        }
        return "";
    }
    public static String alphabeticMerge(String str1, String str2){
        if(str1.isEmpty() ){
            return  str2;
        }else if(str2.isEmpty()){
            return str1;
        }

        if(str1.charAt(0) <= str2.charAt(0)){
            return str1.charAt(0) + alphabeticMerge(str1.substring(1), str2.substring(0));
        }else{
            return str2.charAt(0) + alphabeticMerge(str1.substring(0), str2.substring(1));
        }

    }
    public static int countVowels(String str){
        if(str== null || str.isEmpty() ){
            return 0;
        }

        if(str.toLowerCase().charAt(0)=='a' || str.toLowerCase().charAt(0)=='e' || str.toLowerCase().charAt(0)=='i'|| str.toLowerCase().charAt(0)=='o'|| str.toLowerCase().charAt(0)=='u')
            return 1+ countVowels(str.substring(1));
        else
            return countVowels(str.substring(1));

    }
    public static void  getAllPermutations(char[] arr, int length){

        for(int i=0;i< arr.length-1;i++) {
            //getAllPermutationsRec(str.charAt(i)+str.substring(0,i)+ str.substring(i+1), str.length()-1);
        }
    }
    public static void  getAllPermutations(String str){


        for(int i=0;i< str.length();i++) {
            getAllPermutationsRec(str.charAt(i)+str.substring(0,i)+ str.substring(i+1), str.length()-1);
        }
    }
    public static String getAllPermutationsRec(String str, int count){
        if(count == 0){
            return "";
        }
        else{
            System.out.println(str);
            return getAllPermutationsRec(str.substring(1) + str.charAt(0),count-1);
        }
    }
    public static boolean isPalindrom(String str){
        if(str.length() == 1){
            return true;
        }
        if(str.charAt(0) != str.charAt(str.length()-1)){
            return false;
        }else{
            return isPalindrom(str.substring(1,str.length()-1));
        }
    }

    public static void invertArray(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
       // if(start < nums.length/2) {

            //swap
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            invertArray(nums, start+1, end-1);
       // }
    }
    public static boolean checkArrayIsPalindrom(int[] nums){
        return checkPalindrome(nums, 0);
    }
    public static boolean checkPalindrome(int[] nums, int start){
        if(start>= nums.length/2){
                return true;
        }
        if(nums[start] != nums[nums.length-1-start]){
            return false;
        }else{
            return checkPalindrome(nums, start+1 );
        }
    }
    public static void sortArray(int[] arr, int keyIndex, int currIndex){
        if(keyIndex == arr.length-1){
            return;
        }
        if(currIndex < arr.length){

            if(arr[currIndex] < arr[keyIndex]){
            //swap
                int temp = arr[currIndex];
                arr[currIndex] = arr[keyIndex];
                arr[keyIndex] = temp;

            }
            sortArray(arr, keyIndex,currIndex+1);
        }else{
            sortArray(arr, keyIndex+1, keyIndex+1);
        }

    }
    public static void main(String[] args){
        int input = 1435043;
        int numDigits = countDigits(input);
        System.out.println("Number of digits in " + input + " = " + numDigits);
        System.out.println("Number of digits in " + input + " = " + countDigitsRec(input));

        int i = 0;
        while (i < 3) {
            System.out.print(fibonacci(i) + " ");
            i++;
        }

        int num1= 56;
        int num2 =42;
        System.out.println("gcd is:" +gcd(num1,num2));

        int numPrime = 4;
        System.out.println("is "+ numPrime +"\tPrime::"+ isPrime(numPrime));


        int numDec = 5;
        System.out.println(decimalToBinary(numDec));

        String one = "adz";
        String two = "bfx";
        String answer = alphabeticMerge(one, two);
        System.out.println(answer);

        System.out.println("Number of vowels::" + countVowels("he"));

        System.out.println("gettting all permutations");
        getAllPermutations("pqr");

        System.out.println("Is Palindrome::" + isPalindrom("suvarns"));


        System.out.println("Before: ");

        int[] array = {1,2,3,4,5,6,7};
       System.out.println("Array before inverting ::" +Arrays.toString(array));

        System.out.println("After: ");

        invertArray(array, 0,array.length-1);
        System.out.println("Array after inverting ::" +Arrays.toString(array));



        System.out.println("Before: ");

        int[] arraySort = {3,4,5,1,2,6,7};
        System.out.println("Array before sorting ::" +Arrays.toString(arraySort));

        System.out.println("After: ");

        sortArray(arraySort, 0,0);
        System.out.println("Array after sorting ::" +Arrays.toString(arraySort));

    }
}
