class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s;
        
        int num_lines = Math.min(s.length(),numRows);
        ArrayList<StringBuilder> arr = new ArrayList<>();
        for(int i=0;i<num_lines;i++){
           arr.add(new StringBuilder());
        }
       
        int i = 0;
        boolean down = false;
        StringBuilder output = new StringBuilder();
       
        for(char c : s.toCharArray()){
            arr.get(i).append(c);
            if(i == 0 || i== num_lines-1) {down = !down;}
            i += down ? 1 : -1;
        }
        
        for(StringBuilder sb : arr) {
            output.append(sb);
        }
        return output.toString();
    }
}
