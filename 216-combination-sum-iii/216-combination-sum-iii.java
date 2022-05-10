class Solution {
      List<List<Integer> > res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        sum3(1, n, k, new ArrayList<Integer>());
        return res;
    }


    private void sum3(int start, int n, int k, List<Integer> list){
        if(k < 0 || n < 0) return;

        if(k == 0 && n == 0){
            List<Integer> l = new ArrayList<>(list);
            res.add(l);
            return;
        }

        for(int i=start; i<10 ; i++){
            list.add(i);
            sum3(i+1, n-i, k-1, list);
            list.remove(list.size()-1);

        }

    }
}