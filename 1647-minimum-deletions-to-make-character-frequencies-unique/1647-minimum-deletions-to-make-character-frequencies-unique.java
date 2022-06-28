class Solution {
    public int minDeletions(String s) {
        int a[] = new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        Set<Integer> uniq = new HashSet<>();
        int ans=0;
        
        for(int i=0;i<26;i++){
            if(a[i]!=0){
                while(uniq.contains(a[i]) && a[i]>0){
                    a[i]--;
                    ans++;
                }
                uniq.add(a[i]);
            }
        }
        return ans;
    }
}