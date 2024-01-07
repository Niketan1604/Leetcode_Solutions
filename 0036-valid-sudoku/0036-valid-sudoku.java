class Solution {
    public boolean isValidSudoku(char[][] board) {
        return helper(0,0,board);
    }

    boolean helper(int curr_row, int curr_col,char[][] board){
        if(curr_col == 9){
            curr_row++;
            curr_col = 0;
        }
        if(curr_row == 9){
            return true;
        } 

        if(board[curr_row][curr_col] != '.'){
            char c = board[curr_row][curr_col];
            board[curr_row][curr_col] = '.';
            if(!isValid(curr_row,curr_col,board,c)){
                return false;
            }
            board[curr_row][curr_col] = c;
        }
        return helper(curr_row,curr_col+1,board);
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