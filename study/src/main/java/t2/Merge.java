package t2;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5};
        System.out.println(smallAdd(arr, 0, arr.length - 1));
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l +( (r-l)>>1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge1(arr, l, mid, r);
    }

    private static void merge1(int[] arr, int l, int mid, int r) {
        //申请help空间
        int[] help = new int[r-l+1];
        int index = 0;
        int aPoint = l;
        int bPoint = mid +1;
        while (aPoint<=mid && bPoint<=r) {
            help[index++] = arr[aPoint] > arr[bPoint] ? arr[bPoint++] : arr[aPoint++];
        }
        while (aPoint <= mid) {
            help[index++] = arr[aPoint++];
        }
        while (bPoint <= r) {
            help[index++] = arr[bPoint++];
        }
        System.arraycopy(help, 0, arr, l, help.length);
    }

    public static int smallAdd(int[] arr, int l, int r) {
        if (l == r)
            return 0;
        int mid = l +( (r-l)>>1);
        int sum = 0;
        sum += smallAdd(arr, l, mid);//左侧排好序求出的小和
        sum += smallAdd(arr, mid + 1, r);//右侧排好序求出小和
        sum += merger2(arr, l, mid, r);//左侧和右侧merge起来求小和
        return sum;
    }

    private static int merger2(int[] arr, int l, int mid, int r) {
        //申请help空间
        int[] help = new int[r-l+1];
        int index = 0;
        int sum = 0;
        int p1 = l;
        int p2 = mid +1;
        while (p1 <= mid && p2 <=r ) {
            if (arr[p1] < arr[p2]) {
                sum+=(r-p2+1)*arr[p1];
                help[index++] = arr[p1++];
            }else {//左大或等都是有指针移动
                help[index++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, l, help.length);
        return sum;
    }

}
