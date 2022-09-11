class Solution {
    
    // can be solved as same as the meeting  room problem, i
    // it is just the maximum number of overlapping intervals
    public int minGroups(int [][]inter){
        int freq[] = new int[1000005];
        for(int i=0;i<inter.length;i++){
            freq[inter[i][0]]++;
            //+1 cause inclusive
            freq[inter[i][1]+1]--;
        }
        
        int ans=0;
        
        // draw a prefix sum, and get the max el;
        
        for(int i=1;i<1000005;i++){
            freq[i]+=freq[i-1];
            ans = Math.max(ans,freq[i]);
        }
        
        return ans;
    }
    
    
    public int minGroupsDuringContest(int[][] inter) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int l=0;
        HashSet<Integer> set = new HashSet<>();
        for(int a[]:inter){
            set.add(a[0]);    
        }
        
        HashSet<Integer> vis = new HashSet<>();
        int srt[] = new int[set.size()];
        
        for(Integer e:set){
            srt[l++]=e;
        }
        
        
        Arrays.sort(srt);
        
        
        
        for(int a[]:inter){
            map.put(a[0],map.getOrDefault(a[0],0)+1);
        }
        
        l=0;
        for(int i=0;i<inter.length;i++){
            int start=inter[i][0];
            int end = inter[i][1];
            int bound = upperbound(srt,end);
            if(bound==-1 )l++;
            else{
                if(vis.contains(srt[bound])){
                    l++;    
                    continue;
                }
                int req = srt[bound];
                // System.out.println(map);
                // System.out.println(map.get(req)+" <-freq, "+req+" <-req");
                map.put(req,map.get(req)-1); 
                
                int newval = map.get(req);
                if(newval==0){
                    l--;
                    vis.add(req);
                    map.remove(req);
                }
            }
        }
        
        return l;
    }
    
    private int upperbound(int a[], int x){
        int s=0;
        // int ans=-1;
        int pos=-1;
        int e=a.length;
        while(s<e){
            int mid = s+ (e-s)/2;
            if(a[mid]>x){
                pos=mid;
                e=mid;
            }else{
                s=mid+1;
            }
        }
        
        // System.out.println(x+"-> "+pos);
        return pos;
    }
}