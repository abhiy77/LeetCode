class Solution {
    public int romanToInt(String s) {
        
        Map<String,Integer> romanMap = new HashMap<String, Integer>() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
        
        put("IV", 4);
        put("IX", 9);
        put("XL", 40);
        put("XC", 90);
        put("CD", 400);
        put("CM", 900);
    }};
    
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                String twoChars = s.substring(i, i + 2);
                if (romanMap.containsKey(twoChars)) {
                    ans += romanMap.get(twoChars);
                    i++; 
                    continue;
                }
            }    
            ans += romanMap.get(Character.toString(s.charAt(i)));
        }    
        return ans;
    }
}
