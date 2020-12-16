import java.util.ArrayList;
import java.util.Arrays;

public class SearchA2DMatrix {
    public static void main(String[] arg) {
        int target = 12;
        int[][] matrix = {{1,3,5,7}, {10,11,16,20},{23,30,34,50}};
        //System.out.println(matrix.length);
        //System.out.println(matrix[0].length);


        int m = matrix.length;
        if (m == 0) System.exit(0);
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) {
                System.out.println("true");
                System.exit(0);
            }else if (target < pivotElement) {
                right = pivotIdx - 1;
            } else {
                left = pivotIdx + 1;
            }
        }
        System.out.println("false");
    }

}