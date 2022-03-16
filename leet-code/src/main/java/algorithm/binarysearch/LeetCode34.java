package algorithm.binarysearch;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/16
 */
public class LeetCode34 {
    /**
     * LeetCode 34 在排序数组中查找元素的第一个和最后一个位置
     * <p>
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     * @param nums   非递减数组
     * @param target 目标值
     * @return 目标值的开始出现位置与结束位置
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left,right};
    }

    private int findLeft(int[] nums, int target) {
        int small = 0;
        int big = nums.length - 1;
        // 找开始位置
        while (small <= big) {
            int mid = small + (big - small) / 2;
            if (target == nums[mid]) {
                big = mid-1;
            } else if (target > nums[mid]) {
                small = mid + 1;
            } else if (target < nums[mid]) {
                big = mid - 1;
            }
        }
        if (small >= nums.length || nums[small] != target) {
            return -1;
        }
        return small;
    }

    private int findRight(int[] nums, int target) {
        int small = 0;
        int big = nums.length - 1;
        // 找开始位置
        while (small <= big) {
            int mid = small + (big - small) / 2;
            if (target == nums[mid]) {
                small = mid+1;
            } else if (target > nums[mid]) {
                small = mid + 1;
            } else if (target < nums[mid]) {
                big = mid - 1;
            }
        }
        if (big<0 || nums[big] != target) {
            return -1;
        }
        return big;
    }
}
