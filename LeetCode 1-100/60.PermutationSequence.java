class Solution {
    
    String result = "";
    List<String> list = new LinkedList<>();
    int pos = 0;
    public String getPermutation(int n, int k) {
         long fact = factorial(n-1);
         long num = k / fact;
         long a = k % fact;
         recurse(""+(a != 0 ?num+1 : num),(a != 0 ? a : fact),n);
        return result;
    }
    
    public long factorial(int n){
        if(n == 0 || n == 1 ) return 1;
        else return n * factorial(n-1);
    }
    
    public void recurse(String str,long a,int n){
        if(!result.isEmpty()) return;
        if(str.length() ==  n){
            pos++;
            if(pos == a){
                result = str;
                return;
            }
        }
        for(int i=1;i<=n;i++){
            if(!str.contains(i+"")){
                recurse(str+i,a,n);
            }
        }
    }
}
