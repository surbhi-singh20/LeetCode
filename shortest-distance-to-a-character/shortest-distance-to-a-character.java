class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] carr = new int[n];
        int left_idx = -1;
        int right_idx = -1;
        Arrays.fill(carr, Integer.MAX_VALUE);
        for(int i=0; i<n; i++){
            if(s.charAt(i) == c) carr[i] = 0;
        }
        for(int i=0; i<n; i++){
            if(carr[i] == 0){
                left_idx = i;
            }
            if(left_idx != -1){
                carr[i] = Math.abs(i- left_idx);
            }
        }
        
        for(int i=n-1; i>=0; i--){
            if(carr[i] == 0){
                right_idx = i;
            }
            if(right_idx != -1){
                carr[i] = Math.min(carr[i], Math.abs(i- right_idx));
            }
        }
        return carr;
    }
}