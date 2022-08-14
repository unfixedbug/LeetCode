class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return new ArrayList<>();
        }

        words.add(beginWord);

        HashMap<String, List<String>> adjList = new HashMap<>();

        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = getPattern(word, i);
                adjList.putIfAbsent(pattern, new ArrayList<>());
                adjList.get(pattern).add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> levels = new HashMap<>();

        queue.add(beginWord);
        levels.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int curLevel = levels.get(cur);
            graph.putIfAbsent(cur, new HashSet<>());

            for (int i = 0; i < cur.length(); i++) {
                String pattern = getPattern(cur, i);

                for (String nei: adjList.get(pattern)) {
                    
                    graph.get(cur).add(nei);
                    if (!levels.containsKey(nei)) {
                        levels.put(nei, curLevel + 1);
                        queue.add(nei);
                    }
                }
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        if (!graph.containsKey(endWord)) {
            return ans; 
        }

        backtracking(endWord, beginWord, new ArrayList<>(), ans, graph, levels);

        return ans;
    }

    private void backtracking(String start, String endWord,
                              List<String> path, List<List<String>> ans,
                              HashMap<String, Set<String>> graph,
                              Map<String, Integer> levels) {
        path.add(start);

        if (start.equals(endWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
        } else {
            for (String next : graph.get(start)) {
                if (levels.get(next) == levels.get(start) - 1) {
                    backtracking(next, endWord, path, ans, graph, levels);
                }
            }
        }

        path.remove(path.size() - 1);
    }

    private String getPattern(String word, int i) {
        return word.substring(0, i) + "*" + word.substring(i + 1);
    }
}
