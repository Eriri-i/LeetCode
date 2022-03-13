package algorithm.matrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/13
 */
public class LeetCode54 {
    /**
     * LeetCode 54 螺旋矩阵
     *
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
     *
     * @param matrix 矩阵
     * @return 顺时针遍历后的矩阵元素
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // 定义边界
        int upLimit = 0;
        int rightLimit = matrix[0].length;
        int downLimit = matrix.length;
        int leftLimit = 0;
        // 计算矩阵元素个数
        int allCount = rightLimit * downLimit;
        List<Integer> result = new ArrayList<>();
        while (result.size() < allCount) {
            // 将上面的元素加入结果数组并更新上边界
            for (int i = upLimit; i < rightLimit; i++) {
                result.add(matrix[upLimit][i]);
            }
            upLimit++;
            // 将右边的元素加入数组,并更新右边界
            for (int i = upLimit; i < downLimit; i++) {
                result.add(matrix[i][rightLimit - 1]);
            }
            rightLimit--;
            // 下边界不能与上边界重合
            if (upLimit < downLimit) {
                // 将下面的元素加入数组,并更新下边界
                for (int i = rightLimit - 1; i >= leftLimit; i--) {
                    result.add(matrix[downLimit - 1][i]);
                }
                downLimit--;
            }
            // 左边界不能与右边界重合
            if (leftLimit < rightLimit) {
                // 将左边的元素加入数组,并更新左边界
                for (int i = downLimit - 1; i >= upLimit; i--) {
                    result.add(matrix[i][leftLimit]);
                }
                leftLimit++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] matrix = {new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}};
        spiralOrder(matrix);
    }
}
