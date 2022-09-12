class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int mxscore=0;
        /// two pointers
        int i=0,j=tokens.length-1;
        int sc=0;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i++];
                sc++;
            }else{
                if(sc==0){
                    break;
                }
                power+=tokens[j--];
                sc--;
            }
            mxscore= Math.max(mxscore,sc);
        }
        return mxscore;
    }
}