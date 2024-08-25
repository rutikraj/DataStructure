package robotInGrid;

import java.util.Scanner;

public class RobotInGridApp {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row and column");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int dp[][] = new int[row][col];
        for(int i = 0; i < row; i++){
            dp[i][0] = 1;
        }

        for(int i = 0; i < col; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println("Total number of ways are : "+ dp[row-1][col-1]);
    }
}
