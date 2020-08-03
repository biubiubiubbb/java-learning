package test.二维数组统计负数个数;

public class Demo {
    public static void main(String[] args) {
        /*
            1 2
            3 4
            5 6
         */
        int[][] grid = {{1, 2}, {3, 4}, {5, 6}, {3, 4}};  // 三行两列
//        int len =grid[0].length;
//        for (int[] rows : grid) {
//            for (int col = 0; col < grid[0].length; col++) {
//                if (rows[col] <= 3) {
//                    System.out.println(ints[col]);
//                }
//            }
//        }

        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

//        int[][] C = new int[A.length][2];
//        for (int row = 0; row < A.length; row++){
//            C[row][0] = Math.max(A[row][0],B[row][0]);
//            C[row][1] = Math.min(A[row][1],B[row][1]);
//        }
//        System.out.println(Arrays.toString(C));
        int[][] C = new int[A.length * 2][2];
        int rowC = 0;
        for (int row = 0; row < A.length; row++) {
            int max = Math.max(A[row][0], B[row][0]);
            int min = Math.min(A[row][1], B[row][1]);
            C[rowC][0] = max;
            C[rowC++][1] = min;
            if (max == min) {
                C[rowC][0] = max;
                C[rowC++][1] = max;
            }
        }
    }
}
