class Solution {
    public String simplifyPath(String path) {
        String directories[] = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String dir : directories){
            if(dir.isEmpty() || dir.equals(".")){
                continue;
            }
            else if(!dir.equals("..")){
                stack.push(dir);
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        if(stack.isEmpty())
                return "/";
        
        StringBuffer ans = new StringBuffer();
        for(String item : stack){
            ans.append("/"+item);
        }
        return ans.toString();
    }
}
