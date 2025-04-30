
package parcial.sum;


import java.util.ArrayList;
import java.util.List;

public class PathSumFinder {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);

        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            dfs(node.left, targetSum - node.val, currentPath, result);
            dfs(node.right, targetSum - node.val, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1); // backtrack
    }

    public TreeNode buildTree(Integer[] values) {
        if (values.length == 0) {
            return null;
        }
        List<TreeNode> nodes = new ArrayList<>();
        for (Integer val : values) {
            nodes.add(val != null ? new TreeNode(val) : null);
        }
        int i = 0;
        int j = 1;
        while (j < nodes.size()) {
            if (nodes.get(i) != null) {
                if (j < nodes.size()) nodes.get(i).left = nodes.get(j++);
                if (j < nodes.size()) nodes.get(i).right = nodes.get(j++);
            }
            i++;
        }
        return nodes.get(0);
    }

    public static void main(String[] args) {
        PathSumFinder finder = new PathSumFinder();
        Integer[] values = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        int targetSum = 22;

        TreeNode root = finder.buildTree(values);
        List<List<Integer>> paths = finder.pathSum(root, targetSum);

        System.out.println("Paths where sum equals target:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
