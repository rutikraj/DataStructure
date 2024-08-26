import java.util.Scanner;

public class MultiplyWithOutOperator {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the two numbers");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int ans = mulitply(x, y);
        System.out.println(ans);
    }

    private static int mulitply(int x, int y) {
        if(x > y)
            return mulitply(y, x);
        if(x == 0 || y == 0)
            return 0;
        if(x == 1)
            return y;

        int halfX = x >> 1;
        int tempMulti = mulitply(halfX, y);
        if(x % 2 == 0){
            return tempMulti + tempMulti;
        }
        return tempMulti + tempMulti + y;

    }
}
