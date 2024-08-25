package magicIndex;

import java.util.Scanner;

public class MagicIndexNonDistinctApp {
//    {-10, -5, 2, 2, 2, 3, 4, 7 ,9, 12, 13}
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

        int leftIndex = Math.min(mid-1, arr[mid]);
        int left = findMagicIndex(arr, start, leftIndex);
        if(left >= 0)
            return left;

        int rightIndex = Math.max(mid+1, arr[mid]);
        return findMagicIndex(arr, rightIndex, end);
    }
}
