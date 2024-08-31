package day03;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Sort<Integer> method = new Selection<Integer>();
        // Sort<Integer> method = new Insertion<Integer>();
        // Sort<Integer> method = new Shell<Integer>();
        Sort<Integer> method = new Heap<Integer>();
        // Sort<Integer> method = new Quick<Integer>();


        // Sort<Integer> method = new Merge<Integer>(2);

        Integer[] arr = {91,2, 2, 41, 555, -9, 4, 021, 3, -78, 0xff};

        method.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
