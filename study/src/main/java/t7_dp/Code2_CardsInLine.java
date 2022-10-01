package t7_dp;

public class Code2_CardsInLine {

    public static int win3(int[] arr) {
        int N = arr.length;
        int[][] fMap = new int[N][N];
        int[][] gMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            fMap[i][i] = arr[i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                int p1 = arr[j] + gMap[j+1][j+i];
                int p2 = arr[j+i] + gMap[j][j+i-1];
                fMap[j][j+i] = Math.max(p1, p2);
                p1 = fMap[j+1][j+i];
                p2 = fMap[j][j+i-1];
                gMap[j][j+i] = Math.min(p1, p2);
            }
        }
        return Math.max(fMap[0][N-1], gMap[0][N-1]);
    }

    public static int win2(int[] arr) {
        int N = arr.length;
        int[][] fMap = new int[N][N];
        int[][] gMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fMap[i][j] = -1;
                gMap[i][j] = -1;
            }
        }
        int first = f2(arr, 0, N - 1, fMap, gMap);
        int second = g2(arr, 0, N - 1, fMap, gMap);
//        System.out.println("fMap:");
//        ArrayUtil.print2Arr(fMap, N, N);
//        System.out.println("gMap");
//        ArrayUtil.print2Arr(gMap, N, N);
        return Math.max(first, second);
    }

    public static int f2(int[] arr, int l, int r, int[][] fMap, int[][] gMap) {
        if (fMap[l][r] != -1)
            return fMap[l][r];
        int ans = 0;
        if (l == r)
            ans = arr[l];
        else {
            int p1 = arr[l] + g2(arr, l + 1, r, fMap, gMap);
            int p2 = arr[r] + g2(arr, l, r - 1, fMap, gMap);
            ans = Math.max(p1, p2);
        }
        fMap[l][r] = ans;
        return ans;
    }

    private static int g2(int[] arr, int l, int r, int[][] fMap, int[][] gMap) {
        if (gMap[l][r] != -1)
            return gMap[l][r];
        int ans = 0;
        if (l != r) {
            int p1 = f2(arr, l + 1, r, fMap, gMap);
            int p2 = f2(arr, l, r - 1, fMap, gMap);
            ans = Math.min(p1, p2);
        }
        gMap[l][r] = ans;
        return ans;
    }


    public static int win1(int[] arr) {
        int first = f1(arr, 0, arr.length - 1);
        int second = g1(arr, 0, arr.length - 1);
        return Math.max(first, second);
    }

    public static int f1(int[] arr, int left, int right) {
        if (left == right)
            return arr[left];
        int p1 = arr[left] + g1(arr, left + 1, right);
        int p2 = arr[right] + g1(arr, left, right - 1);
        return Math.max(p1, p2);
    }

    private static int g1(int[] arr, int left, int right) {
        if (left == right)//后手拿不到这张拍
            return 0;
        int p1 = f1(arr, left + 1, right);//对手拿了left位置，该我了我要在left+1到right中选最好的
        int p2 = f1(arr, left, right - 1);//对手拿了right位置，该我了我要在left到right-1中选最好的
        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3};
//        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
    }
}
