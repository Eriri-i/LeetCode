package algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/22
 */
public class LeetCode797 {
    /**
     * LeetCode 797 所有可能的路径
     * <p>
     * 给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
     * graph[i]是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点graph[i][j]存在一条有向边）
     *
     * @param graph 邻接表
     * @return 路径列表
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 存放 从n节点到n-1节点 的路径列表
        List<List<Integer>> result = new ArrayList<>();
        // 图遍历过程中的路径
        LinkedList<Integer> path = new LinkedList<>();
        // 从0节点开始遍历图
        traverse(graph, path, 0, result);
        return result;
    }

    private void traverse(int[][] graph, LinkedList<Integer> path, int s, List<List<Integer>> result) {
        // 将当前节点加入路径
        path.addLast(s);
        int n = graph.length;

        // 到达目的地 n-1 节点
        if (s == n - 1) {
            // 保存这条路径
            result.add(new LinkedList<>(path));
            // 撤销上一次的路径选择
            path.removeLast();
            return;
        }

        // 遍历当前节点的相邻节点
        for (int t : graph[s]) {
            traverse(graph, path, t, result);
        }
        // 撤销上一次的路径选择
        path.removeLast();
    }
}
