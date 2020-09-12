class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    String hour = String.valueOf(i);
                    String min = j < 10 ? "0" + j : "" +j;
                    result.add(hour + ":" + min);
                }
            }
        }
        
        return result;
    }
}
