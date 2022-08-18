class Solution {
    public int minSetSize(int[] arr) {
        int req = arr.length/2;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Integer freq[] = new Integer[map.size()];
        int currIndex=0;
        for(Map.Entry<Integer,Integer> en: map.entrySet()){
            freq[currIndex++] = en.getValue();
        }
        
        Arrays.sort(freq, Collections.reverseOrder());
   
        
        int count=0;
        int ans=0;
        for(int e:freq){
            if(count<req){
                count+=e;
                ans++;
            }else break;
        }
        return ans;
    }
}