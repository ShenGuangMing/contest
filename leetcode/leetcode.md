# 1.LeetCode
## 两数之和
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
## 两数相加
题目： 2.两数相加

链接：https://leetcode.cn/problems/add-two-numbers/

要求：给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

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
## 无重复字符的最长子串
题目：3. 无重复字符的最长子串

链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/

要求：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

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

## 寻找两个正序数组的中位数
题目：寻找两个正序数组的中位数

链接：https://leetcode.cn/problems/median-of-two-sorted-arrays/

要求：给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
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
## 移动零
题目：移动零

链接：https://leetcode.cn/problems/move-zeroes/

要求： 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

注意：请注意 ，必须在不复制数组的情况下原地对数组进行操作。

```java
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {1, 0, 3, 0, 12};
        main.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num!=0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
```
## 合并两个有序数组
题目：合并两个有序数组

链接：https://leetcode.cn/problems/merge-sorted-array/

要求：给你两个按 非递减顺序 排列的整数数组nums1 和 nums2 另有两个整数 m 和 n ，分别表示 nums1 和 nums2
中的元素数目。请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

**code:**
```java
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        main.merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int aPoint = m-1;//nums1尾指针
        int bPoint = n-1;//nums2尾指针
        int putPoint = nums1.length-1;
        for (;putPoint >= 0; putPoint--) {
            if (aPoint >= 0 && (bPoint < 0 || nums1[aPoint] > nums2[bPoint])) {
                nums1[putPoint] = nums1[aPoint--];
            }else if(bPoint >= 0){
                nums1[putPoint] = nums2[bPoint--];
            }
        }
    }
}
```

## 找到数组中消失的数
题目：找到数组中消失的数

链接：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/

要求：给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

**code:**
```java
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        int[] arr = {10,2,5,10,9,1,1,4,3,7};
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(main.findDisappearedNumbers1(arr));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            nums[(num-1) % len]+= len;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len)
                list.add(i+1);
        }
        return list;
    }
    public List<Integer> findDisappearedNumbers1(int[] nums) {//速度慢
        for (int num : nums) {
            if (num < 0)
                num*=-1;
            if (nums[num-1]> 0)
                nums[num-1] *= -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >  0)
                list.add(i+1);
        }
        return list;
    }
}
```

## 合并两个有序链表
题目：合并两个有序链表

链接：https://leetcode.cn/problems/merge-two-sorted-lists/

要求：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

**code:**
```java
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        Main main = new Main();
        ListNode res = main.mergeTwoLists2(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();//新的头节点用于返回
        ListNode tem = res;//工作节点指针
        while (list1 != null || list2 != null) {
            if (list1!=null && (list2 == null || list1.val < list2.val)) {
                tem.next = list1;
                list1=list1.next;
            }else {
                tem.next = list2;
                list2 = list2.next;
            }
            tem = tem.next;//工作节点指针后移
        }
        return res.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        //结束条件
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists1(list1, list2.next);
        return list2;
    }
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode tem = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tem.next = list1;
                list1 = list1.next;
            }else {
                tem.next = list2;
                list2 = list2.next;
            }
            tem = tem.next;
        }
        if (list1 == null)
            tem.next = list2;
        if (list2 == null)
            tem.next = list1;
        return res.next;
    }
}
```

## 删除有序链表中的重复元素
题目：删除有序链表中的重复元素

链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/

要求：给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。

**code:**
```java
public class Main {
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null)
            return head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {//当前节点的值等于下一个节点的值
                curr.next = curr.next.next;
            }else
                curr = curr.next;
        }
        return head;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
```

## 删除链表中的重复元素||
题目：删除链表中重复的元素||

链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/

要求：给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。

**工具类**
```java
public class ListNodeUtil {
    public static Scanner scanner = new Scanner(System.in);
    public static ListNode initLinked() {
        ListNode head = new ListNode();
        ListNode cur = head;
        int len = scanner.nextInt();
        for (int i = 0; i < len; i++) {
            int n = scanner.nextInt();
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return head.next;
    }
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
```
**code:**
```java
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = LinkedList.initLinked();
        ListNode listNode = main.deleteDuplicates(head);
        LinkedList.printLinkedList(listNode);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode res = new ListNode();
        ListNode temp = res;
        ListNode cur = head;
        int prev = Integer.MIN_VALUE;
        while (cur != null) {
            if (cur.val == prev) {
                cur = cur.next;
                continue;
            }
            if (cur.next != null && cur.val == cur.next.val) {
                prev = cur.val;
                cur = cur.next;
                continue;
            }
            temp.next = new ListNode(cur.val);
            temp = temp.next;
            cur = cur.next;
        }
        return res.next;
    }
}
```

## 环形链表
题目：环形链表

链接：https://leetcode.cn/problems/linked-list-cycle/

要求：给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。
仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 true 。 否则，返回 false 。

**解题思路**
- 使用map结构来解决(containKey()方法)
- 使用快慢指针，如果存在环，那一定会相遇（速度不同，定相遇）

**code:**
```java
public class Main {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slowP = head;
        ListNode fastP = head;
        //在一个环中，速度不同一定会相遇
        while (fastP.next != null && fastP.next.next != null) {//结束以快指针为准，它不为null，慢指针也不会为null
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP)
                return true;
        }
        return false;
    }
}
```
## 环形链表
题目：环形链表||

链接：https://leetcode.cn/problems/linked-list-cycle-ii/

要求：给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

不允许修改 链表。

**思路**

![](../images/leetcode-142环形链表2.png)

设如果存在环形链表，他的结构为：a+b+c
- a：环前节点数
- b：相遇节点数（从a后开始算）
- c：环剩余部分（从b后开始算） 

步数关系 s= a+b   f=2s=2(a+b)=a+n(b+c)+b
        
    f=a+n圈(b+c)+b(重合点)
得：a = c + (n-1)(b+c)

**code:**
```java
public class Main {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head, slow = head;
        boolean isMeet = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { //如果相遇设置相遇标识
                isMeet = true;
                break;
            }
        }
        if (isMeet) {
            fast = head;//fast从头开始
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }
}
```
## 反转链表
题目：反转链表

链接：https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/

要求：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

**code**
```java
public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        ListNode listNode = NodeUtil.initLinked();
        ListNode reverse = t.reverseList(listNode);
        NodeUtil.printLinkedList(reverse);
    }
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode n1 = head;
        ListNode n2 = n1.next;
        ListNode n3 = null;
        n1.next = null;//将头节点下个只想null
        while (n2 != null) {
            n3 = n2.next;//最后一个后移
            n2.next = n1;//当前节点向前指
            n1 = n2;//第一个节点等于当前节点
            n2 = n3;
        }
        return n1;
    }
}
```

##  缺失的第一个数
题目：缺失的第一个正数

链接：https://leetcode.cn/problems/first-missing-positive/

要求：给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。

### code
```java
public class Test4 {

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums) {
        boolean isOne = false;//1是否存在
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            if (nums[i] == 1){//存在就改变标识
                isOne = true;
            } else if (nums[i] <= 0) {
                nums[i] = 1;//小于1的都修改为1
            }
        }
        if (!isOne)
            return 1;//缺少1就直接返回了
        for (int i = 0; i < N; i++) {
            int index= Math.abs(nums[i]);
            if (index <= N && index >=1) {//index是否在范围内
                nums[index-1] = -Math.abs(nums[index-1]);//记得abs
            }
        }
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) {//返回第一个正数所在的下标就行
                return i+1;
            }
        }
        return N+1;//都存在，就返回最大值的下一个
    }
}
```

## 下一个排序
题目：下一个排序

链接：https://leetcode.cn/problems/first-missing-positive/

要求;整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。

例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。

必须 原地 修改，只允许使用额外常数空间。
### 思路
见链接中官方的解释
### code
```java
public class Test3 {
    public static void main(String[] args) {
        int[] arr = {5,1,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while (i-1>=0 && nums[i] <= nums[i-1]) {
            i--;
        }
        if (i != 0) {
            int j = nums.length-1;
            while (j>i-1&&nums[j]<=nums[i-1]) {
                j--;
            }
            swap(nums, i-1, j);
            reverse(nums, i);
        }else {
            reverse(nums, 0);
        }
    }
    public static void reverse(int[] arr, int begin) {
        int j = arr.length-1;
        while (begin < j) {
            swap(arr, begin++,j--);
        }
    }

    public static void swap(int[] arr, int l, int r) {
        if (l == r|| arr[l] == arr[r])
            return;
        arr[l] = arr[l] ^ arr[r];
        arr[r] = arr[l] ^ arr[r];
        arr[l] = arr[l] ^ arr[r];
    }
}
```

## 盛最多水的容器
题目：盛最多水的容器

链接：https://leetcode.cn/problems/container-with-most-water/

要求：给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。

### coed
```java
public class Test2 {
    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while (l<r) {
            int min = Math.min(height[l], height[r]);
            max = Math.max(max, min*(r-l));
            if (height[l] < height[r]) {//哪里小移动哪
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
```

## 外观数列
题目：外观数列

链接：https://leetcode.cn/problems/count-and-say/

要求：给定一个正整数 n ，输出外观数列的第 n 项。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

你可以将其视作是由递归公式定义的数字字符串序列：

countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
第一项是数字 1
描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"

### code
```java
public class Test1 {
    public static void main(String[] args) {
        System.out.println(countAndSay1(4));
    }
    public static String countAndSay1(int n) {
        if (n == 1)
            return "1";
        return process1(countAndSay1(n-1));
    }

    public static String process1(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int len = cs.length;
        char prev = cs[0];
        for (int i = 1; i < len; i++) {
            if (cs[i] == prev) {
                count++;
            }else {
                sb.append(count).append(prev);
                prev = cs[i];
                count = 1;
            }
        }
        sb.append(count).append(prev);
        return sb.toString();
    }
    //描述n
    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int m = n%10;
        n/=10;
        while (n!=0) {
            int cur = n%10;
            if (cur == m) {
                count++;
            }else {
                sb.append(m).append(count);
                m = cur;
                count = 1;
            }
            n/=10;
        }
        sb.append(m).append(count);
        return sb.reverse().toString();
    }
}
```

## 字符轮转
题目：字符串轮转

链接：https://leetcode.cn/problems/string-rotation-lcci/

要求：字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。


s1：waterbottlewaterbottle   s2：erbottlewat
> 没读懂题意，记住解题模板
### code:
```java
public class Test8 {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1+s1).contains(s2);
    }
}
```

## 跳跃游戏||
题目：跳跃游戏||

链接：https://leetcode.cn/problems/jump-game-ii/

要求：给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。

### code
```java
public class Test7 {
    public static void main(String[] args) {
        int[] nums = {1,2,0,1,1,4,0,0,0};
        Test7 t = new Test7();
        System.out.println(t.jump(nums));
        System.out.println(jump2(nums));
        System.out.println(jump3(nums));

    }
    // copy的别人的最优解
    public int jump(int[] nums) {
        int end = 0;
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {//i从头跳到未
            max = Math.max(max, i + nums[i]);//跟新每一次能跳到最大位置
            if (i == end) {//如果i等于了最大位置 就把end更新并且res++;
                end = max;
                res++;
            }
        }
        return res;
    }

    //dp
    public static int jump3(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[N-1] = 0;//边界设值0，因为到终点不需要走了
        for (int i = N-2; i>=0; i--) {
            int min = 10000;//设置的最小步数
            for (int j = 0; j < nums[i]; j++) {//能走的范围
                int index = i+j+1;//这一步能走的下标能到哪里
                int n = 0;
                if (index < N-1) {//这一步走不到终点
                    n = 1+dp[index];//
                }else {
                    min = 1;//能走到终点就只需要一步了
                    break;
                }
                min = Math.min(min, n);//这一步能走的范围中，花的最小步数
            }
            dp[i] = min;
        }
        return dp[0];
    }
    //递归加傻缓存
    public static int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        int res = process2(nums, 0, dp);
        System.out.println(Arrays.toString(dp));
        return res;
    }
    public static int process2(int[] nums, int cur, int[] dp) {
        if (cur >= nums.length-1) {
            dp[nums.length-1] = 0;
            return 0;
        }
        if (dp[cur] != 0) {
            return dp[cur];
        }
        int min = 100;
        int n = 0;
        for (int i = 0; i < nums[cur]; i++) {
            n = 1+process2(nums, cur+(i+1), dp);
            min = Math.min(n, min);
        }
        dp[cur] = min;
        return min;
    }
    //递归
    public static int jump1(int[] nums) {
        return process1(nums, 0);
    }

    public static int process1(int[] nums,int cur) {
        if (cur >= nums.length-1)
            return 0;
        int min = Integer.MAX_VALUE;
        int n = 0;
        for (int i = 0; i < nums[cur]; i++) {
            n = 1+process1(nums, cur+(i+1));
            min = Math.min(n, min);
        }
        return min;
    }
}
```
## 括号生成
题目：括号生成

链接：https://leetcode.cn/problems/generate-parentheses/

要求：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

### code
```java
public class Test5 {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        process1(n, n, "", res);
        return res;
    }
    /*
    copy别人的优解，感觉是贪心
     */
    public static void process1(int l, int r, String cur, List<String> list ) {
        if (l == 0 && r == 0) {
            list.add(cur);
        }
        if (l > r) {
            return;
        }
        if (l > 0) {
            process1(l-1, r, cur+'(', list);
        }
        if (r > 0) {
            process1(l, r-1, cur+')', list);
        }
    }
}
```

## 重新格式化电话号
题目：重新格式化电话号码

链接：https://leetcode.cn/problems/reformat-phone-number/

要求：给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。

请你按下述方式重新格式化电话号码。

首先，删除 所有的空格和破折号。
其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
2 个数字：单个含 2 个数字的块。
3 个数字：单个含 3 个数字的块。
4 个数字：两个分别含 2 个数字的块。
最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。

返回格式化后的电话号码。
### code:
```java
public class Test4 {
    public static void main(String[] args) {
        Test4 t = new Test4();
        System.out.println(t.reformatNumber("-123-123123"));
    }
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (char c : number.toCharArray()) {
            int n = c - '0';
            if (n>=0 && n <=9) {
                sb.append(n);
            }
        }
        int index = 0;
        int len = sb.length();
        StringBuilder ans = new StringBuilder();
        while (len > 0) {
            if (len > 4) {
                ans.append(sb.substring(index, index + 3)).append("-");
                len-=3;
                index+=3;
            }else {
                if (len == 4) {
                    ans.append(sb.substring(index, index + 2)).append("-").append(sb.substring(index+2, index+4));
                }else {
                    ans.append(sb.substring(index, index+len));
                }
                return ans.toString();
            }
        }
        return ans.toString();
    }
}
```
## 最长有效括号
题目：最长有效括号

链接：https://leetcode.cn/problems/longest-valid-parentheses/

要求：给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

解题核心是，）一定是与自己最近的（（没有结合的）结合的

### code
```java
public class Test3 {
    public static int longestValidParentheses2(String s) {
        if (s.length() <= 1)
            return 0;
        char[] c = s.toCharArray();
        int[] dp = new int[c.length];
        dp[1] = (c[0] == '(' && c[1] == ')')? 2 : 0;//如果前两个是()将dp[1]设置为2
        int max = dp[1];//当前最大长度为dp[1]
        for (int i = 2; i<c.length; i++) {
            if (c[i] == '(') {//遇到“(”对应下标的dp设置为0
                dp[i] = 0;
            }else {
                //下面的条件自己画图：())、())()、()(())
                if (i-dp[i-1]-1<0 || c[i-dp[i-1]-1] == ')'){
                    dp[i] = 0;
                }else if (i-dp[i-1]-1 >=0) {
                    if (i-dp[i-1]-2 >= 0) {
                        dp[i] = dp[i-dp[i-1]-2] + 2 + dp[i-1];
                    }else {
                        dp[i] = dp[i-1]+2;
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static int longestValidParentheses1(String s) {
        if(s.length() <= 1)     return 0;
        char[] chars = s.toCharArray();
        //dp[i] means from s[0...i] 有效括号, 包含s[i]
        int[] dp = new int[chars.length];
        dp[1] = chars[0] == '(' && chars[1] == ')' ? 2 : 0;
        int max = dp[1];
        for(int i = 2; i < chars.length; i++)
        {
            if(chars[i] == '(')     dp[i] = 0;
            else
            {
                if(chars[i-1] == '(')
                    dp[i] = dp[i-2] + 2;

                else
                {
                    if(i - dp[i-1] - 1 < 0 || chars[i - dp[i-1] -1] == ')')
                        dp[i] = 0;
                    else
                        dp[i] = i - dp[i-1] - 1 >= 1 ?  2 + dp[i-1] + dp[i - dp[i-1] - 2]: 2 + dp[i-1];
                }
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses1(s));
        System.out.println(longestValidParentheses2(s));
    }
}
```

## 零矩阵
题目：零矩阵

链接：https://leetcode.cn/problems/zero-matrix-lcci/

要求：编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
### code
```java
public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner scanner = new Scanner(System.in);
        int[][] arr = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
        t.setZeroes(arr);
        ArrayUtil.print2Arr(arr, 3, 3);
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j< matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    col.add(j);
                    row.add(i);
                }
            }
        }
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (col.contains(j) || row.contains(i)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        boolean[] col = new boolean[matrix[0].length];
        boolean[] row = new boolean[matrix.length];
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j< matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    col[j] = row[i] = true;
                }
            }
        }
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (col[j] || row[i]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
```
## 判定是否互为字符重排
题目：判定是否互为字符重排

链接：https://leetcode.cn/problems/check-permutation-lcci/

要求：给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

### code
```java
public class Test5 {
    public static void main(String[] args) {

    }
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int sum1 = Integer.MIN_VALUE;
        int sum2 = 0;
        int sum3 = Integer.MIN_VALUE;
        int sum4 = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum1 += s1.charAt(i);
            sum2 ^= s1.charAt(i);
            sum3 += s2.charAt(i);
            sum4 ^= s2.charAt(i);

        }
        return sum1 == sum3 && sum2 == sum4;
    }
}
```

## 链表中倒数第k个节点
题目：链表中倒数第k个节点

链接：https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/

要求：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
### code
```java
public class Test6 {
    public static void main(String[] args) {
        Test6 t = new Test6();
        ListNode head = NodeUtil.initLinked();

        ListNode kthFromEnd = t.getKthFromEnd(head, 2);
        NodeUtil.printLinkedList(kthFromEnd);
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null) {
            if (k == 0) {
                slow = slow.next;
            } else {
                k--;
            }
            fast = fast.next;
        }
        return slow;
    }
}
```

## 第K个数
题目：第K个数

链接：https://leetcode.cn/problems/get-kth-magic-number-lcci/

要求：有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，
而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
### code
```java
public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        System.out.println(t.getKthMagicNumber(8));
    }
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k+1];
        dp[1] = 1;
        int p3 = 1,p5=1,p7=1;
        for (int i = 2; i<= k; i++) {
            int num3=dp[p3]*3,num5=dp[p5]*5,num7=dp[p7]*7;
            dp[i] = Math.min(num3, Math.min(num5, num7));
            if (num3 == dp[i])
                p3++;
            if (num5 == dp[i])
                p5++;
            if (num7 == dp[i])
                p7++;
        }
        return dp[k];
    }
}
```