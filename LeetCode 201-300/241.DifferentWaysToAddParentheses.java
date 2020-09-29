class Solution {
    public List <Integer> diffWaysToCompute (String S) {
        List <Integer> list = new ArrayList ();
        if (S.length () == 0)
            return list;
        if (allNumbers (S)) {
            list.add (Integer.valueOf (S));
            return list;
        }            
        for (int i = 0; i < S.length (); i++) {
            char ch = S.charAt (i);
            if (!(ch >= '0' && ch <= '9')) {
                List <Integer> front = diffWaysToCompute (S.substring (0, i));
                List <Integer> back = diffWaysToCompute (S.substring (i+1));
                for (int j = 0; j < front.size (); j++) {
                    int f = front.get (j);
                    for (int k = 0; k < back.size (); k++) {
                        int b = back.get (k);
                        switch (ch) {
                            case '+' :
                                list.add (f + b);
                                break;
                            case '-' :
                                list.add (f - b);
                                break;
                            case '*' :
                                list.add (f * b);
                                break;
                        }
                    }
                }
            }
        }
        return list;
    }
    
    public boolean allNumbers (String S) {
        char ch [] = S.toCharArray ();
        for (char c : ch) {
            if (!(c >= '0' && c <= '9'))
                return false;
        }
        return true;
    }
}
