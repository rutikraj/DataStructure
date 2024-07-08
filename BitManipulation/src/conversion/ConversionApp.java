package conversion;

import java.util.Scanner;

//min number of bit req to convert x to y
public class ConversionApp {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter test cases");
        int T = scanner.nextInt();
        while(T-- > 0){
            System.out.println("Enter two number");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("binary value of "+x+" = " + getBinary(x));
            System.out.println("binary value of "+y+" = " + getBinary(y));
            int ans1 = getAns1(x, y);
            int ans2 = getAns2(x, y);
            System.out.println("ans 1 : "+ ans1);
            System.out.println("ans 2 : "+ ans2);

        }
    }

    private static int getAns1(int x, int y) {
        int xor = x ^ y;
        int ct = 0;
        for(int ind = xor; ind != 0; ind = ind >>> 1){
            if((ind & 1) == 1)
                ct++;
        }
        return ct;

    }

    private static int getAns2(int x, int y) {
        int xor = x ^ y;
        int ct = 0;
        for(int ind = xor; ind != 0; ind = ind & (ind-1) ){
            ct++;
        }
        return ct;

    }

    private static String getBinary(int val) {
        if(val <= 0)
            return "";
        String str = getBinary(val/2);
        int rem = val % 2;
        return str + rem ;
    }
}
