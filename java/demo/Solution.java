package day09.halveArray;

/*
* @lc app=leetcode.cn id=2208 lang=java
*
* [2208]
*/
// @lc code=start
public class Solution {
   public int halveArray(int[] nums) {
      int count = 0;
      Heap heap = new Heap(nums);

      return 0;
   }

   private class Heap {
      double[] arr = null;
      int length = 0;
      double total = 0;
      double cursor = 0;

      void wrap(double[] arr, int a, int b) {
         cursor = arr[a];
         arr[a] = arr[b];
         arr[b] = cursor;
      }

      public Heap(int[] nums) {
         this.length = nums.length + 1;
         for (int i = 1; i < length; ++i) {
            arr[i] = nums[i - 1];
            total += arr[i];
         }
         total /= 2;
      }

      public double pop() {
         arr[0] = arr[1];
         arr[1] = arr[length - 1];
         sink(1, arr.length - 1);
         return arr[0];
      }

      void sink(int beg, int end) {
         int left = 2 * beg + 1, right = 2 * beg + 2, bigger = left;
         if (right <= end) { // 如果right和left均有值
            bigger = arr[left] > arr[right] ? left : right;
            if (arr[beg] >= arr[bigger]) return;
            wrap(arr, bigger, beg);
            sink(bigger, end);
         } else { // 如果只有left有值
            if (left == end && arr[end] > arr[beg]) wrap(arr, end, beg);
         }
      }

      private void shiftUp() {
         for (int i = length / 2; i >= 0; --i) {

         }
      }
   }
}

// @lc code=end