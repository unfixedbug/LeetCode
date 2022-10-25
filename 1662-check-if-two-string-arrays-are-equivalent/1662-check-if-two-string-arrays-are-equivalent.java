class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        ArrayList<Character> s1 = new ArrayList<>();
        ArrayList<Character> s2 = new ArrayList<>();
        for(String s:word1){
            for(char c:s.toCharArray())s1.add(c);
        }
        for(String s:word2){
            for(char c:s.toCharArray())s2.add(c);
        }
        // Collections.sort(s1);
        // Collections.sort(s2);
        return s1.equals(s2);
    }
}