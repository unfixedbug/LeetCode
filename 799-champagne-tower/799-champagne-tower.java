class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] cap = new double[102][102];
        cap[0][0] = (double)poured;
        for(int r=0;r <=query_row;r++){
            for(int c=0; c<=query_glass;c++){
                double q = (cap[r][c]-1.0)/2.0;// champaigne fills the glass and rest-1 is
                if(q>0){
                    cap[r+1][c]+=q;
                    cap[r+1][c+1]+=q;
                    
                }
            }
        }
        return Math.min(1, cap[query_row][query_glass]);
    }
}