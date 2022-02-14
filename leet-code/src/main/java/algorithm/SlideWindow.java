package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/2/14
 */
public class SlideWindow {
    /*
     * leetCode 76
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
        int left=0,right=0;
        // 统计窗口中有几个符合目标的字母
        int valid=0;
        // 记录结果字符串在原始字符串中的位置，以及结果字符串的长度
        int start=0,length=Integer.MAX_VALUE;
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
            System.out.printf("window: [%d, %d)\n", left, right);
            /********************/

            // 判断窗口是否收缩
            while (valid == need.size()) {
                // 记录结果
                if (right - left < length) {
                    length=right-left;
                    start=left;
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
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start+length);
    }

    public static void main(String[] args) {
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
