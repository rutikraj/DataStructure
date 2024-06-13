package trees.subtree;

import trees.model.TreeNode;

import java.util.Scanner;

public class SubTreeApp {

    public static void main(String []args){
        TreeNode tree = new TreeNode(26);

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(3);
        tree.left = new TreeNode(10);
        tree.left.left = new TreeNode(4);
        tree.left.left.right = new TreeNode(30);
        tree.left.right = new TreeNode(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        TreeNode tree2 = new TreeNode(10);
        tree2.right = new TreeNode(6);
        tree2.left = new TreeNode(4);
        tree2.left.right = new TreeNode(30);

        if (isSubtree(tree, tree2))
            System.out.println(
                    "Tree 2 is subtree of Tree 1 ");
        else
            System.out.println(
                    "Tree 2 is not a subtree of Tree 1");

        if (isSubtree2(tree, tree2))
            System.out.println(
                    "Tree 2 is subtree of Tree 1 ");
        else
            System.out.println(
                    "Tree 2 is not a subtree of Tree 1");
    }



    //Approach 1
    private static boolean isSubtree(TreeNode tree, TreeNode tree2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        setOrder(tree, str1);
        setOrder(tree2, str2);
        return str1.indexOf(str2.toString()) != -1;
    }

    private static void setOrder(TreeNode tree, StringBuilder str1) {
        if(tree == null){
            str1.append("X");
            return;
        }
        str1.append(tree.data + " ");
        setOrder(tree.left, str1);
        setOrder(tree.right, str1);
    }


    //Apprach2

    private static boolean isSubtree2(TreeNode tree, TreeNode tree2) {
        if(tree2 == null)
            return true;
        if(tree == null)
            return false;
        if(tree.data == tree2.data && allMatch(tree, tree2)){
            return true;
        }
        return isSubtree(tree.right, tree2) || isSubtree(tree.left, tree2);
    }

    private static boolean allMatch(TreeNode tree, TreeNode tree2) {
        if(tree == null && tree2 == null)
            return true;
        if(tree == null || tree2 == null)
            return false;
        if(tree.data != tree2.data)
            return false;
        return allMatch(tree.left, tree2.left) && allMatch(tree.right, tree2.right);
    }
}
