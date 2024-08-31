package day03;

public class Heap<T extends Comparable<T>> implements Sort<T> {
    T cursor = null;

    void wrap(T[] arr, int a, int b) {
        cursor = arr[a];
        arr[a] = arr[b];
        arr[b] = cursor;
    }

    @Override
    public void sort(T[] arr) {
        int sz = arr.length - 1;
        // 构造堆
        // 堆是一个完全二叉树，且其中每个节点的值必须大于其子节点的值，
        // 且每个节点的索引值与子节点的索引值满足一个固定的公式关系
        // i, left=2*i+1, right=2*(i+1)
        for (int k = sz / 2; k >= 0; --k) {
            sink(arr, k, sz);
        }
        // 当建好堆之后，top 1就已经确定了，队首元素就是top 1，此时，将top 1与队尾元素进行对调，堆的结构遭到破坏。
        // 为了恢复就如此操作：不包括队尾的那个top 1，剩下的前n-1个元素，基本是满足堆结构的，只有新队首不满足，
        // 只需对新的队首进行下沉，那么前n-1个元素就又会满足堆结构，然后就会再产生一个'新的top 1'，即top 2
        while (sz > 0) {
            cursor = arr[0];
            arr[0] = arr[sz];
            arr[sz--] = cursor;
            sink(arr, 0, sz);
        }
    }

    // 堆的下沉操作，每次从左往右将队列中的大元素，下沉至队列的底部，在这个过程中，时刻与两个子节点中小的那个进行交换位置；
    void sink(T[] arr, int beg, int end) {
        int left = 2 * beg + 1, right = 2 * (beg + 1), smaller = left;
        if (right <= end) { // 如果right和left均有值
            smaller = compare(arr[left], arr[right]) < 0 ? left : right;
            if (compare(arr[beg], arr[smaller]) <= 0) return;
            wrap(arr, smaller, beg);
            sink(arr, smaller, end);
        } else { // 如果只有left有值
            if (left == end && compare(arr[end], arr[beg]) < 0) wrap(arr, end, beg);
        }
    }

    int compare(T a, T b) {
        return - a.compareTo(b);
    }

    // 堆的上浮操作
    void swim() {}
}
