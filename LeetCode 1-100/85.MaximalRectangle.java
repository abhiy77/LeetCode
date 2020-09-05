class Solution {
    
    int maxArea = 0;
    
    public int maximalRectangle(char[][] matrix) { 
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int temp[] = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '0') temp[j] = 0;
                else temp[j] += Integer.parseInt(Character.toString(matrix[i][j]));       
            }
            int area = rectInHist(temp);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
    
    public int rectInHist(int[] temp){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(;i<temp.length;){
            if(stack.isEmpty() || temp[i] >= temp[stack.peek()]){
                stack.push(i++);
            }
            else{
                int val = stack.pop();
                int area = temp[val] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                max = Math.max(area,max);
            }
        }
        while(!stack.isEmpty()){
                int val = stack.pop();
                int area = temp[val] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                max = Math.max(area,max);
        }
        return max;
    }
}
