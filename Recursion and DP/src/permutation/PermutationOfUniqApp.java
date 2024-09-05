package permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationOfUniqApp {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = scanner.nextLine();
        List<String> permutation = getPermutation(str, str.length());
        System.out.println(permutation);
    }

    private static List<String> getPermutation(String str, int length) {

        List<String> ans = new ArrayList<>();
        if(length == 0){
            ans.add(" ");
            return ans;
        }
        char chr = str.charAt(0);
        String remainder = str.substring(1);
        List<String> words = getPermutation(remainder, length-1);
        for(String word : words){
            List<String> tempList = insertEle(word, chr);
            ans.addAll(tempList);
        }
        return ans;
    }

    private static List<String> insertEle(String word, char chr) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            String fst = word.substring(0, i);
            String scd = word.substring(i);
            list.add(fst+chr+scd);
        }
        return list;
    }

}
