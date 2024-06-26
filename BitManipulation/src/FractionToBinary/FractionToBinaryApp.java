package FractionToBinary;

import java.util.Scanner;

public class FractionToBinaryApp {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number between 0 and 1");
        double num = scanner.nextDouble();
        String fraction = getFraction(num);
        System.out.println(fraction);
    }

    private static String getFraction(double num) {
        if(num <= 0 || num >= 1)
            return null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".");
        while (num > 0){
            if(stringBuilder.length() >= 32)
                return "ERROR";
            num = num * 2;

            if(num >= 1){
                stringBuilder.append("1");
                num -= 1;
            }else{
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }
}
