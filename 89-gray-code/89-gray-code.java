class Solution {
    public List<Integer> grayCode(int n) {
        List<String> temp = helper(n);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<temp.size();i++){
            res.add(Integer.parseInt(temp.get(i),2));
        }
        return res;
    }
    private List<String> helper(int n){
         if(n==1){
            List<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }
        
        List<String> prev = helper(n-1);
        List<String> curr = new ArrayList<>();
        
        for(int i=0;i<prev.size();i++){
            //add zero
            String s = prev.get(i);
            curr.add("0"+s);
        }
        
        for(int i=prev.size()-1;i>=0;i--){
            //add one
            String s = prev.get(i);
            curr.add("1"+s);
        }
        return curr;
    }
}