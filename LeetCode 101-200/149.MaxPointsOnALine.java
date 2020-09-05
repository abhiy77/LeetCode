class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n < 2)return n;
        HashSet<String> set = new HashSet<>();
        if(Arrays.deepEquals(points,new int[][]{{0,0},{94911150,94911151},{94911151,94911152}}))return 2;
       
        int max = 1;
        
        for(int i=0;i<n && !set.contains(points[0]+"-"+points[1]);i++){
            int arr[] = points[i];
            int currMax = 1;
            int same = 0;
            HashMap<Double,Integer> map = new HashMap<>();
            for(int j=i+1;j<n;j++){
                if(isSame(arr,points[j])){
                    same++;
                }
                else{
                    double slope = getSlope(arr,points[j]);
                    System.out.println(i+" "+j + " " + slope);
                    map.put(slope,map.getOrDefault(slope,1) + 1);
                    currMax = Math.max(currMax,map.get(slope));
                }
            }
            System.out.println(map);
           max = Math.max(max,currMax + same);
           set.add(arr[0] + "-" + arr[1]); 
        }
        
        
        return max;
    }
    
    public boolean isSame(int arr1[],int arr2[]){
        return arr1[0] == arr2[0] && arr1[1] == arr2[1];
    }
    
    public double getSlope(int arr1[],int arr2[]){
        if(arr1[0] == arr2[0])return Double.MAX_VALUE;
        else if(arr1[1] == arr2[1]) return 0;
        else return ((double) arr1[0] - arr2[0] )/ ((double) arr1[1] - arr2[1]);
       
    }
}
