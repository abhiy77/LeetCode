class Solution {
    
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0)return new ArrayList<>();
    
        int n = nums.length;
        List<Integer> counter = new ArrayList<>();
        List<Item> itemList = new ArrayList<>(); 
        
        for(int i=0;i<n;i++){
            counter.add(0);
            itemList.add(new Item(nums[i],i));
        }
        Item[] temp = new Item[n];
        
        mergeSort(itemList,counter,0,n-1,temp); 
        return counter;
    }
    
    public void mergeSort(List<Item> itemList,List<Integer> counter,int low,int high,Item[] temp){
        if(low < high){
            
            int mid = low + ((high-low)>>1);
            mergeSort(itemList,counter,low,mid,temp);
            mergeSort(itemList,counter,mid+1,high,temp);
            merge(itemList,counter,low,mid,high,temp);
        }
    }
    
    public void merge(List<Item> itemList,List<Integer> counter,int low,int mid,int high,Item[] temp){
        int i = low , k = low , j = mid+1;
        
        while(i <= mid || j <= high){
            if(i > mid){
                temp[k++] = itemList.get(j++);
            }
            else if(j > high){
                temp[k++] = itemList.get(i++);
            }
            else if(itemList.get(i).val <= itemList.get(j).val){
                temp[k++] = itemList.get(j++);
            }
            else{
                counter.set(itemList.get(i).index,counter.get(itemList.get(i).index) + high - j + 1);
                temp[k++] = itemList.get(i++);
            }
        }
        for(int q=low;q<=high;q++) itemList.set(q,temp[q]);
    }
}

class Item{
    int val,index;
    
    Item(int val,int index){
        this.val = val;
        this.index = index;
    }
}
