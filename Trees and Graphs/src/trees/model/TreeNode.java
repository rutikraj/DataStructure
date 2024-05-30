package trees.model;

public class TreeNode {
    public int data;
    public TreeNode left, right, parent;

    public TreeNode(int data){
        this.data = data;
        left = right = null;
    }
}
