class Solution {
    void helper(int[][] new_b, char[][] board, int i,int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(board[i][j] == 'X' || new_b[i][j] == 1) return;
        new_b[i][j] = 1;
        helper(new_b,board,i-1,j);
        helper(new_b,board,i+1,j);
        helper(new_b,board,i,j+1);
        helper(new_b,board,i,j-1);
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int new_b[][] = new int[n][m];
        for(int i=0; i<n; i++){
            if(board[i][0] == 'O') helper(new_b, board, i, 0);
            if(board[i][m-1] == 'O') helper(new_b, board, i, m-1);
        }
        for(int i=0; i<m; i++){
            if(board[0][i] == 'O') helper(new_b, board, 0, i);
            if(board[n-1][i] == 'O') helper(new_b, board, n-1, i);
        }

        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(new_b[i][j] == 0){
                    board[i][j] = 'X';
                } 
                else board[i][j] = 'O';
            }
        }
    }
}