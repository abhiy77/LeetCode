class Solution {
    public int maxProduct(int[] arr) {
        if(arr.length == 0)return 0;
        if(arr.length ==1)return arr[0];
        int n = arr.length;
        int negOnes = 0;
        int maxnegOnes = 0;
        boolean canContinue = false;
        for(int i=0;i<n;i++){
            if(arr[i] == -1){
                negOnes +=1;
                maxnegOnes = Math.max(maxnegOnes,negOnes); 
            }
            else if(arr[i] == 0){
                negOnes = 0;
            }
            else{
                canContinue = true;
                break;
            }
        }

        if(!canContinue){
            if(maxnegOnes > 1)return 1;
            else return 0;
        }
        int max = 1;
        int curr_max = 1;
        int curr_min = 1;
       
        int flag = 0;
        
        for(int i=0;i<n;i++){
            if(arr[i] > 0){
                curr_max = curr_max * arr[i];
                curr_min = Math.min(curr_min * arr[i],1);
                flag = 1;
            }
            else if(arr[i] == 0){
                curr_max = 1;
                curr_min = 1;
            }
            else{
                int temp = curr_max;
                curr_max = Math.max(1,curr_min * arr[i]);
                curr_min = arr[i] * temp;
            }
            max = Math.max(max,curr_max);
        }
        return (flag == 0 && max == 1) ? 0 : max;
    }
}
