package subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetApp2 {

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
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> singleSet = new ArrayList<>();
        subSetHelper(set, subset, n, indx, singleSet);
        return subset;
    }

    private static void subSetHelper(List<Integer> set, List<List<Integer>> subset, int n, int start, List<Integer> singleSet) {
        subset.add(new ArrayList<>(singleSet));
        for(int i = start; i < n; i++){
            int item = set.get(i);
            singleSet.add(item);
            subSetHelper(set, subset, n, i+1, singleSet);
            singleSet.remove(singleSet.size()-1);
        }
    }
}
