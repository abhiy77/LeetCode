class Solution {
    
    public List<String> commonChars(String[] A) {
        int count[] = new int[26];

        List<String> result = new ArrayList<>();
        String str = A[0];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i) - 'a']++;
        }
        if(A.length == 1){
            for(int i=0;i<A[0].length();i++){
                result.add((str.charAt(i) - 'a') + "");
            }
            return result;
        }
        for(int i=1;i<A.length;i++){
            str = A[i];
            int count2[] = new int[26];
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                count2[c-'a']++;
            }
            for(int j=0;j<26;j++){
                if(count2[j] > 0 && count[j] > 0)count[j] = Math.min(count[j],count2[j]);
                else if(count2[j] == 0 || count[j] == 0)count[j] = 0;
            }

        }
        for(int i=0;i<26;i++){
            while(count[i] != 0){
                result.add((char)(i + 'a') + "");
                count[i]--;
            }
        }
        return result;
    }
}
