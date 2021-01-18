package matrixCalculations;

import java.util.Scanner;

public class MatrixCalculation {
    public static void main(String[] args){
       // int[][] matrix = getMatrix();
        //printMatrix(matrix);

        int[][] randomMatrix = getRandomMatrix();

        printMatrix(randomMatrix);

        sumAllElementsInMatrix(randomMatrix);
        sumForEachColumn(randomMatrix);
    }

    private static int[][] getMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of rows in matrix::");
        int rows =  input.nextInt();
        System.out.println("Enter number of columns in matrix::");
        int columns = input.nextInt();
        int[][] matrix = new int[rows][columns];
        for(int row = 0; row< matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.printf("\nEnter value at matrix[%d][%d] ::", row, col);
                matrix[row][col] = input.nextInt();
            }
        }
        return matrix;
    }
    private static int[][] getRandomMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of rows in matrix::");
        int rows =  input.nextInt();
        System.out.println("Enter number of columns in matrix::");
        int columns = input.nextInt();
        int[][] matrix = new int[rows][columns];
        for( int row = 0; row< matrix.length; row++ ){
            for( int col = 0; col < matrix[row].length; col++ ){

                matrix[row][col] = ( int ) (Math.random() * 100 );
            }
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col =0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }
    public static void sumAllElementsInMatrix(int[][] matrix){
        int total = 0;
        for(int row = 0; row < matrix.length; row++){
            for( int col = 0; col < matrix[row].length; col ++){
                total += matrix[row][col];
            }
        }
        System.out.println("Sum of all elements in the matrix is :" + total);
    }
    public static void sumForEachColumn(int[][] matrix){
        for( int col = 0; col < matrix[0].length; col++){
            int sum =0;
            for(int row = 0; row < matrix.length ;row ++){
                sum += matrix[row][col];
            }
            System.out.printf("sum of column %d is %d\n ", col, sum);
        }
    }
    public static void matrixAddition(int[][] firstMatrix, int[][] secondMatrix, int[][] sum){

    }
}
