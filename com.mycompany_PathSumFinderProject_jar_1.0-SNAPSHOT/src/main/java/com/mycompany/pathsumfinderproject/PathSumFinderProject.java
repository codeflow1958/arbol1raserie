

package com.mycompany.pathsumfinderproject;

import java.util.List;
import parcial.sum.PathSumFinder;
import parcial.sum.TreeNode;

/**
 *
 * @author 50241
 */
public class PathSumFinderProject {

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
