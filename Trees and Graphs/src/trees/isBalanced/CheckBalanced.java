package trees.isBalanced;

public class CheckBalanced {



    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);



        if (isBalanced(root)) {
            System.out.println("The given binary tree is balanced.");
        } else {
            System.out.println("The given binary tree is not balanced.");
        }
    }

    private static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private static int checkHeight(TreeNode root) {
        if(root == null)
            return -1;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int diff = leftHeight - rightHeight;
        if(Math.abs(diff) > 1){
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight)+1;

    }
}
