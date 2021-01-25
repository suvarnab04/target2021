package curatedlist.matrix;
/*
https://leetcode.com/problems/rotate-image/
https://www.youtube.com/watch?v=IdZlsG6P17w
 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        //transpose matrix
        for(int row = 0;row< matrix.length;row++){
            for(int col =row;col< matrix.length;col++){
                //swap matrix[i][j] with matrix[j][i]
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        //swap first col with last col while going towards the center of the matrix
        for(int row=0;row< matrix.length;row++){
            for(int col=0;col<matrix.length/2;col++){
                //swap first with last matrix[row][col] matrix[row][matrix.length-1-col]
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix.length-1-col];
                matrix[row][matrix.length-1-col] = temp;
            }
        }

    }
    public static void printMatrix(int[][] matrix){
        for(int row=0;row< matrix.length;row++){
            for(int col=0;col< matrix.length;col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}} ;
        RotateMatrix rm = new RotateMatrix();

        printMatrix(matrix);
        rm.rotate(matrix);
        System.out.println("rotated");
        printMatrix(matrix);

        int[][]matrix1 ={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}} ;
        printMatrix(matrix1);
        rm.rotate(matrix1);
        System.out.println("rotated");
        printMatrix(matrix1);

    }
}
