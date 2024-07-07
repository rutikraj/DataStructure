package nextNumber;

import java.util.Scanner;

public class NextLargestAndSmallest {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of test cases");
        int T = scanner.nextInt();
        while(T-- > 0){
            System.out.println("Enter the number : ");
            int num = scanner.nextInt();
            String binaryValue = getBinaryValue(num);
            System.out.println(binaryValue);
            int max = getNextLargest(num);
            System.out.println("Max number is : " + max + " and its binary representation is : "+ getBinaryValue(max));
            int min = getNextSmallest(num);
            System.out.println("Min number is : " + min + " and its binary representation is : "+ getBinaryValue(min));
        }
    }

    private static int getNextSmallest(int num) {
        int zeroCt = 0;
        int oneCt = 0;
        int n = num;
        while ((n & 1) == 1 && n != 0){
            oneCt++;
            n = n >>> 1;
        }
        if(n == 0)
            return -1;
        while ((n & 1) == 0 && n != 0){
            zeroCt++;
            n = n >>> 1;
        }

        int mask = 1 << (zeroCt + oneCt);
        int temp = mask - 1;
        temp = ~temp;
        num = num & temp;
        mask = ~mask;
        num = num & mask;
        mask = (1 << (oneCt+1)) -1;
        mask = mask << (zeroCt-1);
        num = num | mask;
        return num;

    }

    private static int getNextLargest(int num) {
        int zeroCt = 0, oneCt = 0;
        int n = num;
        while((n & 1) == 0 && n != 0){
            zeroCt++;
            n = n >>> 1;
        }
        while((n & 1) == 1 && n != 0){
            oneCt++;
            n = n >>> 1;
        }
        int totCt = zeroCt + oneCt ;
        num = num | (1 << totCt);
        int mask = (1 << totCt) - 1 ;
        mask = ~mask;
        num = num & mask;
        int addOne = (1 << (oneCt-1)) - 1;
        num = num | addOne;
        return num;
    }

    private static String getBinaryValue(int num) {
        if(num == 0){
            return "";
        }
        String str = getBinaryValue(num/2);
        int rem = num % 2;
        return str + rem;
    }
}
