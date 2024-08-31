package day04;

// 6.字符串的Z字形转换。

public class ZTransform {

    String convert(String str, int cols) {
        int len = str.length();
        int groupAmount = len / (2 * cols - 2) + 1;
        char[][] arr = new char[groupAmount * (cols - 1)][cols];

        int id = 0, row = 0;
        while (groupAmount-- > 0) {
            for (int i = 0; i < cols && id < len; ++i) {
                arr[row][i] = str.charAt(id++);
            }
            for (int j = cols - 2; j > 0 && id < len; --j) {
                row++;
                for (int k = 0; k < j; ++k) {
                    arr[row][k] = ' ';
                }
                arr[row][j] = str.charAt(id++);
                for (int k = cols - 1; k > j && id < len; --k) {
                    arr[row][k] = ' ';
                }
            }
            row++;
        }


        for (int i = 0; i < cols; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                if (arr[j][i] == '\0') arr[j][i] = ' ';
                System.out.print(arr[j][i]);
            }
            System.out.println();
        }


        return "";
    }
}
