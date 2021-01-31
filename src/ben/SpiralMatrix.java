package ben;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int top=0;
        int bottom = matrix.length-1;
        int left =0;
        int right = matrix[0].length-1;

        int size = matrix.length * matrix[0].length;

        while(list.size()<size){

            for(int col =top; col <= right && list.size()< size ;col++){
                list.add(matrix[top][col]);
                System.out.print(matrix[top][col] + ",");
            }
            top++;

            for(int row = top; row <= bottom && list.size()< size;row++){
                list.add(matrix[row][right]);
                System.out.print(matrix[row][right] + ",");
            }
            right--;

            for(int col = right; col>=left && list.size()< size;col--){
                list.add(matrix[bottom][col]);
                System.out.print(matrix[bottom][col] + ",");
            }
            bottom--;

            for(int row = bottom;row >=top && list.size()< size;row--){
                list.add(matrix[row][left]);
                System.out.print(matrix[row][left] + ",");
            }
            left++;

        }
        return list;
    }
    public static void main(String[] args){
        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> result = sm.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for(int i : result){
        //    System.out.print(i + ",");
        }
        System.out.println();
      sm.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8}});


    }
}
