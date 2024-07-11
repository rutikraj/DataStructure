package swapOddAndEven;

import java.util.Scanner;

public class OddEvenBitsApp {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test cases : ");
        int T = scanner.nextInt();
        while (T-- > 0){
            System.out.println("Enter number : ");
            int num = scanner.nextInt();
            System.out.println("Binary value of " + num + " = " + getBinaryValue(num));
            int ans = shiftEvenOdd(num);
            System.out.println("Binary value of " + ans + " = " + getBinaryValue(ans));
        }
    }

    private static int shiftEvenOdd(int num) {
        int oddPos =  (num & 0xAAAAAAAA) >>> 1;
        int evenPos =  (num & 0x55555555) << 1;
        return oddPos | evenPos;
    }

    private static String getBinaryValue(int num) {
        if(num <= 0)
            return "";
        String str = getBinaryValue(num/2);
        int rem = num % 2;
        return str + rem;
    }
}
