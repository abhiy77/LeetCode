class Solution {
    
    public boolean isHappy(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(n);
        int num = n;
        while(num != 1){
            String str = num + "";
            num = 0;
            int temp = 0;
            for(int i=0;i<str.length();i++){
                temp = Integer.parseInt(str.charAt(i) + "");
                num += (temp*temp);
            }
            if(list.contains(num)) break;
            list.add(num);
        }
        if(num == 1) return true;
        else return false;
    }
}
