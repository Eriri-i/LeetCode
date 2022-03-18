package algorithm.datastructure;

import java.util.HashMap;
import java.util.Random;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/18
 */
public class LeetCode710 {
    /**
     * LeetCode710 黑名单中的随机数
     * <p>
     * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。
     * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个未加入黑名单 blacklist 的整数。
     * 任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回
     * <p>
     * 实现Solution类:
     * Solution(int n, int[] blacklist)初始化整数 n 和被加入黑名单blacklist的整数
     * int pick()返回一个范围为 [0, n - 1] 且不在黑名单blacklist 中的随机整数
     */
    class Solution {

        private final int sz;
        private final HashMap<Integer, Integer> indexMap = new HashMap<>();

        public Solution(int n, int[] blacklist) {
            // 确定除掉黑名单后，还剩下几个元素，pick的时候，从这几个值里面选
            sz = n - blacklist.length;
            int lastIndex = n - 1;
            // map中应要有所有在黑名单中的值的索引，将该索引设置为key，value随便选取一个值
            for (int b : blacklist) {
                indexMap.put(b, Integer.MAX_VALUE);
            }

            // 为mao中的每一个key设置一个替代索引
            for (int b : blacklist) {
                // 如果黑名单中的索引超过了选择范围，就不用给它设置对应的索引了，因为根本随机不到它
                if (b > sz - 1) {
                    continue;
                }
                // 从数组的最后一个值往前找，找到第一个不在黑名单中的值的索引
                while (indexMap.containsKey(lastIndex)) {
                    lastIndex--;
                }
                // 存起来
                indexMap.put(b, lastIndex);
                // 更新一下索引
                lastIndex--;
            }

        }

        public int pick() {
            Random random = new Random();
            int randomValue = random.nextInt(Integer.MAX_VALUE);
            int index = randomValue % sz;
            if (indexMap.containsKey(index)) {
                return indexMap.get(index);
            }
            return index;
        }
    }
}
