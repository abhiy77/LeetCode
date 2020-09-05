class Solution {
    public int[] sortedSquares(int[] A) {
        if(A.length == 0)return null;
        int n = A.length;
        int arr[] = new int[n];
        int i = 0, j = n-1;
        int index = n-1;
        
        while(i <= j){
            int elemA = A[i] * A[i];
            int elemB = A[j] * A[j];
            
            if(elemA > elemB){
                arr[index--] = elemA;
                i++;
            }
            else{
                arr[index--] = elemB;
                j--;
            }
        }
        return arr;
    }
}
