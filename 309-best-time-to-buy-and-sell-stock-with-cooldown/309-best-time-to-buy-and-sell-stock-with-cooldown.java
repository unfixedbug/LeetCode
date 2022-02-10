class Solution {
    public int maxProfit(int[] prices) {
        int obsp = -prices[0]; // old bought state profit
        int ossp = 0; // sold state
        int ocsp = 0; // cooled state
        
        for(int i=1;i<prices.length;i++){
            int nbsp=0; // bought state profit
            int nssp=0;  // sold state profit
            int ncsp=0;  // cooled state profit
            
            if(ocsp - prices[i] > obsp){  // old price bought state, but on old cool
                nbsp=ocsp -prices[i]; // if cooling gives more profit then, 
            }else{ // old bought state is greater than cool down period
                nbsp = obsp;
            }
            
            
//             sold state
            if(obsp + prices[i] > ossp){ /// maintain old bought, or sell?
                nssp = obsp + prices[i];
            }
            else{
                nssp = ossp;
            }
            
//             cooldown
            if(ossp > ocsp){
                ncsp = ossp;
            }
            else{
                ncsp = ocsp;
            }
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
//             https://www.youtube.com/watch?v=GY0O57llkKQ
        }
        
        return ossp;
    }
}