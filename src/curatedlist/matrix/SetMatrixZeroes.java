package curatedlist.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/set-matrix-zeroes/
https://www.youtube.com/watch?v=1KnLIAvTxjQ
 */
public class SetMatrixZeroes {

    //O(m+n)
    public void setZeroesBetter(int[][] matrix) {

        //rows
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];
        for(int row =0;row< rows;row++){
            for(int col=0;col<cols;col++){
                if(matrix[row][col] ==0){
                    zeroRows[row] = true;
                    zeroCols[col] = true;
                }
            }
        }
        for(int row=0;row< rows;row++){
            if(zeroRows[row]){
                for(int col=0;col< cols;col++){
                    matrix[row][col] = 0;
                }
            }
        }
        for(int col=0;col< cols;col++){
            if(zeroCols[col]){
                for(int row=0;row< rows;row++){
                    matrix[row][col] = 0;
                }
            }
        }

    }
    //O(1)
    public void setZeroesBest(int[][] matrix) {
        boolean zeroFirstRow= false;
        boolean zeroFirstCol = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int row =0 ;row < rows;row++){
            if(matrix[row][0] == 0){
                zeroFirstCol = true;
            }
        }
        for(int col =0 ;col < cols;col++){
            if(matrix[0][col] == 0){
                zeroFirstRow = true;
            }
        }
        for(int row=1;row< rows;row++){
            for(int col=1;col< cols;col++){
                if(matrix[row][col]==0){
                    matrix[0][col] =0;
                    matrix[row][0] =0;
                }
            }
        }
        for(int row =1;row< rows;row++){
            for(int col=1;col< cols;col++){
                if(matrix[row][0] ==0 || matrix[0][col]==0){
                    matrix[row][col]=0;
                }
            }
        }
        if(zeroFirstRow){
            for(int col=0;col<cols;col++){
                matrix[0][col]=0;
            }
        }
        if(zeroFirstCol){
            for(int row=0;row< rows;row++){
                matrix[row][0] = 0;
            }
        }


    }

}
