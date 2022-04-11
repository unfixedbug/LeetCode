class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        
        int[][] table = new int[n][5];
        for(int i=0; i<n; ++i) table[i] = construct(transactions, i);
        Arrays.sort(table, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return 1000*(a[2]-b[2]) + (a[0] - b[0]);
            }
        });
        
        HashSet<Integer> answers = new HashSet<>();
        for(int i=0; i<n; ++i) {
            int[] arr = table[i];
            if(arr[1] > 1000) answers.add(arr[4]);
            int j = i+1;
            while(j < n && table[j][2] == arr[2] && table[j][0] <= arr[0]+60) {
                if(table[j][3] != arr[3]) {
                    answers.add(arr[4]);
                    answers.add(table[j][4]);
                }
                ++j;
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(int i: answers) ans.add(transactions[i]);
        return ans;
    }
    
    private HashMap<String, Integer> names = new HashMap<>(), cities = new HashMap<>();
    private int nId=0, cId=0;
    
    private int[] construct(String[] strings, int i) {
        String[] pieces = strings[i].split(",");
        int time = Integer.valueOf(pieces[1]), val = Integer.valueOf(pieces[2]), name=0, city=0;
        
        if(names.containsKey(pieces[0])) name = names.get(pieces[0]);
        else {
            name = nId++;
            names.put(pieces[0], name);
        }
        
        if(cities.containsKey(pieces[3])) city = cities.get(pieces[3]);
        else {
            city = cId++;
            cities.put(pieces[3], city);
        }
        
        return new int[] { time, val, name, city, i };
    
    }
}