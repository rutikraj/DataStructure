package trees.minimalTree;

public class BinarySearchTree {

    public Node root;
    public BinarySearchTree(Node root){
        this.root = root;
    }

    public static BinarySearchTree createMinimalBst(int arr[]){
        Node node = createMinimalBst(arr, 0,  arr.length-1);
        BinarySearchTree binarySearchTree = new BinarySearchTree(node);
        return binarySearchTree;
    }

    private static Node createMinimalBst(int[] arr, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end)/2;
        Node node = new Node(arr[mid]);
        node.left = createMinimalBst(arr, start, mid-1);
        node.right = createMinimalBst(arr, mid+1, end);
        return node;
    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node ==  null)
            return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

}
