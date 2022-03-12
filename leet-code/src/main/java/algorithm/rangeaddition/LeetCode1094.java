package algorithm.rangeaddition;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/12
 */
public class LeetCode1094 {

    /**
     * LeetCode 1094 拼车
     * <p>
     * 假设你是一位顺风车司机，车上最初有capacity个空座位可以用来载客。
     * 由于道路的限制，车只能向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
     * <p>
     * 这儿有一份乘客行程计划表trips[][]，
     * 其中trips[i] = [num_passengers, start_location, end_location]包含了第 i 组乘客的行程信息：
     * 必须接送的乘客数量；
     * 乘客的上车地点；
     * 以及乘客的下车地点。
     * <p>
     * 这些给出的地点位置是从你的初始出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
     * <p>
     * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所有乘客的任务
     * （当且仅当你可以在所有给定的行程中接送所有乘客时，返回true，否则请返回 false）。
     * <p>
     * 你可以假设乘客会自觉遵守 “先下后上” 的良好素质
     * trips.length <= 1000
     * trips[i].length == 3
     * 1 <= trips[i][0] <= 100
     * 0 <= trips[i][1] < trips[i][2] <= 1000
     * 1 <=capacity <= 100000
     *
     * @param trips    乘客行程计划表
     * @param capacity 车容量
     * @return 是否能够一趟接送完所有的乘客
     */
    public boolean carPooling(int[][] trips, int capacity) {
        // nums存放到每一个车站时，乘客的数量，最多有1001个车站,所以申请1001个空间
        int[] nums = new int[1001];
        // 构造差分解法
        Difference difference = new Difference(nums);
        for (int[] trip : trips) {
            // 乘客数量
            int peopleAmount = trip[0];
            // 上车车站
            int from = trip[1];
            // 下车车站
            int to = trip[2];
            // 从上车到下车前的前一站，乘客都在车上
            difference.increment(peopleAmount, from, to - 1);
        }
        int[] result = difference.result();
        for (int j : result) {
            if (j > capacity) {
                return false;
            }
        }
        return true;
    }

    class Difference {

        // 差分数组
        private int[] diff;

        /**
         * 构建差分数组
         *
         * @param nums 原数组
         */
        public Difference(int[] nums) {
            int length = nums.length;
            diff = new int[length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /**
         * 给闭区间[from,to]增加 val
         *
         * @param val  增加的值
         * @param from 左边界
         * @param to   右边界
         */
        public void increment(int val, int from, int to) {
            diff[from] = diff[from] + val;
            // 如果 to + 1 < diff.length 表示对form 之后的所有数组都进行了修改
            if (to + 1 < diff.length) {
                diff[to + 1] = diff[to + 1] - val;
            }
        }

        /**
         * 返回差分数组的原数组
         *
         * @return 差分数组的原数组
         */
        public int[] result() {
            int[] result = new int[diff.length];
            result[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                result[i] = result[i - 1] + diff[i];
            }
            return result;
        }
    }
}
