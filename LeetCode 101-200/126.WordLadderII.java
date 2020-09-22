class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || !wordList.contains(endWord)) return Arrays.asList();
        
        List<List<String>> visitedlist = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        
        visitedlist.add(list);
        Queue<String> dict = new LinkedList<>(wordList);
        
        while(dict.contains(endWord) ){
            int vlen = visitedlist.size();
            Iterator<String> itr = dict.iterator(); 
            while(itr.hasNext()){
                String target = itr.next();
                boolean found = false;
                
                for(int i=0; i<vlen; i++){
                    List<String> clist = visitedlist.get(i);
                    
                    if(diff(last(clist), target) == 1){
                        found = true;
                        List<String> newlist = new ArrayList<>(clist);
                        newlist.add(target);
                        visitedlist.add(newlist);
                    }
                }
                if(found) {
                	itr.remove();
                }
                System.out.println(visitedlist);
            }

            if(vlen == visitedlist.size()) {
            	break;
            }

            for(int i=0; i<vlen; i++) {
            	visitedlist.remove(0);
            }
        }
		
        Iterator<List<String>> itr = visitedlist.iterator();
        
        while(itr.hasNext()){
            List<String> ilist = itr.next();
            
            if(!ilist.contains(endWord)){
                itr.remove();
            }
        }
        
        if(!visitedlist.isEmpty()){
            return visitedlist;
        }else{
            return Arrays.asList();
        }
        
    }
    
    private String last(List<String> list){
        return list.get(list.size()-1);
    }
    
    private int diff(String w1, String w2){
        int count = 0;
        for(int i=0; i<w1.length(); i++){
            if(w1.charAt(i) != w2.charAt(i)){
                count++;
            }
        }    
        return count;
    }
    
}
