class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int water = 0;
        int left = 0 ,right = n-1;
        
        while(left < right){
    water = Math.max(water,Math.min(height[left],height[right]) * (right-left));
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return water;  
    }
}
