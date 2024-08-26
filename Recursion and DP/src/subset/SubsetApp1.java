package subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetApp1 {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int n = scanner.nextInt();
        List<Integer> set = new ArrayList<>();
        System.out.println("Enter the elements : ");
        for(int i = 0; i < n; i++){
            set.add(scanner.nextInt());
        }
        List<List<Integer>> subset = getSubset(set, n, 0);

        for(List<Integer> sub : subset){
            System.out.println(sub);
        }
    }

    private static List<List<Integer>> getSubset(List<Integer> set, int n, int indx) {
        List<List<Integer>> subsetList = new ArrayList<>();
        if(indx == n){
            subsetList.add(new ArrayList<>());
        }else{
            subsetList = getSubset(set, n, indx+1);
            int item = set.get(indx);
            List<List<Integer>> moreSub = new ArrayList<>();
            for(List<Integer> sub : subsetList){
                List<Integer> newSub = new ArrayList<>();
                newSub.addAll(sub);
                newSub.add(item);
                moreSub.add(newSub);
            }
            subsetList.addAll(moreSub);
        }
        return subsetList;
    }
}
