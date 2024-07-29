package com.quantum.learning.oa;

import java.util.ArrayList;
import java.util.List;

public class DiskStorage {

    private List<List<Integer>> graph;
    private char[] A;
    private int[] parent;
    private int[] depth;

    public int[] solveQueries(int tree_nodes, char[] A, int[] tree_from, int[] tree_to, int m, int[] queries) {
        this.A = A;
        this.graph = new ArrayList<>(tree_nodes);
        for (int i = 0; i < tree_nodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int i = 0; i < tree_from.length; i++) {
            graph.get(tree_from[i]).add(tree_to[i]);
            graph.get(tree_to[i]).add(tree_from[i]);
        }

        // Initialize parent and depth arrays
        this.parent = new int[tree_nodes];
        this.depth = new int[tree_nodes];
        dfs(0, -1, 0);

        // Process queries
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = countPalindromeNodes(queries[i]);
        }

        return result;
    }

    private void dfs(int node, int par, int d) {
        parent[node] = par;
        depth[node] = d;
        for (int child : graph.get(node)) {
            if (child != par) {
                dfs(child, node, d + 1);
            }
        }
    }

    private int countPalindromeNodes(int node) {
        int count = 0;
        int[] charCount = new int[26];
        int oddCount = 0;

        while (node != -1) {
            int index = A[node] - 'a';
            charCount[index]++;
            if (charCount[index] % 2 == 0) {
                oddCount--;
            } else {
                oddCount++;
            }
            if (oddCount <= 1) {
                count++;
            }
            node = parent[node];
        }

        return count;
    }
}
