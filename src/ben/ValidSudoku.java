package ben;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean validSudoku(int[][] board){
        Set<String> seen = new HashSet();

        for(int row =0;row< board.length;row++){
            for(int col =0;col< board.length;col++){
                if(board[row][col]!=0){
                    if(!seen.add(board[row][col] +"found in row-" + row ) ||
                            !seen.add(board[row][col] +"found in col-" + col )||
                            !seen.add(board[row][col] +"found in box-" + row/3 + "-" + col/3 )){
                        return false;

                    }

                }
            }
        }
        return true;
    }

    public static void main(String[] args){

    }
}
