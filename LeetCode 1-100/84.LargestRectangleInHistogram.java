class Solution {
    public int largestRectangleArea(int[] arr) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < arr.length){
            if(stack.isEmpty() || arr[i] >= arr[stack.peek()]){
                stack.push(i++);
            }
            else{
                int num = stack.pop();
                int area = arr[num] * (stack.isEmpty() ? i : i-stack.peek() -1);
                maxArea = Math.max(area,maxArea);
            }
        }
        
        while(!stack.isEmpty()){
                int num = stack.pop();
                int area = arr[num] * (stack.isEmpty() ? i : i-stack.peek() -1);
                maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
