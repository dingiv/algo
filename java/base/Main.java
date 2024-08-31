package day01;

import java.util.Arrays;

public class Main {
   public static void main(String[] args) {
      var p = new Permutation();
      var q = new Combination();
      for (var i : q.combination(new int[] { 1, 2, 3, 4, 5 }, 3)) {
         System.out.println(Arrays.toString(i));
      }
   }
}
