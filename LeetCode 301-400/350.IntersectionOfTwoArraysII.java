class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0) + 1);
        }
        for(int i=0;i<nums2.length;i++){
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
        }
        int index = 0;
        for(Map.Entry<Integer,Integer> entry : map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                for(int i=0;i<Math.min(entry.getValue() ,map2.get(entry.getKey()));i++){
                    nums1[index++] = entry.getKey();
                }
            }
        }
        System.out.println(map1); System.out.println(map2); System.out.println(Arrays.toString(nums1));
        return Arrays.copyOfRange(nums1,0,index);
    }
}
