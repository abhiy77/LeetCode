class Solution {
	
    public List<List<Integer>> permute(int[] nums) {

        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<nums.length;i++) {
			list.add(nums[i]);
			dfs(result, list, nums,i,1);
			list.removeLastOccurrence((Object) nums[i]);
		}
		return result;
    }
    
   public static void dfs(LinkedList<List<Integer>> result, LinkedList<Integer> list, int[] nums,int i,int count) {
		if(count == nums.length) {
			HashSet<Integer> set = new HashSet<>(list);
			if(set.size() == nums.length && !result.contains(set)) {
				result.add((LinkedList<Integer>)list.clone());
			}
			return;
		}

		for (int k = 0; k < nums.length; k++) {
			if(k == i) continue;
			list.add(nums[k]);

			dfs(result, list, nums,k,count+1);
			list.removeLastOccurrence((Object) nums[k]);
		}
	}
}
