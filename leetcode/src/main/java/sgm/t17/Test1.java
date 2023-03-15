package sgm.t17;

import sgm.entity.TreeNode;

public class Test1 {
    public boolean isSymmetric(TreeNode root) {

        return method1(root.left, root.right);
    }

    public boolean method1(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }
        if (node1.val == node2.val) {
            return method1(node1.left, node2.right) && method1(node1.right, node2.left);
        }
        return false;
    }
}
