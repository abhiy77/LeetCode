 
class Solution{
    public boolean isUgly(int num) {
        if (num == 0) return false;
        int temp = num;
        while (temp > 0) {
            if (temp == 1) return true;
            if (temp % 2 == 0) temp /= 2;
            else if (temp % 3 == 0) temp /= 3;
            else if (temp % 5 == 0) temp /= 5;
            else return false;
        }
        return false;
    }
}
