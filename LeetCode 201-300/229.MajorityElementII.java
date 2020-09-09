class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        int count1 = 0;
        int count2 = 0;
        
        Integer maj1 = null;
        Integer maj2 = null;
        
        for(int n : nums){
            if(maj1 != null && maj1 == n){
                count1++;
            }
            else if(maj2 != null && maj2 == n){
                count2++;
            }
            else if(count1 == 0){
                count1++;
                maj1 = n;
            }
            else if(count2 == 0){
                count2++;
                maj2 = n;
            }
            
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        
        for(int n : nums){
            if(maj1 != null && n == maj1) count1++;
            if(maj2 != null && n == maj2)count2++;
        }
        if(count1 > nums.length/3){
            result.add(maj1);
        }
        if(count2 > nums.length/3){
            result.add(maj2);
        }
        return result;
    }
}
