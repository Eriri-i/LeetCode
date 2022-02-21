package algorithm.slidewindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/2/14
 */
public class LeetCode76 {
    /**
     * LeetCode 76 最小覆盖子串
     * <p>
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     *
     * @param s 原字符串
     * @param t 匹配条件
     * @return 最小覆盖子串
     */
    public static String minWindow(String s, String t) {
        // 字母数量计数器
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] tCharts = t.toCharArray();
        char[] sCharts = s.toCharArray();
        // 初始化目标计数器
        for (char tChart : tCharts) {
            need.put(tChart, need.getOrDefault(tChart, 0) + 1);
        }
        // 窗口的左右两边
        int left = 0, right = 0;
        // 统计窗口中有几个符合目标的字母
        int valid = 0;
        // 记录结果字符串在原始字符串中的位置，以及结果字符串的长度
        int start = 0, length = Integer.MAX_VALUE;
        while (right < sCharts.length) {
            // 加入到窗口中的字符
            char c = sCharts[right];
            // 移动窗口右边界
            right++;
            // 窗口内数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            /*** debug 输出的位置 ***/
            System.out.printf("window: [%d, %d)%n", left, right);
            /********************/

            // 判断窗口是否收缩
            while (valid == need.size()) {
                // 记录结果
                if (right - left < length) {
                    length = right - left;
                    start = left;
                }
                // 要移除的字符
                char d = sCharts[left];
                // 移动窗口左边界
                left++;
                // 从窗口中移除的字符串
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.computeIfPresent(d, (k, v) -> v - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }

    @Test
    public void testMinWindow() {
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
