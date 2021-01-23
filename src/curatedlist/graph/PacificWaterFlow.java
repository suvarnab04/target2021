package curatedlist.graph;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/pacific-atlantic-water-flow/
must watch- https://www.youtube.com/watch?v=LVlihRYfVVw
 */
public class PacificWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> results = new ArrayList();
        int[][] pacific = new int[matrix.length][matrix[0].length];
        int[][] atlantic = new int[matrix.length][matrix[0].length];

        //pacific top and bottom
        for(int col =0;col< matrix[0].length;col++ ){
            dfs(0,col, Integer.MIN_VALUE, matrix, atlantic);
            dfs(matrix.length-1,col, Integer.MIN_VALUE, matrix, pacific);
        }

        //atlantic
        //left and right
        for(int row =0;row< matrix.length;row++ ){
            dfs(row, 0, Integer.MIN_VALUE, matrix, atlantic);
            dfs(row, matrix[row].length-1, Integer.MIN_VALUE, matrix, pacific);
        }

        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[i].length;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(j);
                    results.add(list);
                }
            }
        }

        return results;
    }
    public void dfs(int i,int j, int prev,int[][] matrix, int[][] ocean ){
        if(i<0 || j<0|| i>matrix.length-1 || j>matrix[0].length-1){
            return ;
        }
        if(prev > matrix[i][j]){
            return ;
        }if(ocean[i][j] ==1){
            return;
        }
        ocean[i][j] =1;

        dfs(i-1,j, matrix[i][j], matrix,ocean);
        dfs(i+1,j, matrix[i][j], matrix, ocean);
        dfs(i,j-1, matrix[i][j], matrix, ocean);
        dfs(i,j+1, matrix[i][j], matrix, ocean);
    }
}
