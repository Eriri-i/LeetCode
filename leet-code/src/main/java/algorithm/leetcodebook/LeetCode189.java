package algorithm.leetcodebook;

import org.junit.Test;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/8
 */
public class LeetCode189 {
    /**
     * LeetCode 189 轮转数组
     * <p>
     * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     *
     * @param nums 数组
     * @param k    轮转指标
     */
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int length = nums.length;
        k = k % length;
        int count = length;
        for (int i = 0; count > 0; i++) {
            int currentIndex = i;
            int nextIndex = i;
            int tempValue = nums[i];
            do {
                nextIndex = (currentIndex + k) % length;
                int num = nums[nextIndex];
                nums[nextIndex]=tempValue;
                currentIndex = nextIndex;
                tempValue=num;
                count--;
            } while (i != nextIndex);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
