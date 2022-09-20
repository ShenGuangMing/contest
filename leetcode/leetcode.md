# 1.LeetCode
## 1.1两数之和
给定一个整数数组nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

[链接网址 ctrl + 鼠标左键](https://leetcode.cn/problems/two-sum/)
### 解题
```java
public class Main {
    //主方法test
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{3,2,4};
        for (int i : main.twoSum(nums, 6)) {
            System.out.println(i);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //map中是否有 target - nums[i]的值，有就结束返回
            if (map.containsKey(target-nums[i]))
                //i是本次循环的数组下标，mao.get()的结果是（target - nums[i]）的下标
                return new int[]{i, map.get(target-nums[i])};
            //这样添加还有去重的作用
            map.put(nums[i], i);
        }
        return null;
    }
}
```
## 1.2两数相加
题名： 2.两数相加

链接：https://leetcode.cn/problems/add-two-numbers/

题目：给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0开头。

思路：不难所以见代码
### 解题
```java
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode l1 = new ListNode(9);
        ListNode current = l1;
        for (int i = 0; i < 1; i++) {
            current.next = new ListNode(9);
            current = current.next;
        }
        ListNode l2 = new ListNode(9);
        current = l2;
        for (int i = 0; i < 1; i++) {
            current.next = new ListNode(9);
            current = current.next;
        }
        ListNode res = main.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val +" ");
            res = res.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        int cry = 0;//进位
        int sum = cry;
        while (l1!=null || l2!=null || cry!=0 ) {
            sum = cry;
            if (l1 !=null) {
                sum += l1.val;//把节点中的数取出
                l1 = l1.next;
            }
            if (l2 !=null) {
                sum += l2.val;//把节点中的数取出
                l2 = l2.next;
            }
            current.next = new ListNode(sum%10);
            current = current.next;
            cry = sum/10;
        }
        return head.next;
    }
}
```
## 1.3 无重复字符的最长子串
题名：3. 无重复字符的最长子串

链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/

题目：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

### 解题:
```java
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        //如果s长度为空直接返回
        if (s.length() == 0) return 0;
        //定义变量
        int left = 0;//无重复字符的起点
        int max = 0;//最长无重复字符数
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);//获取字符串第i个位置的字符
            if (map.containsKey(c)) {
                /*
                    假如s = abccb
                    一直到第一个c left = 0，第二个c的时候 left = get(c)+1=3
                    执行到第二个b前 left = 3，然后 left = max(left, get(c))=max(3, 2)
                 */
                left = Math.max(left, map.get(c)+1);//修改起点（滑动）
            }
            map.put(c, i);//添加进map
            max = Math.max(max, i-left+1);
        }
        return max;
    }
 }
```

## 1.4
题名：4. 寻找两个正序数组的中位数

链接：https://leetcode.cn/problems/median-of-two-sorted-arrays/

题目：给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
### 解题思路
其实我们可以用两个指针从小到大依次向后移

例如我有两个数组 nums1=[2, 3, 5] nums2=[1, 4, 7, 9] 结果为[1, 2, 3, 4, 5, 7, 9]答案显然是4

令 i 是num1的下标；j 是num2的下标；left为左值，right为right，left和right初值为-1

| 循环次数 | nums1[i] | nums2[j] | 大小关系 | left(=right) | right(=小的) | 操作(小的数组下标++) |
| -------- | -------- | -------- | -------- | ------------ | ------------ | -------------------- |
| 0        | 2        | 1        | 2 > 1    | -1           | 1            | j++                  |
| 1        | 2        | 4        | 2 < 4    | 1            | 2            | i++                  |
| 2        | 3        | 4        | 3 < 4    | 2            | 3            | i++                  |
| 3        | 5        | 4        | 5 > 4    | 3            | 4            | 结束 3 == (3+4)/2    |

代码：
```java
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findMedianSortedArrays(new int[]{2, 3, 5}, new int[]{1, 4, 7, 9}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //数组总长度
        int len = nums1.length + nums2.length;
        //指针
        int left = -1;
        int right = -1;
        int aStart = 0;//nums1数组的下标索引
        int bStart = 0;//nums2数组的下标索引
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart<nums1.length && (bStart >= nums2.length || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        return len%2 == 0? (left+right)/2.0 : right;
    }
}
```


