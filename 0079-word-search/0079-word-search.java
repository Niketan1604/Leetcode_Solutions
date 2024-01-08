class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int map[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0) && helper(word,board,i,j,0,map)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean helper(String word, char[][]board, int m, int n, int i, int[][] map){
        if(i == word.length()) return true;
        if(m<0 || n<0 || m==board.length || n==board[0].length) return false;
        if(board[m][n] == word.charAt(i) && map[m][n]==0){
            map[m][n] = 1;
            if(helper(word, board, m+1, n, i+1, map)) return true;
            else if(helper(word, board, m, n+1, i+1, map)) return true;
            else if(helper(word, board, m-1, n, i+1, map)) return true;
            else if(helper(word, board, m, n-1, i+1, map)) return true;

            map[m][n] = 0; //backtrack;
        }
        return false;
    }
}