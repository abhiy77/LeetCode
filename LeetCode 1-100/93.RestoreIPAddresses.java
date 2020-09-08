class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>(); 
        if(s.equals("") || s == null ) return result;
        if(s.length() < 4 || s.length() > 12) return result;
        findValidAddresses(s,0,0,"",result);
        return result;
    }
    
    public static boolean containsLeadingZeroes(String str) {
      boolean zero = false;
      int zeroCount = 0;
      for(int i=0;i<str.length();i++) {
        if(str.charAt(i) > '0' && str.charAt(i) <= '9') {
          if(!zero) return false;
          if(zero) return true;
        }
        else if(str.charAt(i) == '0') {
          zero = true;
          zeroCount++;
        }
      }
      return (zeroCount <= 1 ? false : true);
	}
	
	public static boolean isSafe(String curr) {
		//int arr[] = Arrays.asList(curr.split("\\.")).stream().mapToInt(Integer ::parseInt).toArray();
		String arr[] = curr.split("\\.");
		if(arr.length != 4) {
			return false;
		}
		for(int i=0;i<arr.length;i++) {
			if(containsLeadingZeroes(arr[i])) return false;
			else if(Integer.parseInt(arr[i]) < 0 || Integer.parseInt(arr[i]) > 255) {
				return false;
			}
		}
		return true;
	}
	
	public static void findValidAddresses(String str,int count,int i,String curr,List<String> result) {
		if(count == 3) {
			if(isSafe(curr+str.substring(i))) {
				result.add(new String(curr+str.substring(i)));
			}
			return;
		}
		for(int k=i;k<str.length();k++) {
			for(int j=k+1;j<str.length();j++) {
				findValidAddresses(str, count+1, j, curr+str.substring(k,j) +".",result);
			}
			return;
		}
	}
}
