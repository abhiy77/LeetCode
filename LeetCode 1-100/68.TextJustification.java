class Solution {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        int curr = 0;
        int index = 0;
        int i = 0;
        for(i=0;i<words.length;i++){
            String word = words[i];
            if(curr == 0){
                curr += word.length();
            }
            else if(curr + word.length()+1 <= maxWidth) {
                curr += word.length() + 1;
            }
            else{
           //     System.out.println(i + " " + curr);
                StringBuffer sb = new StringBuffer();
                int numWords = i - index;
                int curLen = curr;
                double empty = maxWidth - curr;
                double gaps = numWords - 1;
                curr = 0;
                for(int j = index;j<i;j++){
                    
                    if(j != i-1)sb.append(words[j] + " ");
                    else sb.append(words[j]);
                    if(gaps > 0){
                        double num = 0;
                        if(empty % gaps != 0){
                            num = Math.ceil(empty/gaps);
                        }
                        else num = empty/gaps;
                        for(int k=0;k<(int)num;k++) sb.append(" ");
                        empty -= num;
                        gaps--;
                    }
                    else if(gaps == 0){
                         while(empty > 0){
                             sb.append(" ");
                             empty--;
                         }
                    }
                    
                }
                index = i;
                result.add(sb.toString());
                i--;
            }
        }
                        
        if(curr > 0){
          //  System.out.println(i + " " + curr);
            StringBuffer sb = new StringBuffer();
                int numWords = i - index;
                int curLen = curr;
                double empty = maxWidth - curr;
                double gaps = numWords - 1;
                curr = 0;
                for(int j = index;j<i;j++){
                    if(j != i-1)sb.append(words[j] + " ");
                    else sb.append(words[j]);                 
                }
               while(empty > 0){
                     sb.append(" ");
                     empty--;
                }
                result.add(sb.toString());
        }
        return result;
    }
}
