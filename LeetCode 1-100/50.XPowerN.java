class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 1) return 1;
        else if(x == -1) return (n%2 ==0 ? 1 : -1);
        else if(n == Integer.MIN_VALUE) return 0;
        else if(n > 0){
            double d = x;
            for(int i=1;i<n;i++){
                x *= d;
            }
            return x;
        }
        else{
            DecimalFormat df = new DecimalFormat("0.00000");
            n = Math.abs(n);
            double d = 1/x,d1=1/x;
            for(int i=1;i<n;i++){
                d1 = d1*d;
                System.out.println(d);
            }
            return d1;
        }
    }
}
