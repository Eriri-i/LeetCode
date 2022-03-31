package algorithm.dp;

import java.util.Arrays;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/31
 */
public class LeetCode174 {

    /**
     * LeetCode 174 地下城游戏
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // 备忘录初始化
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        // 起点位置为（m-1,n-1）,终点位置为(0,0)
        // dp函数定义为，到（i,j）所需要的最小生命值
        return dp(dungeon, 0, 0);
    }

    // 声明备忘录
    private int[][] memo;

    private int dp(int[][] dungeon, int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // base case
        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
        }
        // 避免数组越界
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Math.min(dp(dungeon, i, j + 1), dp(dungeon, i + 1, j)) - dungeon[i][j];

        // 将这个点的计算结果保存起来
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }
}
