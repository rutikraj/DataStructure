package triplestep;

import java.util.Scanner;

public class TripleStep {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of steps : ");
        int n = scanner.nextInt();
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        System.out.println("ans is : " + dp[n]);

    }
}
