class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
        if (k == 0) return new int[0];
        int maxNum1[] = new int[k];
        int maxNum2[] = new int[k];
        
        int res[] = new int[k];
        
        for(int i=0;i<=Math.min(nums1.length,k);i++){
            
            if(i + nums2.length < k)continue; 
            findMax(maxNum1,i,nums1);
            findMax(maxNum2,k-i,nums2);
            
            res = merge(maxNum1,maxNum2,i,k-i,res);
        }
        return res;
    }
    
    private static void findMax(int maxNum[],int size,int[] nums){
        
        if(size == 0)return;
        for(int i=0,j=0;i<nums.length;i++){
            while(j > 0 && nums.length - i > size - j && nums[i] > maxNum[j-1])
                j--;
            
            if(j < size) maxNum[j++] = nums[i];
        }
        
    }
    
    private static int[] merge(int[] maxNum1,int[] maxNum2,int size1,int size2,int[] res){
        
        int k = res.length;
        int combined[] = new int[k];
        int idx = 0;
        int i = 0, j = 0;
        int flag = 1;
        
        
        while(i < size1 || j < size2){
            if(i >= size1) combined[idx] = maxNum2[j++];
            else if(j >= size2) combined[idx] = maxNum1[i++];
            else{
                int ii = i ,jj = j;
                
                while(ii < size1 && jj < size2 && maxNum1[ii] == maxNum2[jj]){
                    ii++;
                    jj++;
                }
                if(ii <size1 && jj < size2){
                    if(maxNum1[ii] > maxNum2[jj]) combined[idx] = maxNum1[i++];
                    else combined[idx] = maxNum2[j++];
                }
                else if(ii == size1) combined[idx] = maxNum2[j++];
                else combined[idx] = maxNum1[i++];
            }
            
            if(combined[idx] > res[idx]) flag = 0;
            else if(flag == 1 && res[idx] > combined[idx]){
                break;
            }
            idx++;
        }
        
        if(flag == 0) return combined;
        if(flag == 1 && combined[k-1] > res[k-1]) return combined;
        return res;
    }
}
