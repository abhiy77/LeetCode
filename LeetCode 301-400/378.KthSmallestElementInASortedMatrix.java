class Solution {
	
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<List<Integer>> pq = 
		new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        for(int row = 0; row < matrix.length; row++)
            pq.add(Arrays.asList(matrix[row][0], row, 0)); 

        while (k-- > 1) {
            List<Integer> curr = pq.remove();
            int row = curr.get(1), col = curr.get(2);
            if(col + 1 < matrix[0].length)
                pq.add(Arrays.asList(matrix[row][col + 1], row, col + 1));
        }

        return pq.remove().get(0);
    }
}
