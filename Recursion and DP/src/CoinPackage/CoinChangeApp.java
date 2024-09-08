package CoinPackage;

import java.util.Scanner;

public class CoinChangeApp {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount");
        int amount = scanner.nextInt();
        System.out.println("Enter the number of coins");
        int n = scanner.nextInt();
        int coins[] = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = scanner.nextInt();
        }

        int ways = countWays(amount, n, coins);
        System.out.println(ways);

        ways = countWaysWithRecu(amount, n, coins);
        System.out.println(ways);

    }

    private static int countWaysWithRecu(int amount, int n, int[] coins) {
        if(amount == 0){
            return 1;
        }
        if(amount < 0) return 0;

        if(n <= 0){
            return 0;
        }

        return countWaysWithRecu(amount, n-1, coins) + countWaysWithRecu(amount - coins[n-1], n, coins);
    }

    private static int countWays(int amount, int n, int[] coins) {
        int dp[][] = new int[n+1][amount+1];

        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = dp[i-1][j];
                if(j-coins[i-1] >= 0){
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }
}
