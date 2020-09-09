class Solution {
    
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() < 10) return list;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        int i = 0;
        StringBuffer sb = new StringBuffer();
        for(i=0;i<10;i++){
            sb.append(s.charAt(i));
        }
        map.put(sb.toString(),1);
        
        while(i < s.length()){
            sb.delete(0,1);
            sb.append(s.charAt(i++));
            String temp = sb.toString();
            map.put(temp,map.getOrDefault(temp,0) + 1);
        }
        
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
