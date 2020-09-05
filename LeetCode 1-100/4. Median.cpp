class Solution {
    
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int len1 = nums1.size();
        int len2 = nums2.size();
        if(len1<1){
            return findMid(nums2,len2);
        }
        if(len2<1){
            return findMid(nums1,len1);
        }
        
        int i=0,j=0;
        vector<int> result;
        while(i<len1 && j<len2){
            if(nums1[i] < nums2[j]){
                result.push_back(nums1[i++]);
            }
            else{
                result.push_back(nums2[j++]);
            }
        }
        while(i<len1){
            result.push_back(nums1[i++]);
        }
        while(j<len2){
            result.push_back(nums2[j++]);
        }
        
        return findMid(result,result.size());
    }
    
    double findMid(vector<int> v,int len ){
        if(len%2==0){
            return (v[len/2] + v[len/2 - 1])/2.0;
        }
        else {
            return v[len/2];
        }
    }
};
