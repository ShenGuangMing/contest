package sgm.t16;

import sgm.entity.TreeNode;

public class Test3 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( (p==null && q==null) ) {
            return true;
        }
        if ((p!=null && q !=null)){
            return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else {
            return false;
        }
    }

}
