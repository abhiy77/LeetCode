class Solution {
    public int compareVersion(String version1, String version2) {
        String arr1[] = version1.split("\\.");
        String arr2[] = version2.split("\\.");
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length){
            int x = Integer.parseInt(arr1[i]);
            int y = Integer.parseInt(arr2[j]);
            if(x != y) {
                if(x < y) return -1;
                else return 1;
            }
            i++;j++;
        }
        if(i == arr1.length && j == arr2.length)return 0;
        if(i < arr1.length){
            while(i < arr1.length){
                if(Integer.parseInt(arr1[i++]) > 0)return 1;
            }
            return 0;
        }
        if(j < arr2.length){
            while(j < arr2.length){
                if(Integer.parseInt(arr2[j++]) > 0)return -1;
            }
            return 0;
        }
        return -1;
    }
}
