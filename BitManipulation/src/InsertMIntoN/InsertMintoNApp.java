package InsertMIntoN;

import java.util.Scanner;

//n = 10000000000, m = 10011, i = 2, j = 6
//ans n = 10001001100

public class InsertMintoNApp {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int N , M , i, j ;

        System.out.print("Enter N = ");
        N = scanner.nextInt();

        System.out.print("N = " + N + "(");
        bin(N);
        System.out.println(")");

        // print original bitset
        System.out.print("Enter M = ");
        M = scanner.nextInt();
        System.out.print("M = " + M + "(");
        bin(M);
        System.out.println(")");



        // Call function to insert M to N
        System.out.print("Enter i and j = ");
        i = scanner.nextInt();
        j = scanner.nextInt();
        N = insertion(N, M, i, j);
        System.out.println( "After inserting M " +
                "into N from 3 to 6");

        // Print the inserted bitset
        System.out.print("N = " + N + "(");
        bin(N);
        System.out.println(")");
    }

    private static int insertion(int n, int m, int i, int j) {
        int allOnes = ~0;
        int rightOnes = allOnes << (j+1);
        int leftOnes = ((1 << i) -1);
        int mask = rightOnes | leftOnes;
        n = n & mask;
        m = m << i;
        return n | m;
    }

    private static void bin(int val) {
        if(val != 0){
            bin(val/2);
        }
        System.out.print(val % 2);

    }
}
