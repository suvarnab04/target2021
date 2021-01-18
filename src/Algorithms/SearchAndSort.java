package Algorithms;

import java.lang.*;
public class SearchAndSort {
    public static void main(String[] args){
        int[] numbers ={1,7,8,3,9};
        int key = 9;

        int index = linearSearch(numbers,key);
        if(index == -1 )
            System.out.println("key not found in the array") ;
        else
            System.out.printf("number %d found at index %d \n\n",key, index );

        //selection sort
        System.out.println("\n*****SELECTION SORT*****");
        System.out.print("array before sorting::\t"  );
        printArray(numbers);
        selectionSort(numbers);
        System.out.print("array after sorting::\t"  );
        printArray(numbers);

        //binary search
        index = binarySearch(numbers,key);
        if(index == -1 )
            System.out.println("key not found in the array") ;
        else
            System.out.printf("number %d found at index %d \n\n",key, index );

        System.out.println("\n\n******INSERTION SORT*******");
        int [] arrayForInsertionSort = {4,3,2,1};
        System.out.print("array before sorting:\t");
        printArray(arrayForInsertionSort);
        insertionSort( arrayForInsertionSort);
        System.out.print("array after sorting::\t");
        printArray(arrayForInsertionSort);


        System.out.println("\n\n******BUBBLE SORT*******");
        int [] arrayForBubbleSort = {4,3,2,1};
        System.out.print("array before sorting::\t");
        printArray(arrayForBubbleSort);
        bubbleSort( arrayForBubbleSort);
        System.out.print("array after sorting::\t");
        printArray(arrayForBubbleSort);
    }
    public static void printArray(int[] numbers){
        for(int i : numbers){
            System.out.print(i+ "\t");
        }
        System.out.println();
    }
    public static int linearSearch(int[] numbers, int key){
        System.out.println("\n*****LINEAR SEARCH*****");
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int [] numbers, int key){
        System.out.println("\n*****BINARY SEARCH*****");
        System.out.print("\narray to be searched::\t");
        printArray(numbers);
        System.out.printf("key to search %d::\t", key);
        int lowIndex = 0;
        int highIndex = numbers.length - 1;
        while(highIndex >= lowIndex){
            int midIndex = (highIndex + lowIndex ) / 2;
            if( numbers[midIndex] == key ){
                return midIndex ;
            }
            if( numbers[midIndex] > key ){
                highIndex = midIndex - 1;
            }else{
                lowIndex = midIndex + 1;
            }
        }

        return -1;
    }
    public static void selectionSort(int[] numbers){

        //validations
        //

        for(int i = 0; i < numbers.length; i++){

             for(int j = i+1; j< numbers.length ;j ++){
                if(numbers[j] < numbers[i]){
                    int minNumber = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = minNumber;
                }
            }
        }

    }
    public static void insertionSort(int[] numbers){


        for (int i =0; i <  numbers.length; i++){
            int j = i -1;
            int key = numbers[i];

            while( j >= 0 && numbers[j] > key ) {
                //shift the numbers
                numbers[j+1] = numbers[j];
                j--;
            }
            numbers[j+1] = key;

        }

    }
    //ascending order
    public static void bubbleSort(int[] numbers){

         for(int i = 0; i< numbers.length; i++){
            for(int j = 1; j < numbers.length - i; j++ ){
                if(numbers[j] < numbers[j-1]){
                    //swap
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                }
            }
        }
    }
}
