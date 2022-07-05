class Solution {
    public String sortSentence(String s) {
        String tp[] = s.split(" ");
        String ans="";
        Arrays.sort(tp,(a,b)-> a.charAt(a.length()-1)-b.charAt(b.length()-1));
        for(String p:tp){
            ans+=p.substring(0,p.length()-1);
            ans+=" ";
        }
        return ans.trim();
    }
}