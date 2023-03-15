package sgm.t18;

import sgm.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* title：94. 二叉树的中序遍历
* link：https://leetcode.cn/problems/binary-tree-inorder-traversal/
* */
public class Main {


    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        process1(root, list);
        return list;
    }

    public void process1(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        process1(root.left, list);
        //把当前节点添加到list集合
        list.add(root.val);
        process1(root.right, list);
    }
    public void process2(TreeNode root, List<Integer> list) {
        //申请一个栈空间
        Stack<TreeNode> stack = new Stack<>();
        //
        TreeNode p = root;
        while(p != null || !stack.empty()) {
            while(p != null) {
                stack.add(p);
                p = p.left;
            }
            //p 一定为null了，需要从栈中拿出来
            if (!stack.empty()) {
                p = stack.pop();
                list.add(p.val);
            }
            if (p != null) {
                p = p.right;
            }
        }
    }


}
