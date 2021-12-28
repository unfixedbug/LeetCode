class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int i,lenth = s.length();
        int ans[]  = new int [lenth];
        for( i=0;i<lenth;i++){
//             start from index 0 always, mov array is substring from i to len, decreasing always
            ans[i] = rec(n,0,startPos,s.substring(i,lenth).toCharArray());
        }
        return ans;
    }
    int rec(int n, int ind, int pos[], char mov[]){
        if(ind==mov.length)return 0;
        
        if(mov[ind]=='L' && pos[1]-1 >=0){
//             new position is shifted to left
            return 1 + rec(n,ind+1,new int[]{pos[0], pos[1]-1},mov);
        }
        else if(mov[ind]=='R' && pos[1]+1 <n){
//             new position is shifted to right
            return 1 + rec(n,ind+1,new int[]{pos[0], pos[1]+1},mov);
        }
        else if(mov[ind]=='U' && pos[0]-1 >=0){
//             new position is shifted to up
            return 1 + rec(n,ind+1,new int[]{pos[0]-1, pos[1]},mov);
        }
        else if(mov[ind]=='D' && pos[0]+1 <n){
//             new position is shifted to dows
            return 1 + rec(n,ind+1,new int[]{pos[0]+1, pos[1]},mov);
        }
        else return 0;
    }
}