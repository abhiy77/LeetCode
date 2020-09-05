class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        int n = S.length();
        int m = J.length();
        HashMap<Character,Integer> jewels = new HashMap<>();
        for(int i=0;i<m;i++){
            char c = J.charAt(i);
            jewels.put(c,jewels.getOrDefault(c,0) + 1);
        }
        for(int i=0;i<n;i++){
            char c = S.charAt(i);
            if(jewels.containsKey(c))count++;
        }
        return count;
    }
}
