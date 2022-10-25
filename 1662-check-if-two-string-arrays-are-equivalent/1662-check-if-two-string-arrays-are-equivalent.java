class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a="";
        String b="";
        for(String n:word1)
            a+=n;
        for(String n:word2)
            b+=n;
        return a.equals(b);
        }
}