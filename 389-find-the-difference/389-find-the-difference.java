class Solution {
    public char findTheDifference(String s, String t) {
        int charC = (int)t.charAt(s.length());
        for(int i=0;i<s.length();i++){
            charC -= (int)s.charAt(i);
            charC +=(int)t.charAt(i);
        }
        return (char)charC;
    }
}