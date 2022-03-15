package algorithm.slidewindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/2/21
 */
public class LeetCode567 {
    /**
     * LeetCode 567 字符串的排列
     * <p>
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false
     * 换句话说，s1 的排列之一是 s2 的 子串
     * <p>
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     *
     * @param s1 匹配条件
     * @param s2 原字符串
     * @return 结果
     */
    public boolean checkInclusion(String s1, String s2) {
        // 存放要关注的数据
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        char[] big = s2.toCharArray();
        char[] small = s1.toCharArray();
        // 统计s1中各个字符的数量
        for (char c : small) {
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int fast=0;
        int slow=0;
        // 记录合法字符的数量
        int valid=0;
        while (fast < big.length) {
            char c = big[fast];
            // 窗口右边界增大，窗口右移
            fast++;
            // 更新窗口内相关数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 窗口缩小的时机
            while (valid == need.size()) {
                // 判断是否找到相关子串
                if (fast - slow == small.length) {
                    return true;
                }
                char s = big[slow];
                // 窗口左边界增大，窗口缩小
                slow++;
                // 更新窗口内相关数据
                if (need.containsKey(s)) {
                    if (need.get(s).equals(window.get(s))) {
                        valid--;
                    }
                    window.computeIfPresent(s, (k, v) -> v = v - 1);
                }
            }
        }
        return false;
//        Map<Character, Integer> window = new HashMap<>();
//        Map<Character, Integer> need = new HashMap<>();
//        char[] parent = s2.toCharArray();
//        char[] child = s1.toCharArray();
//        for (char c : child) {
//            need.put(c, need.getOrDefault(c, 0) + 1);
//        }
//        int left = 0;
//        int right = 0;
//        int valid = 0;
//        while (right < parent.length) {
//            char c = parent[right];
//            // 窗口右边界增大，窗口右移
//            right++;
//            // 更新窗口内相关数据
//            if (need.containsKey(c)) {
//                window.put(c, window.getOrDefault(c, 0) + 1);
//                if (window.get(c).equals(need.get(c))) {
//                    valid++;
//                }
//            }
//            // debug
//            System.out.printf("window:[%d,%d)%n", left, right);
//
//            // 窗口缩小的时机
//            while (right - left >= child.length) {
//                // 判断是否找到相关子串
//                if (valid == need.size()) {
//                    return true;
//                }
//                char d = parent[left];
//                // 窗口左边界增大，窗口缩小
//                left++;
//                // 更新窗口内相关数据
//                if (need.containsKey(d)) {
//                    if (window.get(d).equals(need.get(d))) {
//                        valid--;
//                    }
//                    window.computeIfPresent(d, (key, value) -> value - 1);
//                }
//            }
//        }
//        return false;
    }

    @Test
    public void test() {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
