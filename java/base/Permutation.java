package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 全排列
public class Permutation {
   int length = 0;
   int[] newOne = null; // 核心操作，使用一个数组记录当前路径上的数字，配合深度有限遍历dfs，不会消耗大量的内存
   boolean[] used = null; // 核心操作，使用一个位数组记录数字是否被重复使用
   // 输入输出
   int[] src = null;
   List<int[]> ans = new ArrayList<>();;

   public List<int[]> permutation(int[] arr, int m) {
      this.src = arr;
      this.newOne = new int[arr.length];
      this.used = new boolean[arr.length];
      this.length = m;
      dfs(0);
      return ans;
   }

   private void dfs(int depth) {
      if (depth < length) {
         for (int i = 0; i < src.length; ++i) {
            if (used[i]) continue;
            newOne[depth] = src[i];
            used[i] = true;
            dfs(depth + 1);
            used[i] = false; // 回溯，将先前路径上的内容还原出来，消除纵深后的影响
         }
      } else {
         ans.add(Arrays.copyOf(newOne, length));
      }
   }
}
