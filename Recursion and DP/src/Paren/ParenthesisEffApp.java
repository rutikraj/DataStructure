package Paren;

import java.util.*;

public class ParenthesisEffApp {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = scanner.nextInt();
        List<String> ans  = getAllParen(n);
        System.out.println(ans);
    }

    private static List<String> getAllParen(int n) {
        List<String> ans = new ArrayList<>();
        char []str = new char[n*2];
        getAllParemHelper(ans, n, n, str, 0);
        return ans;
    }

    private static void getAllParemHelper(List<String> ans, int leftRemaining, int rightRemaining, char []str, int count) {
        if(leftRemaining > rightRemaining || leftRemaining < 0)
            return;
        if(leftRemaining == 0 && rightRemaining == 0){
            String s = String.copyValueOf(str);
            ans.add(s);
        }else{
            if(leftRemaining > 0){
                str[count] = '(';
                getAllParemHelper(ans, leftRemaining-1, rightRemaining, str, count+1);
            }

            if(rightRemaining > leftRemaining){
                str[count] = ')';
                getAllParemHelper(ans, leftRemaining, rightRemaining-1, str, count+1);
            }
        }
    }
}
