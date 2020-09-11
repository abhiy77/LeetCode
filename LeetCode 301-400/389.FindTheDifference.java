class Solution {
    public char findTheDifference(String s, String t) {
        int arr[] = new int[26];
        for(int i=0;i<t.length();i++){
            if(i == s.length()) arr[t.charAt(i) - 'a']++;
            else{
                arr[t.charAt(i) - 'a']++;
                arr[s.charAt(i) - 'a']--;
            }
        }
        for(int i=0;i<26;i++){
            if(arr[i] > 0) return (char)(97 + i);
        }
        return '@';
    }
}
