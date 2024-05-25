package trees.minimalTree;

import java.util.Arrays;
import java.util.Scanner;

public class MinimalTreeApp {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements");
        for(int i = 0 ;i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        BinarySearchTree binarySearchTree = BinarySearchTree.createMinimalBst(arr);
        binarySearchTree.preOrder();
    }
}


