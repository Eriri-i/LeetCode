package algorithm.slidewindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/2/21
 */
public class LeetCode438 {
    /**
     * LeetCode 438
     * <p>
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词
     *
     * @param s 原字符串
     * @param p 匹配规则
     * @return 异位词列表
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        char[] parent = s.toCharArray();
        char[] child = p.toCharArray();
        int left = 0;
        int right = 0;
        int valid = 0;
        for (char c : child) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        while (right < parent.length) {
            // 要移入窗口的字符
            char c = parent[right];
            // 窗口右边界增大，窗口右移
            right++;
            // 更新窗口中的数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // debug
            System.out.printf("window:[%d,%d)%n", left, right);

            while (right - left >= child.length) {
                // 处理结果
                if (valid == need.size()) {
                    result.add(left);
                }
                //要移除窗口的字符
                char d = parent[left];
                // 窗口左边界增大，窗口左移
                left++;
                // 窗口内数据更新
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.computeIfPresent(d, (k, v) -> v - 1);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
