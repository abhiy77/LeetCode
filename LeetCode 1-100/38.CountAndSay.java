class Solution {
    
    public String countAndSay(int n) {
    
    StringBuffer res = new StringBuffer("1");
    if(n == 1) return res.toString();
    
    for(int i=1;i<n;i++){
        StringBuffer temp = new StringBuffer(res);
        res.delete(0,res.length()); 
        int index = 0;
        while(index < temp.length()){
            int count = 1;
            while(index != temp.length() -1 && temp.charAt(index) == temp.charAt(index+1)){
                index++; count++;
            }
            res.append(count).append(temp.charAt(index));
            index++;
        }
    }
    return res.toString();
    }
}
