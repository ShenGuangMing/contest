package exercise.t1;
/*
题目1：已知一个数组，一个数出现了奇数次，其他所有数出现偶数次，请找出 出现了奇数次的数
题目2：已知一个数组，两个数出现了奇数次，其他所有数出现偶数次，请找出这两个出现了奇数次的数

 */
public class Main {
    public static void main(String[] args) {
//        int i = 6 & (~6 + 1);
//        for (int i1 = 0; i1 < 10; i1++) {
//            if ((i&i1)==0) {
//                System.out.println(i1);
//            }
//        }
        int[] arr = {1,3,5,7,3,7,1,7};
        findTwoOdd(arr);
    }
    public static int findOneOdd(int[] arr) {
        int odd = 0;
        for (int curr : arr) {
            odd ^= curr;
        }
        return odd;
    }
    public static void findTwoOdd(int[] arr) {
        int eor = 0;
        eor = findOneOdd(arr);
        //eor = a ^ b，那么a，b就是这两个数，且a，b不相同eor!=0，那么eor必然有一位二进制数为1
        /*
        ~是二进制取反
        eor & (~eor + 1)就是提取出最右边的1
         */
        System.out.println(eor);
        int rightOne = eor & (~eor + 1);//提取出最右边的1
        int onlyOne=0;//eor`
        for (int curr : arr) {
            if ((curr & rightOne) != 0) {
                onlyOne ^= curr;
            }
        }
        System.out.println(onlyOne + " " + (onlyOne^eor));
    }
}
