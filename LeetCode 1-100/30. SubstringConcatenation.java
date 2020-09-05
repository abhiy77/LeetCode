class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (words.length == 0 || words.length > s.length()) return res;
        int len = words[0].length();
        for (int i = 0; i <= s.length() - (words.length * len); i++) {
            int j = i;
            ArrayList<String> helper = new ArrayList<String>(Arrays.asList(words));
            while (j + len <= s.length() && helper.contains(s.substring(j, j+len))) {
                helper.remove(s.substring(j, j+len));
                j += len;
            }
            if (helper.size() == 0) res.add(i);
        }
        return res;
    }
}
