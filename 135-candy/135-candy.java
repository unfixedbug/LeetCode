class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        int sum=0;
        Arrays.fill(candies,1);
        // if(ratings[0]>ratings[1])ans++;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                // we need to give i+1th element more candies
                // ans++;
                candies[i] = candies[i-1]+1;
            }
        }
        sum = candies[candies.length-1];// last element has the sum
        for(int i=candies.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
            sum+=candies[i];
        }
        return sum;
    }
}