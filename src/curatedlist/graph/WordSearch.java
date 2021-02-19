package curatedlist.graph;
/*
https://leetcode.com/problems/word-search/
https://www.youtube.com/watch?v=vYYNp0Jrdv0&t=446s
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int row=0;row< board.length;row++){
            for(int col=0;col< board[0].length;col++){
                if(board[row][col] == word.charAt(0) && findWord(board, row, col, word, 0)){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean findWord(char[][] board, int row, int col, String word, int wordIndex){

        if(wordIndex == word.length()){
            return true;
        }
        if(row<0 || col <0 || row>= board.length || col>= board[0].length || board[row][col] != word.charAt(wordIndex)){
            return false;
        }
        char temp = board[row][col];
        board[row][col] =' ';
        boolean found = findWord(board, row, col+1, word, wordIndex+1 )
                || findWord(board, row, col-1, word, wordIndex+1)
                || findWord(board, row+1, col, word, wordIndex+1)
                ||  findWord(board, row-1, col, word, wordIndex+1);

        board[row][col] = temp;
        return found;

    }
}
