class Solution {
    public int nextGreaterElement(int n) {
        char num[] = Integer.toString(n).toCharArray();
        int len = num.length;
        if(len == 1) return -1;
        boolean flag = false;
        for(int i=0;i<len-1;i++){
            if(num[i] < num[i+1]){
                flag = true;
                break;
            }
        }
        if(flag == false)return -1;
        int i = len - 1;
        while(i > 0 && num[i] <= num[i-1]){
            i--;
        }
        int min = num[i];
        int min_index = i;
        for(int j=i+1;j<len;j++){
            if(num[j] < min && num[j] > num[i-1]){
                min = num[j];
                min_index = j;
            }
        }
        char temp = num[min_index];
        num[min_index] = num[i-1];
        num[i-1] = temp;
        Arrays.sort(num,i,len);
        StringBuffer sb = new StringBuffer();
        for(int j=0;j<len;j++){
            sb.append(num[j]);
        }

        Long l =  Long.parseLong(sb.toString());
        long max = Integer.MAX_VALUE;
        return (l > max ? -1 : Integer.parseInt(sb.toString()));
    }
}
