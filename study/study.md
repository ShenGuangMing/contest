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
        //测试
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
# 二分
## 二分-查找一个数
```java
public class Find {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 11, 32, 44, 48, 64};
        System.out.println(dichotomyCycle(arr, 48));
        System.out.println(dichotomyRecursion(arr, 0, arr.length-1, 48));
    }
    //循环二分
    public static int dichotomyCycle(int[] arr, int target) {
        int right = arr.length -1;
        int left = 0;
        while (left <= right) {
            int curr = (left+right)/2;
            if (arr[curr] == target) {
                return curr;
            }else if (arr[curr] < target) {
                left = curr+1;
            }else {
                right = curr -1;
            }
        }
        return -1;
    }
    //递归二分
    public static int dichotomyRecursion(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int curr = (left + right) / 2;
        if (arr[curr] == target) return  curr;
        else if (arr[curr] < target) return dichotomyRecursion(arr,  curr+1, right, target);
        else return dichotomyRecursion(arr,  left, curr-1, target);
    }
}
```

## 二分-查找大于等于最左侧
在一个有序数组中，找>=某个数最左则的位置
```java
public class Find {
    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 7, 11, 11, 11, 12, 21, 21, 32, 33, 33, 40, 40, 40, 41};
        int i =  farLeftCycle(arr, 36);
        if (i != -1) {
            System.out.println(i + " : " + arr[i]);
        }else {
            System.out.println("null");
        }
    }
    //循环实现
    public static int farLeftCycle(int[] arr, int target) {
        int right = arr.length -1;
        int left = 0;
        int curr = (left + right) / 2;
        while (left < right) {
            if (arr[curr] < target) {
                left = curr + 1;
            }else  {
                right = curr;
            }
            curr = (left + right) / 2;
        }
        if (arr[curr] < target) {
            return -1;
        }
        return curr;
    }
}
```

## 二分-局部最小问题
在无重复元素，无序数组中找局部最小
```java
public class Find {
    //在无重复元素，无序数组中找局部最小
    public static int localMin(int[] arr) {
        //对数组的两边界进行判断
        if (arr[0] < arr[1]) {
            return 0;
        }else if (arr[arr.length -1] < arr[arr.length -2]) {
            return arr.length -1;
        }
        int right = arr.length-1;
        int left = 0;
        while (left < right) {
            int curr = (left+right)/2;
            if (curr-1>=0 && arr[curr] > arr[curr -1]) {
                right = curr;
            }else if (curr + 1 < arr.length && arr[curr] > arr[curr +1]) {
                left = curr;
            }else {
                return curr;
            }
        }
        return -1;
    }
}
```
## 递归-查找最大值
```java
public class Find {
    public static int findMax(int[] arr, int l, int r) {
        if (l == r)
            return arr[l];
        int mid = l +( (r - l)>>1);
        int leftMax = findMax(arr, l, mid);
        int rightMax = findMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}
```

##  归并排序
```java
public class Sort {
    
    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l +( (r-l)>>1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
    private static void merge(int[] arr, int l, int mid, int r) {
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
}
```

## 小和问题和逆序对问题

### 小和问题
在一个数组中，每个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和
```java
public class Merge {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5};
        System.out.println(smallAdd(arr, 0, arr.length - 1));
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
```

### 逆序对问题
在一个数组中 ，左边的数如果比右边的大，则这两个数构成逆序对，请打印所有的逆序对


### 荷兰国旗问题  
 **问题一**：

给定一个数组arr，和一个数num，请把小于等于num放在数组的左边，大于num的数放右边。要求空间复杂度O(1)，时间复杂O(N)
```java
public class DutchFlagQuestion {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 4, 9};
        question1(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
    public static void question1(int[] arr, int target) {
        int index = 0;
        int len = arr.length-1;//数组长度
        int left = -1;//左边界
        for (; index<=len; ++index) {
            if (arr[index] <= target) {
                swap(arr, index, ++left);
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
```
**问题二（荷兰国旗问题）**：

给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。要求额外空间复杂度0(1)，时间复杂度0(N)
```java
public class DutchFlagQuestion {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 3, 4, 5, 2, 6, 9, 0};
        question2(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void question2(int[] arr, int target) {
        int index = 0;
        int left = -1;
        int right = arr.length;
        while (index < right) {
            if (arr[index] < target) {
                swap(arr, index++, ++left);
            }else if (arr[index] > target) {
                //index不能向后移，因为交换中的arr[--right]还没有看
                swap(arr, index, --right);
            }else {
                index++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
```
### 快排
我的是实现
```java
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 3, 4, 5, 2, 6, 9, 6};
        quickSort2(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            //随机一个作为分界值放到最后
            swap(arr, left+(int)(Math.random() * (right - left + 1) ), right);
            int[] p = partition(arr, left, right);
            quickSort2(arr, left, p[0]);
            quickSort2(arr, p[1], right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int l = left -1;//左区
        int r = right;//右区
        int target = arr[right];//给定范围中最后的值
        int index = left;//开始位置
        while (index < r) {//当遍历到右区就停止
            if (arr[index] < target) {
                swap(arr, index++, ++l);
            }else if (arr[index] > target) {
                swap(arr, index, --r);//荷兰国旗问题解释了
            }else {//相等的情况，index向后移
                index++;
            }
        }
        swap(arr, right, r);//和右区第一个交换
        return new int[] {l, r+1};
    }
    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
```

### 堆排序 
#### 大根堆
二叉树中，所有的根节点都比他的子节点大

在数组中最后插入一个数，让整个数组是大根堆
```java
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 3, 6, 5, 1, 2, 7};
        heapInsert(arr, 7);//0-6已经是大根堆，7还没有排
        System.out.println(Arrays.toString(arr));

    }

    public static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index-1)/2]){//这插入的新位置的数是否比我的父节点大
            swap(arr, index, (index-1)/2);//大就交换
            index = (index-1)/2;//跟新为父节点的位置
        }
    }
    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
```
在数组中原本就是大根堆，我们在根位置的数修改，让他最后是大根堆
```java
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 7, 8, 6, 5, 3, 2};
        heapify(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index*2+1;//左孩子下标
        while (left  <  heapSize) {//存在左儿子
            int largest = index*2+1;//假如当前左儿子是最大的
            if (index*2+2 < heapSize) {//存在右儿子
                largest = arr[largest] > arr[left+1]? largest : left+1;//左右儿子大的下标
            }
            largest = arr[largest] > arr[index]? largest: index;//最大儿子和父节点比
            if (arr[largest] == arr[index])
                break;
            swap(arr, index, largest);
            index = largest;
            left =  index*2+1;//新左儿子
        }
    }
    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
```

### 堆排序
1，先让整个数组都变成大根堆结构，建立堆的过程:

    1)从上到下的方法，时间复杂度为0(N*logN)

    2)从下到上的方法，时间复杂度为0(N)
2，把堆的最大值和堆末尾的值交换，然后减少堆的大小之后，再去调整堆，一直周而复始，时间复杂度为O(N*logN)

3，堆的大小减小成0之后，排序完成


```java
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 3, 6, 5, 1, 2, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = 0;
        while (heapSize < arr.length) {
            heapInsert(arr, heapSize++);//插入
        }
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);//先交换，heapSize再减小
            heapify(arr, 0, heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index-1)/2]){//这插入的新位置的数是否比我的父节点大
            swap(arr, index, (index-1)/2);//大就交换
            index = (index-1)/2;//跟新为父节点的位置
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index*2+1;//左孩子下标
        while (left  <  heapSize) {//存在左儿子
            int largest = index*2+1;//假如当前左儿子是最大的
            if (left+1 < heapSize) {//存在右儿子
                largest = arr[largest] > arr[left+1]? largest : left+1;//左右儿子大的下标
            }
            largest = arr[largest] > arr[index]? largest: index;//最大儿子和父节点比
            if (arr[largest] == arr[index])
                break;
            swap(arr, index, largest);
            index = largest;
            left =  index*2+1;//新左儿子
        }
    }
    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
```
```java
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 3, 6, 5, 1, 2, 7};
        heapSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length-1; i>=0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index*2+1;//左孩子下标
        while (left  <  heapSize) {//存在左儿子
            int largest = index*2+1;//假如当前左儿子是最大的
            if (left+1 < heapSize) {//存在右儿子
                largest = arr[largest] > arr[left+1]? largest : left+1;//左右儿子大的下标
            }
            largest = arr[largest] > arr[index]? largest: index;//最大儿子和父节点比
            if (arr[largest] == arr[index])
                break;
            swap(arr, index, largest);
            index = largest;
            left =  index*2+1;//新左儿子
        }
    }
    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
```

### 小根堆的使用
```java
package t2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 3, 6, 5, 1, 2, 7};
        heapSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void smallRootHeap() {
        PriorityQueue<Integer> heap = new PriorityQueue<>();//优先级队列
        heap.add(8);
        heap.add(3);
        heap.add(7);
        heap.add(5);
        heap.add(9);
        heap.add(9);
        heap.add(4);
        heap.add(2);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
```

### 堆排序扩展功能
已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。

