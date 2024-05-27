package trees.isBST;

import trees.model.TreeNode;

public class BSTUtils {
    public static boolean isBST(TreeNode root) {
        return isBST(root, null, null);
    }

    private static boolean isBST(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;
        if((min != null && root.data <= min) || (max != null && root.data > max))
            return false;
        if(!isBST(root.left, min, root.data) || !isBST(root.right, root.data, max))
            return false;
        return true;
    }
}
