class Solution {
    public int minSetSize(int[] arr) {
        int req = arr.length/2;
        Set<Integer> set = new HashSet<>();
        // contains -> l[0]-> number, l[1]-> value
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        //
        List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());
        
        
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer>o1, Map.Entry<Integer,Integer>o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
            // sorted with values
        HashMap<Integer,Integer> sorted = new LinkedHashMap<Integer,Integer>();
        
        for(Map.Entry<Integer,Integer> entry:list){
            sorted.put(entry.getKey(),entry.getValue());
        }
        
        // sorted
        int n=arr.length;
        int ans=0;
        for(Map.Entry<Integer,Integer> en:sorted.entrySet()){
            if(n>req){
                ans++;
                n-=en.getValue();
            }else{
                break;
            }
        }
        return ans;
    }
}