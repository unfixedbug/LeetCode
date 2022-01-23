class Solution {
    List<Integer> ans;
    int lo, hi;
    public List<Integer> sequentialDigits(int low, int high) {
        ans = new ArrayList<>();
        lo=low;
        hi=high;
        for(int i=1;i<10;i++){
            go(i);
        }
        Collections.sort(ans);
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