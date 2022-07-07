class Solution {
    int val[] = {1,5,10,50,100,500,1000};
    char ch[] = {'I','V','X','L','C','D','M'};
    public int romanToInt(String s) {
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(i+1<n){
                int cur=giveValue(c);
                int next = giveValue(s.charAt(i+1));
                if(cur<next){
                    ans+= next-cur;
                    i+=1;
                }else{
                    ans+=cur;
                }
            }
            else ans+=giveValue(c);
        }
        return ans;
    
    }
    
    private int giveValue(char c){
        for(int i=0;i<7;i++){
            if(ch[i]==c)return val[i];
        }
        return 0;
    }
}