class Solution {
    public int nthUglyNumber(int n) {
        if(n == 0  || n == 1)return n;
        int i = 0 , j = 0 , k = 0;
        List<Integer> list = new LinkedList<>();
        list.add(1);
        n--;
        while(n > 0){
            int x = Math.min(2 * list.get(i),Math.min(3 *list.get(j),5 * list.get(k)));
            if(2 * list.get(i) == x)i++;
            if(3 * list.get(j) == x)j++;
            if(5 * list.get(k) == x)k++;
            if(!list.contains(x)){
                 list.add(x);
                 n--;
             }
        }
        return list.get(list.size()-1);
    }
}
