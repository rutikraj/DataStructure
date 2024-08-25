package magicIndex;

import java.util.Scanner;

public class MagicIndexDistinctApp {
//    {-40, -20, -1, 1, 2, 3, 5,7 ,9, 12, 13}
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the elements");

        for(int i= 0 ;i < n; i++){
            arr[i] = scanner.nextInt();
        }

        int index = findMagicIndex(arr, 0, n);
        System.out.println("Index is : " +index);

    }

    private static int findMagicIndex(int[] arr, int start, int end) {
        if(start > end)
            return -1;
        int mid = (start+end)/2;
        if(arr[mid] == mid)
            return mid;
        if(arr[mid] < mid)
            return findMagicIndex(arr, mid +1, end);
        else{
            return findMagicIndex(arr, start, mid-1);
        }

    }
}
