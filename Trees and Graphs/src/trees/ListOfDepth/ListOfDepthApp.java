package trees.ListOfDepth;

import trees.minimalTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepthApp {

    public static void main(String []args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);

        levelOrderQueue(root);
    }

    private static void levelOrderQueue(TreeNode root) {
        List<ListNode> listNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int noOfNodeAtLevel = queue.size();
            ListNode head = null;
            ListNode curr = head;
            while(noOfNodeAtLevel > 0){
                TreeNode treeNode = queue.poll();
                if(head == null){
                    head = new ListNode(treeNode.data);
                    curr = head;
                }else{
                    curr.next = new ListNode(treeNode.data);
                    curr = curr.next;
                }
               if(treeNode.left != null)
                   queue.add(treeNode.left);
               if(treeNode.right != null)
                   queue.add(treeNode.right);
               noOfNodeAtLevel--;
            }
            if(head != null)
                listNodes.add(head);
        }
        printList(listNodes);
    }

    private static void printList(List<ListNode> listNodes) {

        for(ListNode node: listNodes){
            printList(node);
        }
    }

    private static void printList(ListNode node) {
        ListNode curr = node;
        while(curr != null)
        {
            System.out.print(curr.data + "-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
