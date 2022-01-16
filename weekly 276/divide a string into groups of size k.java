class Solution {
    public String[] divideString(String s, int k, char fill) {
        int groups = s.length()/k;
        StringBuilder sb = new StringBuilder();
         int rem = s.length()%k;
        String ans[] = new String[rem==0? groups:groups+1];
        int start=0;
        for(int i=0;i < groups;i++){
            ans[i] = s.substring(start,start+k);
            start+=k;
        }
        if(s.length()%k !=0){
            
            sb.append(s.substring(s.length()-rem, s.length()));
        
            for(int i=0;i< k-rem;i++){
                sb.append(fill);
            }
            ans[groups] = sb.toString();
        }
        return ans;
        
    }
}