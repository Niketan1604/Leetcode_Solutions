class Solution {
    boolean binarySearch(int[] row, int left, int right,int target){
        if(right < left) return false;
        int mid = left + (right-left)/2;

        if(row[mid] == target) return true;
        else if(row[mid] > target) return binarySearch(row, left, mid-1, target);
        else return binarySearch(row, mid+1, right, target);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length-1;
        for(int[] row : matrix){
            if(row[n] >= target) return binarySearch(row,0,n,target);
        }
        return false;
    }
}