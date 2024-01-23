class Solution {
    void helper(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if(grid[row][col] == '0') return;
        grid[row][col] = '0';

        helper(grid,row+1,col);
        helper(grid,row-1,col);
        helper(grid,row,col-1);
        helper(grid,row,col+1);
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    helper(grid,i,j);
                }
            }
        }
        return count;
    }
}