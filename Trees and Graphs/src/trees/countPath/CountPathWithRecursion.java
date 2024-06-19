package trees.countPath;

import trees.model.TreeNode;


public class CountPathWithRecursion {

    public static int k_path_sum(TreeNode node, int k) {
        if(node == null)
            return 0;
        int count = countAllPath(node, 0, k);
        int leftCt = k_path_sum(node.left, k);
        int rightCt = k_path_sum(node.right, k);
        return count + leftCt + rightCt;
    }

    private static int countAllPath(TreeNode node, int sum, int k) {
        if(node == null)
            return 0;
        sum += node.data;
        int ct = 0;
        if(sum == k)
            ct++;
        int leftCt = countAllPath(node.left, sum, k);
        int rightCt = countAllPath(node.right, sum, k);
        return ct+leftCt+rightCt;
    }
}
