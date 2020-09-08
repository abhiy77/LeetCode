class Solution {
    public boolean hasAllCodes(String s, int k) {

        HashSet<String> hash = new HashSet<String>();

        StringBuilder sb = new StringBuilder();

        if(s.length() < k){
            return false;
        }

        for (int i=0; i<k; i++){
            sb.append(s.charAt(i));
        }
        hash.add(sb.toString());


        for (int i=k; i<s.length(); i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            hash.add(sb.toString());
        }

        return hash.size()==Math.pow(2,k);
    }
}
