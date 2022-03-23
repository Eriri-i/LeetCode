package algorithm.graph;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/23
 */
public class LeetCode785 {
    /**
     * LeetCode 785 判断二分图
     *
     * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。
     * 给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。
     * 形式上，对于graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
     *
     * 不存在自环（graph[u] 不包含 u）。
     * 不存在平行边（graph[u] 不包含重复值）。
     * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
     * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
     *
     * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
     *
     * 如果图是二分图，返回 true ；否则，返回 false
     *
     * 思路：把二分图的判断问题想象成着色问题：能否使用两种颜色对无向图进行着色，使得无向图相邻节点颜色各不相同，如果可以，那么这个图是二分图，如果不可以，则不是
     *
     * @param graph 邻接表
     * @return 是否为二分图
     */
    public boolean isBipartite(int[][] graph) {
        // 节点个数
        int length = graph.length;
        color = new boolean[length];
        visited = new boolean[length];
        // 由于图不一定是连通的，可能会有多个子图
        // 所以需要把每个节点作为起点进行一次遍历，如果发现有任何一个子图不是二分图，整幅图都不算二分图
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                traverse(graph,i);
            }
        }
        return ok;
    }

    // 保存节点对应的颜色
    private boolean[] color;
    // 保存节点是否访问过
    private boolean[] visited;
    // 是否为二分图
    private boolean ok = true;

    //DFS遍历
    private void traverse(int[][] graph, int vertex) {
        // 表示已经可以确定图不是二分图了，不要进行后面的遍历了
        if (!ok) {
            return;
        }
        visited[vertex] = true;
        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                // 相邻系欸但neighbor没有被访问过
                // 应该给neighbor涂上和vertex不同的颜色
                color[neighbor] = !color[vertex];
                // 以neighbor为起点继续遍历
                traverse(graph, neighbor);
            } else {
                // 相邻节点已经被访问过了，根据neighbor和vertex的颜色判断是否是二分图
                if (color[neighbor] == color[vertex]) {
                    ok=false;
                }
            }
        }
    }
}
