package curatedlist.matrix;

import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/spiral-matrix/
https://www.youtube.com/watch?v=BdQ2AkaTgOA
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList();
        if(matrix==null || matrix.length==0){
            return list;
        }
        int top=0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        int size = matrix.length *  matrix[0].length;

        while(list.size() < size){
            //top row
            for(int i=left;i<=right && list.size()< size;i++){
                list.add(matrix[top][i]);
            }
            top++;
            //right column
            for(int i=top;i<=bottom && list.size()< size;i++){
                list.add(matrix[i][right]);
            }
            right--;
            for(int i=right;i>=left  && list.size()< size;i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i= bottom;i>=top  && list.size()< size ;i--){
                list.add(matrix[i][left]);
            }
            left++;

        }

        return list;
    }
}
