package algorithm.binarysearch;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/16
 */
public class LeetCode704 {
    /**
     * LeetCode 704 二分查找
     * <p>
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，
     * 如果目标值存在返回下标，否则返回 -1。
     * <p>
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     *
     * @param nums   升序整型数组
     * @param target 目标值
     * @return 目标值的下标
     */
    public int search(int[] nums, int target) {
        int small = 0;
        // 使用闭区间查找
        int big = nums.length - 1;
        while (small <= big) {
            // 防止(big+small)/2过大导致溢出
            int mid = small + (big - small) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                // 由于是闭区间搜索，此处+1
                small = mid + 1;
            } else if (target < nums[mid]) {
                // 由于是闭区间搜索，此处-1
                big = mid - 1;
            }
        }
        return -1;
    }
}
