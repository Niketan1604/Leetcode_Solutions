class Solution {
    void setZero(int[][] matrix, int row, int col){
        for(int i=0; i<matrix.length; i++) matrix[i][col] = 0;
        for(int i=0; i<matrix[0].length; i++) matrix[row][i] = 0;
    }
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0) list.add(Arrays.asList(i,j));
            }
        }

        for(List<Integer> l : list){
            setZero(matrix,l.get(0),l.get(1));
        }
    }
}