class Solution {
    
    
    List<Integer> ans;
    int lo, hi;
    public List<Integer> sequentialDigits(int low, int high) {
//         nau=ive soln
     String digits = "123456789";
        ans= new ArrayList<>();
        
        for (int len = 2; len <= digits.length(); len++) {
            for (int j = 0; j + len <= digits.length(); j++) {
                String sub = digits.substring(j, j + len);
                Integer num = Integer.parseInt(sub);
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        
        
//         for recursive soln
        /*
        
        
        lo=low;
        hi=high;
        for(int i=1;i<10;i++){
            go(i);
        }
        Collections.sort(ans);
       
        */
            
             return ans;
       
    }
    
    void go(int num){
        if(num> hi) return;
        else if(num >= lo){
            ans.add(num);
        }
        int last  = num%10;
        if(last < 9){
            go(num*10 + last + 1);
        }
    }
    
}