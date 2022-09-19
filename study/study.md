# 异或运算
异或运算是在底层的二进制数上进行运算得出的

## 异或运算的特点
- 相同为0
- 不同为1
- 无进位相加

例如
```text
异或运算        
  a:00010110                    
  b:00011011           
a^b:00001101   
  
无进位相加
 a:00010110                    
 b:00011011           
a+b:00001101(每个都没进位)
```
- 异或运算同时也满足**交换律**和**结合律**
```text
a^b = b^a 
(a^b)^c = a^(b^c)
``` 
## 使用异或交换
假如有a = 3，b=7两个数
```text
a = a^b; //a等于了3^7，b等于7
b = a^b; //带入，b=3^7^7化简：b=3，a=3^7
a = a^b; //带入，a=3^7^3化简：a=7，b=3
```
## 练习题
题目1：已知一个数组，一个数出现了奇数次，其他所有数
出现偶数次，请找出 出现了奇数次的数

题目2：已知一个数组，两个数出现了奇数次，其他所有数
出现偶数次，请找出这两个出现了奇数次的数

```java
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
```

# 排序
## 冒泡排序
```java
public class Sort {
    //冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, i, i+1);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[j] ^ arr[i];
    }
}
```
## 选择排序
```java
public class Sort {
    //选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            //最小值的下标
            int minIndex = i;
            for (int j = i +1; j < arr.length; j++) { //与后面的数据比较找最小的下标
                minIndex = arr[minIndex] > arr[j]? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[j] ^ arr[i];
    }
}
```
## 插入排序
```java
public class Sort {
    //插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j+1] < arr[j]; j--) {//当前的数比它前一个数小，就进行交换
                swap(arr, j+1, j);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[j] ^ arr[i];
    }
}
```