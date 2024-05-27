package trees.isBST;

import trees.model.TreeNode;

public class BSTApp {

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        if (treeBST(root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
       
        if (BSTUtils.isBST(root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
    }

    private static boolean treeBST(TreeNode root) {
        IntergerWrap intergerWrap = new IntergerWrap();
        return helperBST(root, intergerWrap);
    }

    private static boolean helperBST(TreeNode root, IntergerWrap intergerWrap) {
        if(root == null)
            return true;
        if(!helperBST(root.left, intergerWrap))
            return false;
        if(intergerWrap.data!= null && intergerWrap.data > root.data)
            return false;
        intergerWrap.data = root.data;
        if(!helperBST(root.right, intergerWrap))
            return false;
        return true;
    }
}

class IntergerWrap{
    public Integer data;

    public IntergerWrap(){
        data = null;
    }
}
