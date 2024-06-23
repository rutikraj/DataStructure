package trees.countPath;

import trees.model.TreeNode;
import static trees.countPath.CountPathWithRecursion.k_path_sum;

public class CountPathApp {
    /*
            1
        3       -1
     2   1      4  5
               1 2   6

     */

    public static void main(String []args) {
        TreeNode node5 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        node4.left = node5;
        TreeNode node3 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node2.left = node3;
        node2.right = node4;
        TreeNode node11 = new TreeNode(6);
        TreeNode node10 = new TreeNode(5);
        node10.right = node11;
        TreeNode node9 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        TreeNode node7 = new TreeNode(4);
        node7.left = node8;
        node7.right = node9;
        TreeNode node6 = new TreeNode(-1);
        node6.left = node7;
        node6.right = node10;
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node6;

        int k = 5;
        int paths = k_path_sum(node1, k);
        System.out.println("Paths: " + paths);

        int paths2 = CountPathWithMap.k_path_sum(node1, k);
        System.out.println("Paths way 2: " + paths2);
    }



}
