package curatedlist.graph;
/*
https://leetcode.com/problems/number-of-islands/
https://www.youtube.com/watch?v=o8S2bO3pmO4
dfs explained well: https://www.youtube.com/watch?v=LVlihRYfVVw
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        int numIslands = 0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid[i].length;j++){
                numIslands += dfs(i,j, grid);
            }
        }
        return numIslands;
    }
    public int dfs(int i, int j, char[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>= grid[i].length || grid[i][j]=='0'){
            return 0;
        }
        if(grid[i][j]== '1'){
            grid[i][j] = '0';
            dfs(i+1,j, grid);
            dfs(i-1,j, grid);
            dfs(i,j+1, grid);
            dfs(i,j-1, grid);
        }
        return 1;
    }
}
