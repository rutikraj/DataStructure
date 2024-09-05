package permutation;

import java.util.*;

public class PermutationOfNonUniq {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = scanner.nextLine();
        Map<Character, Integer> mp = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i++){
            mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0) + 1);
        }
        List<String> permutation = getPermutation(mp, str.length());
        System.out.println(permutation);
    }

    private static List<String> getPermutation(Map<Character, Integer> map, int length) {

       List<String> ans = new ArrayList<>();
       if(length == 0)
       {
           ans.add("");
           return ans;
       }

        for(Map.Entry<Character, Integer> mp: map.entrySet()){
            if(mp.getValue() != 0){
                map.put(mp.getKey(), mp.getValue()-1);
                Character chr = mp.getKey();
                List<String> temp = getPermutation(map, length-1);
                for(String tm: temp){
                    ans.add(chr +  tm);
                }
                map.put(mp.getKey(), mp.getValue()+1);
            }
        }
        return ans;
    }
}
