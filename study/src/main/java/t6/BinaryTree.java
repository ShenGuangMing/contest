package t6;

import entity.Node;

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(13);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        System.out.println("\n------------- recursiveFirstOrder -------------");
        recursiveFirstOrder(head);
        System.out.println("\n------------- cycleFirstOrder -------------");
        cycleFirstOrder(head);
        System.out.println();
        System.out.println("\n------------- recursiveInOrder -------------");
        recursiveInOrder(head);
        System.out.println("\n------------- cycleInOrder -------------");
        cycleInOrder(head);
        System.out.println();
        System.out.println("\n------------- recursiveLastOrder -------------");
        recursiveLastOrder(head);
        System.out.println("\n------------- cycleLastOrder -------------");
        cycleLastOrder(head);
        System.out.println("\n------------- 宽度优先 -------------");
        widthPrint(head);
        System.out.println("\n------------- 最大宽度层数 -------------");
        System.out.println(getWidthMaxLevel(head));
        System.out.println("\n------------- 最大宽度节点数 -------------");
        System.out.println(getWidthMaxNodeNum(head));
    }

    public static void widthPrint(Node head) {
        if (head == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.val + "  ");
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }
    public static int getWidthMaxNodeNum(Node head) {
        if (head == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Map<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);//第一个节点在第一层
        Node cur = null;
        int curLevel = 1;//当前统计层
        int curLevelNums = 0;//想统计的层中节点数
        int max = -1;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);//当前节点的层数
//            System.out.println("节点："+cur.val + "  层：" + curNodeLevel);
            if (curLevel == curNodeLevel) {//当前统计的层数和节点的层数相同
                curLevelNums++;
//                System.out.println("相同curLevelNums: "+curLevelNums +"max："+ max + "  层：" + curLevel);
//                System.out.println();
            }else {//不相同
                max = Math.max(max, curLevelNums);//结算统计
                curLevelNums = 1;
                curLevel++;//统计层数++
//                System.out.println("不相同curLevelNums: "+curLevelNums +"max："+ max + "  层：" + curLevel);
//                System.out.println();
            }
            if (cur.left != null){
                levelMap.put(cur.left, curNodeLevel+1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel +1);
                queue.add(cur.right);
            }
        }
        //结束在统计一次，因为结束没有下一层了，少了一次统计
        max = Math.max(max, curLevelNums);
        return max;
    }

    public static int getWidthMaxLevel(Node head) {
        if (head == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Map<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);//第一个节点在第一层
        Node cur = null;
        int curLevel = 1;//当前统计层
        int curLevelNums = 0;//想统计的层中节点数
        int max = -1;
        int maxLevel = 1;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);//当前节点的层数
            if (curLevel == curNodeLevel) {//当前统计的层数和节点的层数相同
                curLevelNums++;
            }else {//不相同
                if (curLevelNums > max) {
                    max = curLevelNums;
                    maxLevel = curLevel;
                }
                curLevelNums = 1;//新层的第一个数也要算
                curLevel++;//下一层
            }
            if (cur.left != null){
                levelMap.put(cur.left, curNodeLevel+1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel+1);
                queue.add(cur.right);
            }
        }
        if (curLevelNums > max) {//最后还需要再统计一次
            maxLevel = curLevel;
        }
        return maxLevel;
    }

        public static void recursiveFirstOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val+"  ");
        recursiveFirstOrder(head.left);
        recursiveFirstOrder(head.right);
    }
    public static void cycleFirstOrder(Node head) {
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node cur = head;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.print(cur.val+"  ");
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public static void recursiveInOrder(Node head) {
        if (head == null) {
            return;
        }
        recursiveInOrder(head.left);
        System.out.print(head.val+"  ");
        recursiveInOrder(head.right);
    }
    public static void cycleInOrder(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.val+"  ");
                    head = head.right;
                }
            }
        }

    }

    public static void recursiveLastOrder(Node head) {
        if (head == null) {
            return;
        }
        recursiveLastOrder(head.left);
        recursiveLastOrder(head.right);
        System.out.print(head.val+"  ");
    }
    public static void cycleLastOrder(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + "  ");
            }
        }
    }

}
