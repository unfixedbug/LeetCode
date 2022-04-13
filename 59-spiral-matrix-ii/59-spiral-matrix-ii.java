class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int a=1;
        int startrow=0,endrow=n-1,startcol=0,endcol=n-1;
        while(startrow<=endrow && startcol <=endcol){
            for(int j=startcol;j<=endcol;j++){
                ans[startrow][j]=a++;
            }
            startrow++;
            for(int j=startrow;j<=endrow;j++){
                ans[j][endcol]=a++;
            }
            endcol--;
            if(startrow<=endrow){
                for(int j=endcol;j>=startcol;j--){
                    ans[endrow][j]=a++;
                }
            }
            endrow--;
            if(startcol<=endcol){
                for(int j=endrow;j>=startrow;j--){
                    ans[j][startcol]=a++;
                }
            }
            startcol++;
            
        }
        return ans;
        
    }
}