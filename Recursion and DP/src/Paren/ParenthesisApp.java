package Paren;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ParenthesisApp {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = scanner.nextInt();
        Set<String> ans  = getAllParen(n);
        System.out.println(ans);
    }

    private static Set<String> getAllParen(int n) {
        if(n == 1){
            return Set.of("()");
        }

        Set<String> subsets = getAllParen(n-1);
        Set<String> ansSet = new LinkedHashSet<>();
        for(String sb : subsets){

            for(int i = 0; i < sb.length(); i++){
                if(sb.charAt(i) == '('){
                    String temp = sb.substring(0, i+1) + "()" + sb.substring(i+1);
                    ansSet.add(temp);
                }
            }
            ansSet.add("()"+sb);
        }
        return ansSet;
    }
}
