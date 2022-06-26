class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int cursum=0,maxsum=0;
        int n = cardPoints.length;
        int i=0,j=0;
        int total=0;
        // summ of first n-k elements
        for(int e:cardPoints)total+=e;
        for( i=0;i<n-k;i++)cursum+=cardPoints[i];
        maxsum=cursum;// consider it as min sum;
        i=0;
        j=n-k;
        while(j<n){
            cursum+=cardPoints[j];
            cursum-=cardPoints[i];
            maxsum = Math.min(maxsum,cursum);
            j++;
            i++;
        }
        return total-maxsum;
    }
}