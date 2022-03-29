package algorithm.dp;

import java.util.Arrays;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/29
 */
public class LeetCode300 {
    /**
     * LeetCode300 最长递增子序列
     * <p>
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
     *
     * @param nums 整数数组
     * @return 最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {

        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result=0;
        for (int item : dp) {
            result = Math.max(result, item);
        }
        return result;
    }
}
