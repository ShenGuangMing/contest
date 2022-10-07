package sgm.t16;

public class Test6 {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(arr, 16));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length;
        int M = matrix[0].length;
        int i = 0;
        while (i<N-1) {
            if (matrix[i+1][0] > target){
               break;
            }
            i++;
        }
        int l = 0, r = M-1;
        while (l <= r) {
            int mid = (l + r)/2;
            if (matrix[i][mid] == target) {
                return true;
            }else if (matrix[i][mid] > target) {
                r = mid-1;
            }else {
                l = mid +1;
            }
        }
        return false;
    }
}
