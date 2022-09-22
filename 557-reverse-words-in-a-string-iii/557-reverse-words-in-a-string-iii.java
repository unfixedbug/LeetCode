class Solution {
    //steps
    
    /*
        
    */
   public static String reverseWords(String s) {
    int start = 0;
    int end = 0;
    char ch[] = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    while (end < s.length()) {
      if (ch[end] == ' ') {
        sb.append(reverse(start, end, s) + " ");
        start = end + 1;
        end++;
      } else {
        end++;
      }
    }
    sb.append(reverse(start, s.length(), s));

    return sb.toString();
  }

  private static String reverse(int st, int en, String s) {
    String sub = s.substring(st, en);
    char ch[] = sub.toCharArray();
    int i = 0, j = ch.length - 1;
    while (i < j) {
      char temp = ch[i];
      ch[i] = ch[j];
      ch[j] = temp;
      i++;
      j--;
    }

    return new String(ch);
  }
}