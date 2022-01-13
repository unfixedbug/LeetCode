class Solution {
    public int maxProfit(int[] prices) {
        int dpl[] = new int [prices.length];
        int dpr[] = new int [prices.length];
        int leastSoFar = prices[0], maxProfitIfSellToday=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<leastSoFar){
                leastSoFar = prices[i];
            }
            maxProfitIfSellToday = prices[i] - leastSoFar;
            
            if(maxProfitIfSellToday > dpl[i-1]){// previously max profit
                dpl[i] = maxProfitIfSellToday;
            }else{
                dpl[i] = dpl[i-1]; // else, previous profit is more
            }
        }
        
//         right iteration
        int maxat = prices[prices.length-1]; //last element
        int maxProfitIfBoughtToday=0;
        
        
        for(int i=prices.length -2; i>=0;i--){
            if(prices[i] > maxat){
                    maxat = prices[i];
            }
            maxProfitIfBoughtToday = maxat - prices[i];
            if(maxProfitIfBoughtToday > dpr[i+1]){
                dpr[i] = maxProfitIfBoughtToday;
            }
            else{
                dpr[i] = dpr[i+1];
            }
            
        }
        int ans=0;
        for(int i=0;i<prices.length;i++){
            // dpl has best transaction on my left,
//             dpr hsa best transaction on my right, both are non overlapping 
            ans = Math.max(ans, dpl[i]+dpr[i]);
        }    
        
        return ans;
    }
}