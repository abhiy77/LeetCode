class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for(String email : emails){
            int idx = email.indexOf('@');
            String local = email.substring(0,idx);
            String domain = email.substring(idx);
            if(local.contains("+")){
                local = email.substring(0,email.indexOf('+'));
            }
            local = local.replaceAll("\\.","");
            
            emailSet.add(local+domain);
        }
        return emailSet.size();
    }
}
