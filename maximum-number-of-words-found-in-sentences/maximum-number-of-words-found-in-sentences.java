class Solution {
    public int mostWordsFound(String[] sentences) {
        int len,count,max=0;
        for(String s:sentences)
        {
           len=s.length();
           count=1;
           for(int i=0; i<len; i++)
               if(s.charAt(i)==32)
                   count++;
           max=count>max?count:max;
        }
        return max;
    }
}