class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>();
    for (int i = 0; i < buildings.length; i++) {
      list.add(new Pair(buildings[i][0], -buildings[i][2])); // start neg
      list.add(new Pair(buildings[i][1], buildings[i][2])); // end pos
    }

    // sort the list by x

    Collections.sort(list);

    List<List<Integer>> ans = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    pq.add(0);
    int max = 0;

    int cht = 0; //current height
    for (int i = 0; i < list.size(); i++) {
      int x = list.get(i).x;
      int ht = list.get(i).height;

      if (ht < 0) { // start
        pq.add(-ht);
      } else { // end point
        pq.remove(ht);
      }

      // if current height is not equal to max height then add it to the ans
      if (cht != pq.peek()) {
        ans.add(new ArrayList<Integer>());
        ans.get(ans.size() - 1).add(x);
        ans.get(ans.size() - 1).add(pq.peek());
        cht = pq.peek();
      }
    }
    return ans;
  }

  // compare two pairs and return the one with higher height
  public class Pair implements Comparable<Pair> {
    int x;
    int height;

    public Pair(int x, int height) {
      this.x = x;
      this.height = height;
    }

    @Override
    public int compareTo(Pair o2) {
      if (this.x != o2.x) {
        return this.x - o2.x;
      } else {
        return this.height - o2.height;
      }
    }
  }
}