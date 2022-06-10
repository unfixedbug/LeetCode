[Nick White OP](http://www.youtube.com/watch?v=3IETreEybaA)
​
**strivers**
```java
class Solution {
public int lengthOfLongestSubstring(String s) {
int result=0;
Map<Character, Integer> map = new HashMap<>();
int start=0;
for(int end=0;end<s.length();end++){
char curr = s.charAt(end);
if(map.containsKey(curr)){
start = Math.max(start, map.get(curr)+1);
}
result = Math.max(result, end-start+1);
map.put(curr,end);
}
return result;
}
}
```