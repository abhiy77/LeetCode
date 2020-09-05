class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        
        Map<Character, Integer> unique = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int count = unique.getOrDefault(t.charAt(i), 0);
            unique.put(t.charAt(i), count + 1);
        }

        int required = unique.size();
        int l = 0, r = 0;
        int formed = 0;
        Map<Character,Integer> currDict = new HashMap<>();
        int ans[] = {-1,0,0};
        
        while(r < s.length()){
            char c = s.charAt(r);
            currDict.put(c,currDict.getOrDefault(c,0) + 1);
            
            if(unique.containsKey(c) && currDict.get(c).intValue() == unique.get(c).intValue()){
                formed++;
            }
            while(l <=r && formed == required){
                c = s.charAt(l);
                if(ans[0] == -1 || r - l + 1 < ans[0]){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                currDict.put(c,currDict.get(c) - 1);
                if(unique.containsKey(c) && currDict.get(c).intValue() < unique.get(c).intValue()){
                        formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1],ans[2] + 1);
    }
}
