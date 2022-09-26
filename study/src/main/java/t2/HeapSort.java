package t2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 6, 5, 7, 6};
        sortedArrDistanceLessK(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortedArrDistanceLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(k, arr.length); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++, i++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
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

    public static void heapSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = 0;
        while (heapSize < arr.length) {
            heapInsert(arr, heapSize++);
        }
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
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
