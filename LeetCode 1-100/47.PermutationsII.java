class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> result = new LinkedList<>();
        recurse(input, new LinkedList<>(), result);
        return result.stream().distinct().collect(Collectors.toList());
    }
    
    public void recurse(List<Integer> input, List<Integer> path, List<List<Integer>> result) {
        if (input.size() == 0) {
            result.add(path);
            return;
        }
        for (int i = 0; i < input.size(); i++) {
            List<Integer> nPath = new LinkedList<>(path);
            nPath.add(input.get(i));
            List<Integer> nInput = new ArrayList<>(input);
            nInput.remove(i);
            recurse(nInput, nPath, result);
        }
    }
}
