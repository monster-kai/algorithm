package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Ryan
 * @data 2020/03/03 - 周二
 */
public class SortCharacterByFrequency {   // 对应 LeetCode 451 ，根据字符串词频重新排序后输出
  public static String freqSort(String s) {
    int[] freq = new int[256];
    for (char c : s.toCharArray()) {
      freq[c]++;
    }
    PriorityQueue<Letter> q = new PriorityQueue<>(Collections.reverseOrder());   // 大顶堆实现优先级队列
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] != 0) {
        Letter e = new Letter((char) i, freq[i]);
        q.add(e);
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!q.isEmpty()) {
      Letter e = q.poll();
      while (e.count > 0) {
        sb.append(e.letter);
        e.count--;
      }
    }

    return sb.toString();
  }

  private static class Letter implements Comparable<Letter> {
    private char letter = '0';
    private int count = 0;

    public Letter(char letter, int count) {
      this.letter = letter;
      this.count = count;
    }

    @Override
    public int compareTo(Letter o) {
      if (this.count != o.count) {
          return this.count - o.count;
      } else {
          return this.letter - o.letter;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(freqSort("tree"));
  }
}
