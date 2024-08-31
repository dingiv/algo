package day01;

// 双指针的写法
public class DoublePointer {
  private void doublePtr(int[] arr, int beg, int end) {
    while (beg < end) {
      if (arr[beg] > arr[end] /* condition */) {
        beg++;
      } else
        if (arr[beg] < arr[end] /* condition */) {
          end--;
        } else {
          // 跳过重复，非常重要！！！
          for (beg++; beg < end && arr[beg] == arr[beg - 1]; beg++);
          // 处理重复元素;
          for (end--; beg < end && arr[end] == arr[end + 1]; end--);
          // 处理重复元素;
        }
    }
  }
}
