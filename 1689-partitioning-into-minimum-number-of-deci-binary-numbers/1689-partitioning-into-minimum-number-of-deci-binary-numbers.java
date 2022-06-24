class Solution {
    public int minPartitions(String n) {
        char max = '0' ;
        
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) > max) {
                max = n.charAt(i) ;
            }
        }
        
        int result = (int) (max - '0') ;
        
        return result ;
    }
}