class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)return false;
        for(int i=0;i<matrix.length;i++){
            if(target >= matrix[i][0] && target <= matrix[i][matrix[0].length-1]){
                for(int j = 0;j<matrix[0].length;j++){
                    if(matrix[i][j] == target) return true;
                }
            }
        }
        return false;
    }
}
