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
        int[] arr = {1, 3, 5, 7, 3, 7, 1, 7};
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
        int onlyOne = 0;//eor`
        for (int curr : arr) {
            if ((curr & rightOne) != 0) {
                onlyOne ^= curr;
            }
        }
        System.out.println(onlyOne + " " + (onlyOne ^ eor));
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
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, i, i + 1);
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
            for (int j = i + 1; j < arr.length; j++) { //与后面的数据比较找最小的下标
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
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
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {//当前的数比它前一个数小，就进行交换
                swap(arr, j + 1, j);
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
        System.out.println(dichotomyRecursion(arr, 0, arr.length - 1, 48));
    }

    //循环二分
    public static int dichotomyCycle(int[] arr, int target) {
        int right = arr.length - 1;
        int left = 0;
        while (left <= right) {
            int curr = (left + right) / 2;
            if (arr[curr] == target) {
                return curr;
            } else if (arr[curr] < target) {
                left = curr + 1;
            } else {
                right = curr - 1;
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
        if (arr[curr] == target) return curr;
        else if (arr[curr] < target) return dichotomyRecursion(arr, curr + 1, right, target);
        else return dichotomyRecursion(arr, left, curr - 1, target);
    }
}
```

## 二分-查找大于等于最左侧

在一个有序数组中，找>=某个数最左则的位置

```java
public class Find {
    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 7, 11, 11, 11, 12, 21, 21, 32, 33, 33, 40, 40, 40, 41};
        int i = farLeftCycle(arr, 36);
        if (i != -1) {
            System.out.println(i + " : " + arr[i]);
        } else {
            System.out.println("null");
        }
    }

    //循环实现
    public static int farLeftCycle(int[] arr, int target) {
        int right = arr.length - 1;
        int left = 0;
        int curr = (left + right) / 2;
        while (left < right) {
            if (arr[curr] < target) {
                left = curr + 1;
            } else {
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
        } else if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int right = arr.length - 1;
        int left = 0;
        while (left < right) {
            int curr = (left + right) / 2;
            if (curr - 1 >= 0 && arr[curr] > arr[curr - 1]) {
                right = curr;
            } else if (curr + 1 < arr.length && arr[curr] > arr[curr + 1]) {
                left = curr;
            } else {
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
        int mid = l + ((r - l) >> 1);
        int leftMax = findMax(arr, l, mid);
        int rightMax = findMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}
```

## 归并排序

```java
public class Sort {

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        //申请help空间
        int[] help = new int[r - l + 1];
        int index = 0;
        int aPoint = l;
        int bPoint = mid + 1;
        while (aPoint <= mid && bPoint <= r) {
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
        int mid = l + ((r - l) >> 1);
        int sum = 0;
        sum += smallAdd(arr, l, mid);//左侧排好序求出的小和
        sum += smallAdd(arr, mid + 1, r);//右侧排好序求出小和
        sum += merger2(arr, l, mid, r);//左侧和右侧merge起来求小和
        return sum;
    }

    private static int merger2(int[] arr, int l, int mid, int r) {
        //申请help空间
        int[] help = new int[r - l + 1];
        int index = 0;
        int sum = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] < arr[p2]) {
                sum += (r - p2 + 1) * arr[p1];
                help[index++] = arr[p1++];
            } else {//左大或等都是有指针移动
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
        int len = arr.length - 1;//数组长度
        int left = -1;//左边界
        for (; index <= len; ++index) {
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

给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。要求额外空间复杂度0(
1)，时间复杂度0(N)

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
            } else if (arr[index] > target) {
                //index不能向后移，因为交换中的arr[--right]还没有看
                swap(arr, index, --right);
            } else {
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
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            //随机一个作为分界值放到最后
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(arr, left, right);
            quickSort2(arr, left, p[0]);
            quickSort2(arr, p[1], right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int l = left - 1;//左区
        int r = right;//右区
        int target = arr[right];//给定范围中最后的值
        int index = left;//开始位置
        while (index < r) {//当遍历到右区就停止
            if (arr[index] < target) {
                swap(arr, index++, ++l);
            } else if (arr[index] > target) {
                swap(arr, index, --r);//荷兰国旗问题解释了
            } else {//相等的情况，index向后移
                index++;
            }
        }
        swap(arr, right, r);//和右区第一个交换
        return new int[]{l, r + 1};
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
        while (arr[index] > arr[(index - 1) / 2]) {//这插入的新位置的数是否比我的父节点大
            swap(arr, index, (index - 1) / 2);//大就交换
            index = (index - 1) / 2;//跟新为父节点的位置
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
        int left = index * 2 + 1;//左孩子下标
        while (left < heapSize) {//存在左儿子
            int largest = index * 2 + 1;//假如当前左儿子是最大的
            if (index * 2 + 2 < heapSize) {//存在右儿子
                largest = arr[largest] > arr[left + 1] ? largest : left + 1;//左右儿子大的下标
            }
            largest = arr[largest] > arr[index] ? largest : index;//最大儿子和父节点比
            if (arr[largest] == arr[index])
                break;
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;//新左儿子
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
        while (arr[index] > arr[(index - 1) / 2]) {//这插入的新位置的数是否比我的父节点大
            swap(arr, index, (index - 1) / 2);//大就交换
            index = (index - 1) / 2;//跟新为父节点的位置
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;//左孩子下标
        while (left < heapSize) {//存在左儿子
            int largest = index * 2 + 1;//假如当前左儿子是最大的
            if (left + 1 < heapSize) {//存在右儿子
                largest = arr[largest] > arr[left + 1] ? largest : left + 1;//左右儿子大的下标
            }
            largest = arr[largest] > arr[index] ? largest : index;//最大儿子和父节点比
            if (arr[largest] == arr[index])
                break;
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;//新左儿子
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
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;//左孩子下标
        while (left < heapSize) {//存在左儿子
            int largest = index * 2 + 1;//假如当前左儿子是最大的
            if (left + 1 < heapSize) {//存在右儿子
                largest = arr[largest] > arr[left + 1] ? largest : left + 1;//左右儿子大的下标
            }
            largest = arr[largest] > arr[index] ? largest : index;//最大儿子和父节点比
            if (arr[largest] == arr[index])
                break;
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;//新左儿子
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

# 链表

## 链表反序

### 思路

假如有 1->2->3->4的链表，a=1,b=a.next,c=null,a.next=null 1->null;</br>
c = b.next; c=3;</br>
b.next = a; 2->1;</br>
a = b; a = 2;</br>
b = c; b = 3</br>
c = c.next; c = 4</br>
依次循环即可

### code

```java
public class LinkReverse {
    public static void main(String[] args) {
        ListNode listNode = NodeUtil.initLinked();
        ListNode reverse = reverse(listNode);
        NodeUtil.printLinkedList(reverse);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode n1 = head;
        ListNode n2 = n1.next;
        ListNode n3 = null;
        n1.next = null;//将头节点下个只想null
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        return n1;
    }
}
```

## 判断是否是回文链表

### 思路

**方法一：**

```text
利用栈的特性后进先出，例如有个链表 1->2->2->1->null
先依次入栈：1 2 2 1 （最后的1是栈顶）
再依次出栈和链表的每个节点比较即
```

> 其实利用栈就是将我们的链表倒叙了一下

**方法二：**

```text
利用快慢指针，快指针到末尾，慢指针到中点
我们只需要将慢指针，下一个节点后面的节点入栈，
再将每个节点出栈和链表中的节点比较，不同就不是，直到栈为空
```

**方法三：**

```text
利用快慢指针，快指针到末尾，慢指针到中点
我们只需要将后面的慢指针后面的节点倒叙（记得指向null，这个是后面判断结束的条件）
，然后我们再将反序的链表和头节点开始遍历比较，不同就不是返回
```

```java
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode listNode = NodeUtil.initLinked();
        PalindromeLinkedList p = new PalindromeLinkedList();
        boolean palindrome = p.isPalindrome2(listNode);
        System.out.println(palindrome);
    }

    public boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val)
                return false;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head != null && head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (head != null && !stack.isEmpty()) {
            if (head.val != stack.pop().val)
                return false;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head != null && head.next == null)
            return true;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        ListNode n3 = null;
        n1 = n1.next;
        n2 = n1.next;
        n1.next = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = head;
        while (n1 != null) {
            if (n3.val != n1.val) {
                return false;
            }
            n3 = n3.next;
            n1 = n1.next;
        }
        return true;
    }
}
```

## 链表partition

### 要求：

给定一个链表，和一个数，将链表中，小于这个数，等于这个数，大于这个数分开成三个区域

### 思路：

**方法一：**

```text
创建一个节点数组，再数组中玩partition，结束后再把每个数组中的节点穿起来
```

**方法二：**

```text
创建 小于区头节点和尾节点，等于区头节点和未节点，大于区头节点和尾节点
再将他们串起来，但要注意串法，可能会有那个没有，就会串错
```

### code
```java
public class ListPartition {
    public static void main(String[] args) {
        ListNode head = NodeUtil.initLinked();
        ListNode listNode = listPartiton1(head, 3);
        NodeUtil.printLinkedList(listNode);

    }

    public static ListNode listPartiton(ListNode head, int target) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        cur = head;
        ListNode[] list = new ListNode[len];
        for (int i = 0; i < len; i++) {
            list[i] = cur;
            cur = cur.next;
        }
        int left = -1;
        int right = len;
        int i = 0;
        //Partiton过程
        while (i < right) {
            if (list[i].val < target) {
                swap(list, i++, ++left);
            } else if (list[i].val > target) {
                swap(list, i, --right);
            } else {
                i++;
            }
        }
        cur = list[0];
        head = list[0];
        for (int j = 1; j < len; j++) {
            cur.next = list[j];
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static ListNode listPartiton1(ListNode head, int target) {
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode mH = null;
        ListNode mT = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < target) {
                if (sH == null) {
                    sH = cur;
                    sT = cur;
                } else {
                    sT.next = cur;
                    sT = cur;
                }
            } else if (cur.val == target) {
                if (eH == null) {
                    eH = cur;
                    eT = cur;
                } else {
                    eT.next = cur;
                    eT = cur;
                }
            } else {
                if (mH == null) {
                    mH = cur;
                    mT = cur;
                } else {
                    mT.next = cur;
                    mT = cur;
                }
            }
            cur = cur.next;
        }
        //让每个区域结尾指向空
        if (sT != null)
            sT.next = null;
        if (eT != null)
            eT.next = null;
        if (mT != null)
            mT.next = null;

        //串法一：判断
//        if (sT != null) {
//            if (eT != null) {//小有等有
//                sT.next = eH;
//                if (mT != null)
//                    eT.next = mH;
//            }else {//小有等没有
//                sT.next = mH;
//            }
//            return sH;
//        }else {
//            if (eT != null) {//小无等有
//                eT.next = mH;
//                return eH;
//            }else {//小无等无
//                return mH;
//            }
//        }
        //串法二：
        if (sT != null) {//小于区存在
            sT.next = eH;//小于区尾连上等于区头
            eT = eT == null ? sT : eT;//等于区尾不存在就让小于区的尾作为等于区尾
        }
        if (eT != null) {//存在eT
            eT.next = mH;//连上大于区头
        }
        return sH != null ? sH : (mH != null ? mH : eT);
    }
    
    public static void swap(ListNode[] arr, int i, int j) {
        ListNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```
## 链表相交问题
题目：两个链表可能存在环，也可能不存在环，求两个链表的相交节点
### code
```java
//寻找第一个相交节点
public class FindFirstIntersectionNode {

    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;
        ListNode loop1 = containsLoop(head1);
        ListNode loop2 = containsLoop(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }
    //无环链表寻找相交节点
    public static ListNode noLoop(ListNode aH, ListNode bH) {
        ListNode n1 = aH;
        ListNode n2 = bH;
        while (n1 != n2) {
            n1 = n1 == null ? bH : n1.next;
            n2 = n2 == null ? aH : n2.next;
        }
        return n1;
    }
    //有环的两个相交节点，且入环节点相同，查找第一个相交节点
    public static ListNode hasLoop(ListNode aH, ListNode bH, ListNode target) {
        ListNode n1 = aH;
        ListNode n2 = bH;
        while (n1 != n2) {
            n1 = n1 == target ? bH : n1.next;
            n2 = n2 == target ? aH : n2.next;
        }
        return n1;
    }
    //两个有环节点查找相交节点，相交返回第一个相交节点，如果不相交返回null
    public static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode cur1 = null;
        if (loop1 == loop2) {
            return hasLoop(head1, head2, loop1);
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1) {//转一圈看能不能遇到loop2
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            //没有遇到就退出循环了
            return null;
        }
    }
    //链表中是否存在环
    public static ListNode containsLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean contains = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
```

# 动态规划
## 机器人移动
1-N个数，一个机器人再start（1-N中任意一个）的位置，他走step步到aim的方法有多少种
```java
public class Code1_RobotWalk {
    /**
     *
     * @param N     1-N个数
     * @param step  一共有多少步
     * @param start 开始位置
     * @param aim   目标位置
     * @return 从start走step步数到aim共有所有种方法
     */
    public static int getWays3(int N, int step, int start, int aim) {
        Time.start();
        int[][]dp = new int[N+1][step+1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= step; rest ++) {
            dp[1][rest] = dp[2][rest-1];
            for (int cur = 2; cur<N; cur ++) {
                dp[cur][rest] = dp[cur-1][rest-1] + dp[cur+1][rest-1];
            }
            dp[N][rest] = dp[N-1][rest-1];
        }
        Time.end("getWays3");
        return dp[start][step];
    }

    /**
     *
     * @param N     1-N个数
     * @param step  一共有多少步
     * @param start 开始位置
     * @param aim   目标位置
     * @return 从start走step步数到aim共有所有种方法
     */
    public static int getWays2(int N, int step, int start, int aim) {
        long s = System.nanoTime();
        int[][] dp = new int[N + 1][step + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= step; j++) {
                dp[i][j] = -1;
            }
        }
        long e = System.nanoTime();
        int res = process2(start, step, aim, N, dp);
        System.out.println("getWays2 time: " + (e - s));
        return res;
    }

    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) {//中缓存了
            return dp[cur][rest];
        }
        //没中缓存需要计算
        int ans = 0;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = process2(N - 1, rest - 1, aim, N, dp);
        } else {
            ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);
        }
        dp[cur][rest] = ans;//记缓存
        return ans;
    }

    public static int getWays1(int N, int step, int start, int aim) {
        long s = System.nanoTime();
        int res = process1(start, step, aim, N);
        long e = System.nanoTime();
        System.out.println("getWays1 time: " + (e - s));
        return res;
    }


    /**
     * @param cur  当前位置
     * @param rest 还剩多少步
     * @param aim  目标位置
     * @param N    1-N的数
     * @return 多少种方法
     */
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) { //走完了
            return aim == cur ? 1 : 0;
        }
        int sum = 0;
        if (cur == 1) {//当前在边界位置只能向右走
            sum += process1(2, rest - 1, aim, N);
        } else if (cur == N) {//当前在边界位置只能向左走
            sum += process1(N - 1, rest - 1, aim, N);
        } else {//其他就是两边都可以走
            sum += process1(cur + 1, rest - 1, aim, N);
            sum += process1(cur - 1, rest - 1, aim, N);
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(getWays1(20, 20, 2, 4));
        System.out.println(getWays2(5, 6, 2, 4));
        System.out.println(getWays3(5, 6, 2, 4));
    }
}
```
## 纸牌游戏
两个人每次只能在纸牌的最左或最右拿牌，并且都能看到纸牌的数字，求两个人能拿到的最大数字之和
```java
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
```

## 背包问题
每个物品有自己的重量和价值，问背包能装的最大价值（重量不能超过背包容量）
```java
public class Code3_Knapsack {

    /**
     * 这个dp是从下到上，从左到右进行
     * @param w 重量表
     * @param v 价值表
     * @param space 背包空间
     * @return 背包能装的最大价值
     */
    public static int maxValue3(int[] w, int[] v, int space) {
        int N = v.length;
        int[][] map = new int[N][space + 1];
        for (int s = 0; s< space+1; s++) {//最后一行填充
            if (s >= w[N-1]) {//背包剩余空间大于等于质量就赋值
                map[N-1][s] = v[N-1];
            }
        }
        for (int i = N-2; i>=0; i--) {//其他列，反序填表
            for (int s = 0; s< space+1; s++) {//从做到右
                int p1=0, p2=0; // 一个是装的总价值，一个是不装的总价值
                if (s >= w[i]) {//能装
                    p1 = v[i] + map[i+1][s-w[i]];//本次的价值+下一行背包剩余的空间的价值
                }
                p2 = map[i+1][s];//不装或装不了都会执行这个
                map[i][s] = Math.max(p1, p2);//返回装总价值和不装总价值的最大值
            }
        }
        /*
        这个填表的方式是，从左到右，每列是从下到上，不好理解
        总体就是，我依赖自己是否能装下和自己下一列左边的表数据（包括自己）
        如当前位置是i 他依赖自己是否能装下这个w[i]物品的重量和依赖自己[i+1]下一行，[(space-w[i]) ~ space]这个范围类的列的数据所以这样填表也是对的
         */
//        for (int s = 0; s<space+1 ; s++) {
//            if (s >= w[N-1]) {
//                map[N-1][s] = v[N-1];
//            }
//            for (int i = N-2; i>=0; i--) {
//                int p1=0, p2=0;
//                if (s >= w[i]) {
//                    p1 = v[i] + map[i+1][s-w[i]];
//                }
//                p2 = map[i+1][s];
//                map[i][s] = Math.max(p1, p2);
//            }
//        }
        ArrayUtil.print2Arr(map, N, space+1);
        return map[0][space];//返回最右上角
    }

    public static int maxValue2(int[] wights, int[] values, int space) {
        int[][] map = new int[values.length][space + 1];
        int res = process2(wights, values, 0, space, map);
        ArrayUtil.print2Arr(map, values.length, space + 1);
        return res;
    }

    public static int process2(int[] w, int[] v, int i, int space, int[][] map) {
        if (i == v.length || space < 0) {//背包不能装了，越界返回
            return 0;
        }
        if (map[i][space] != 0) {//中缓存
            return map[i][space];
        }
        int p1 = 0, p2 = 0;
        if (space >= w[i]) {//有足够的空间可以装
            p1 = v[i] + process2(w, v, i + 1, space - w[i], map);//选择装
        }
        //当空间不够，或现在不装
        p2 = process2(w, v, i + 1, space, map);
        int ans = Math.max(p1, p2);
        map[i][space] = ans;
        return ans;
    }


    /**
     * @param wights 重量数组
     * @param values 价值数组
     * @param space  最大容量
     * @return 能装的最大价值
     */
    public static int maxValue1(int[] wights, int[] values, int space) {
        return process1(wights, values, 0, space);
    }

    public static int process1(int[] w, int[] v, int i, int space) {
        if (i == w.length || space < 0) {
            return 0;
        }
        int p1 = 0, p2 = 0;
        if (space >= w[i]) {//有足够的空间可以装
            p1 = v[i] + process1(w, v, i + 1, space - w[i]);//选择装
        }
        p2 = process1(w, v, i + 1, space);//不装和装不下都
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] w = {3, 2,  4, 7, 3, 1, 7};
        int[] v = {5, 6, 3, 19, 12, 4, 2};
//        int[] w = {1, 2, 2, 1, 3, 2, 3, 2, 1, 2};
//        int[] v = {3, 3, 5, 2, 2, 2, 4, 1, 2, 3};
        //5+3+2
        System.out.println(maxValue1(w, v, 15));
        System.out.println(maxValue2(w, v, 15));
        System.out.println(maxValue3(w, v, 15));
    }
}

```