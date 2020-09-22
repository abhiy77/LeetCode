class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> list) {
        int min = Integer.MAX_VALUE;
        boolean visited[] = new boolean[list.size()];
        if(!list.contains(endWord)) return 0;
        if(list.contains(beginWord)) visited[list.indexOf(beginWord)] = true;
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(beginWord,1));
        while(!queue.isEmpty()){
            Item item = queue.poll();
            //System.out.println(item.s + " " + item.val);
            if(item.s.equals(endWord)){
                min = Math.min(min,item.val);
                break;
            }
            for(int i=0;i<list.size();i++){
                if(!visited[i] && howClose(list.get(i),item.s) == 1){
                    visited[i] = true;
                    queue.add(new Item(list.get(i),item.val + 1));
                }
            }
        }
        if(min == Integer.MAX_VALUE) return 0;
        else return min;
    }
    
    public int howClose(String a,String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i))count++;
            if(count >=2) break;
        }
        if(count <= 1) return 1;
        else return -1;
    }
}

class Item{
    String s;
    int val;
    Item(String s,int val){
        this.s = s;
        this.val = val;
    }
}
