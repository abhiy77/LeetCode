class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = (matrix.length > 0 ? matrix.length : 0);
        int n = (matrix.length > 0 ? matrix[0].length : 0);
        int row = 0,col = 0;
        while(row < m){
            if(matrix[row].length <= 0) row++;
            else if(matrix[row][col] == target || matrix[row][n-1] == target) return true;
            else if(matrix[row][n-1] < target){
                row++;
                continue;
            }
            else{
                return binarySearch(0,n-1,matrix[row],target);   
            }
        }
        return false;
    }
    
    public boolean binarySearch(int low,int high,int[] row,int target){
        while(low < high){
            int mid = (low+high)/2;
            if(row[mid] == target) return true;
            else if(row[mid] > target) high = mid;
            else low = mid+1;
        }
        return false;
    }
}
