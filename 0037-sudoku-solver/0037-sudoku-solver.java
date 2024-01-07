class Solution {
    public boolean solveSudoku(char[][] board) {
        return helper(board);
    }

    boolean helper(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    for(char c='1'; c<='9'; c++){
                        if(isValid(i,j,board,c)){
                            board[i][j] = c;
                            if(helper(board)) return true;
                            else board[i][j] = '.'; // backtrack if solution is not found
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(int row, int col, char[][]board, char c){
        for(int i=0; i<9; i++){
            //checking all the rows
            if(c == board[i][col]) return false;

            //checking all the columns
            if(c == board[row][i]) return false;

            //checking the 3x3 matrix
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }

        return true;
    }
}