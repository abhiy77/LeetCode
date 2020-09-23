class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if(k == 0) return;
        reverseArray(nums,0,nums.length-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,nums.length-1);
    }
    
    public void reverseArray(int[] arr,int i,int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
}
