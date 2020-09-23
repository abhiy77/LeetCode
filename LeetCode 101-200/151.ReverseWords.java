class Solution {
    public String reverseWords(String s) {
        if(s.equals(""))return "";
        String str[] = s.split(" ");
        if(str.length == 0)return "";

        StringBuffer sb = new StringBuffer();
        for(int i=str.length-1;i>=0;i--){
            String temp = str[i].trim();
            if(!temp.equals(""))sb.append(temp + " ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
