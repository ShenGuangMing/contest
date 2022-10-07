package t10_;

public class Code1_IsLands {
    public static void main(String[] args) {

    }

    public static int countIsLands(int[][] m) {
        if (m == null || m[0] == null)
            return 0;
        int row = m.length;
        int col = m[0].length;
        int  res = 0;
        for (int i=0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, row, col);
                }
            }
        }
        return res;
    }
    public static void infect(int[][] m, int i, int j, int row, int col) {
        if (i < 0 || i>=row || j<0 || j>=col || m[i][j] != 0) {
            return;
        }
        //没有越界
        m[i][j] = 2;
        infect(m, i-1, j ,row, col);
        infect(m, i+1, j ,row, col);
        infect(m, i, j-1 ,row, col);
        infect(m, i, j+1 ,row, col);
    }
}
