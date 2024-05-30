package trees.successor;

import trees.model.TreeNode;

public class InorderSuccApp {

    public static void main(String []args){
        TreeNode root = null, temp, succ, min;

        // creating the tree given in the above diagram
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);
        temp = root.left.right.right;


        inorderPrint(root);

        // Function Call
        succ = inOrderSuccessor(temp);
        if (succ != null)
            System.out.printf(
                    "\n Inorder Successor of %d is %d ",
                    temp.data, succ.data);
        else
            System.out.printf("\n Inorder Successor doesn't exit");
    }

    private static void inorderPrint(TreeNode root) {
        if(root == null)
            return;
        inorderPrint(root.left);
        System.out.print(root.data +" ");
        inorderPrint(root.right);
    }

    private static TreeNode insert(TreeNode node, int num) {
        if(node == null){
            return new TreeNode(num);
        }
        if(num <= node.data){
            TreeNode childeNode = insert(node.left, num);
            node.left = childeNode;
            childeNode.parent = node;
        }else{
            TreeNode childeNode = insert(node.right, num);
            node.right = childeNode;
            childeNode.parent = node;
        }
        return node;
    }

    private static TreeNode inOrderSuccessor(TreeNode root) {
        if(root != null && root.right != null){
            return leftMostNode(root.right);
        }
        TreeNode curr = root;
        TreeNode parent = curr.parent;
        while(parent != null && parent.right == curr){
            curr = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private static TreeNode leftMostNode(TreeNode node) {
        TreeNode curr = node;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
}
