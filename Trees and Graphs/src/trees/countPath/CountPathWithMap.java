package trees.countPath;

import trees.model.TreeNode;

import java.util.HashMap;

public class CountPathWithMap {

    public static int k_path_sum(TreeNode node, int k){
        return kPathHelper(node, k, 0, new HashMap<Integer, Integer>());
    }

    private static int kPathHelper(TreeNode node, int k, int runningSum, HashMap<Integer, Integer> map) {
        if(node == null)
            return 0;
        runningSum += node.data;
        int val = map.getOrDefault(runningSum-k, 0);
        int totalPath = val;

        if(runningSum == k)
            totalPath++;
        incrementMap(map, runningSum, 1);
        totalPath += kPathHelper(node.left, k, runningSum, map);
        totalPath += kPathHelper(node.right, k, runningSum, map);
        incrementMap(map, runningSum, -1);
        return totalPath;
    }

    private static void incrementMap(HashMap<Integer, Integer> map, int key, int val) {
        int num = map.getOrDefault(key, 0) + val;
        if(num == 0)
            map.remove(key);
        else
            map.put(key, num);

    }
}
