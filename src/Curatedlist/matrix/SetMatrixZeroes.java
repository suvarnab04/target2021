package Curatedlist.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        //rows
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<List<Integer>> zeros = new ArrayList();

        for(int row = 0;row< rows; row++){

            for(int col =0;col< cols;col++){
                if(matrix[row][col] == 0){
                    List<Integer> rowCol = new LinkedList();
                    rowCol.add(row);
                    rowCol.add(col);
                    zeros.add(rowCol);
                }
            }

        }
        for(List<Integer> list : zeros){
            int zrow = list.get(0);
            int zcol = list.get(1);

            for(int i=0;i<cols;i++){
                matrix[zrow][i] =0;
            }
            for(int i=0;i<rows;i++){
                matrix[i][zcol] =0;
            }
        }

    }

}
