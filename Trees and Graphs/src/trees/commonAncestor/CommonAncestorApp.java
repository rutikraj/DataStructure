package trees.commonAncestor;

import trees.model.TreeNode;

//4.8
public class CommonAncestorApp {

    public static void main(String []args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5) = "
                + findLCA(tree,4, 5));
        System.out.println("LCA(4, 6) = "
                + findLCA(tree, 4, 6));
        System.out.println("LCA(3, 4) = "
                + findLCA(tree,3, 4));
        System.out.println("LCA(2, 4) = "
                + findLCA(tree,2, 4));
    }

    private static String findLCA(TreeNode node, int val1, int val2) {
        if(!cover(node, val1) || !cover(node, val2)){
            return null;
        }
        int data =  findLCAHelper(node, val1, val2);
        return String.valueOf(data);
    }

    private static int findLCAHelper(TreeNode node, int val1, int val2) {
        if(node == null || node.data == val1 || node.data == val2){
            return node.data;
        }
        boolean val1OnLeft = cover(node.left, val1);
        boolean val2OnLeft = cover(node.left, val2);
        if(val1OnLeft != val2OnLeft)
            return node.data;
        return val1OnLeft ? findLCAHelper(node.left, val1, val2) : findLCAHelper(node.right, val1, val2);
    }

    private static boolean cover(TreeNode node, int val) {
        if(node == null)
            return false;
        if(node.data == val)
            return true;
        return (cover(node.left, val) || cover(node.right, val));

    }


}
