package algorithm.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/26
 */
public class LeetCode78 {
    /**
     * LeetCode 78 子集
     * <p>
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
     *
     * @param nums 整数数组
     * @return 数组的子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int start) {
        // 每次进入新节点，就是一个子集
        res.add(new LinkedList<>(path));
        // start用来记录原数组的下标，为了不出现重复的子集，循环从start开始
        for (int i = start; i < nums.length; i++) {
            // 做选择
            path.addLast(nums[i]);
            // 进入下一层时，start位置要+1
            backTrack(nums, i + 1);
            // 取消选择
            path.removeLast();
        }

    }

    private List<List<Integer>> res = new ArrayList<>();
    // 记录选择的路径
    private LinkedList<Integer> path = new LinkedList<>();
}
