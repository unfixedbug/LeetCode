class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right=1;
        for(int pile:piles){
            right = Math.max(pile, right);
        }
//         binary search BITCH
        while(left<right){
            int mid = left + (right-left)/2;
            int hourspent = 0;
            for(int pile:piles){
                
//                 if mid = 4, pile = 4,5,6 then we need 1,2,2 hours, you got it right?
                hourspent += Math.ceil((double)pile/mid);
            }
            if(hourspent <=h){
                // we can searh in the left, for a smaller value if available.
                right=mid;
            }
            else{
                // this mid cant give us the value, can we find a greater value?
                left = mid+1;
            }
        }
//         once the left and right boundaries coincide, we found the target value;
        return right;
        
    }
}