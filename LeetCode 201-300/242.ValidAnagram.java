class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() == 0 && t.length() == 0)return true;
        if(s.length() != t.length())return false;
        int arr[] = new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(arr[i] > 0)count++;
        }
        return count == 0;
    }
}
