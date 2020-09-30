/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        long i = 1,j = n,bad = 1;
        while(i <= j){
            long mid = (i+j)/2;

            if(isBadVersion((int)mid)){
                if(!isBadVersion((int) mid-1)) return (int) mid;
                j = mid-1;
            }
            else {
                if(isBadVersion((int) mid+1)) return (int) mid + 1;
                i = mid+1;
            }
        }
        return (int) i;
    }
}
