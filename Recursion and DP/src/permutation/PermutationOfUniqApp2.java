package permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationOfUniqApp2 {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = scanner.nextLine();
        List<String> permutation = getPermutation(str, str.length());
        System.out.println(permutation);
    }

    private static List<String> getPermutation(String str, int length) {
        List<String> ans  = new ArrayList<>();
        if(length ==  0){
            ans.add("");
            return ans;
        }

        for(int i = 0; i < str.length(); i ++){
            char remain = str.charAt(i);
            String fst = str.substring(0, i);
            String scd = str.substring(i+1);
            List<String> perm = getPermutation(fst+scd, length-1);
            for(String pe :  perm){
                ans.add(remain + pe);
            }
        }

        return ans;

    }

}
