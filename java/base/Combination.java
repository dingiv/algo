package day01;

import java.util.ArrayList;
import java.util.List;

public class Combination {
   int count = 0;
   boolean[] used = null; // 核心操作，使用一个位数组记录本轮已经选择的数字下标了
   // 输入输出
   int[] src = null;
   List<int[]> ans = new ArrayList<>();;

   public List<int[]> combination(int[] arr, int count) {
      this.src = arr;
      this.count = count;
      this.used = new boolean[arr.length];
      dfs(0, 0);
      return ans;
   }

   private void dfs(int depth, int start) {
      if (depth < count) {
         for (int i = start; i < src.length; ++i) {
            if (used[i]) continue;
            used[i] = true;
            dfs(depth + 1, i + 1);
            used[i] = false;
         }
      } else {
         int[] newOne = new int[count];
         for (int i = 0, j = 0; i < src.length && j < count; ++i) {
            if (used[i]) newOne[j++] = src[i];
         }
         ans.add(newOne);
      }
   }
}
