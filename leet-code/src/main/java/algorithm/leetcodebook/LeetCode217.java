package algorithm.leetcodebook;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/9
 */
public class LeetCode217 {
    /**
     * LeetCode 217 存在重复元素
     * <p>
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     * <p>
     * 输入：nums = [1,2,3,1]
     * 输出：true
     *
     * @param nums 数组
     * @return 数组中是否存在重复元素
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])) {
                return true;
            } else {
                integers.add(nums[i]);
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] ints = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(ints));
    }
}
