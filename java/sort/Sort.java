package day03;

public interface Sort<T extends Comparable<T>> {

    void sort(T[] arr);
}
