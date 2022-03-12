package algorithm.rangesumquery;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/12
 */
public class LeetCode303 {

    /**
     * LeetCode 303 区域和检索-数组不可变
     * <p>
     * 给定一个整数数组 nums，处理以下类型的多个查询:
     * 计算索引left和right（包含 left 和 right）之间的 nums 元素的 和 ，其中left <= right
     * <p>
     * 实现 NumArray 类：
     * NumArray(int[] nums) 使用数组 nums 初始化对象
     * int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的 总和
     * 包含left和right两点（也就是nums[left] + nums[left + 1] + ... + nums[right])
     * <p>
     * 输入：
     * ["NumArray", "sumRange", "sumRange", "sumRange"]
     * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     * 输出：
     * [null, 1, -1, -3]
     * <p>
     * 解释：
     * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
     * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
     * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
     * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
     */
    class NumArray {

        private int[] preSum;

        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
