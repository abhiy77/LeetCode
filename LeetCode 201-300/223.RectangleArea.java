class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = 0;
        int a1 = (C - A) * (D - B);
        int a2 = (G - E) * (H - F);
    

        int hDiff = 0;
        if (A <= E && E<C) {
            hDiff = Math.min(C, G) - E;
        }else if (E<=A && A <G){
            hDiff = Math.min(C, G) - A;
        }
        
        int vDiff = 0;
        
        if(B<=F && F < D) {
            vDiff = Math.min(D, H) - F;
        }else if(F <= B && B <H) {
            vDiff = Math.min(D, H) - B;
        }
        
        res = a1 + a2 - hDiff * vDiff;
        return res;
    }
}
