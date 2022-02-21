package algorithm.slidewindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/2/21
 */
public class LeetCode3 {
    /**
     * LeetCode 3
     * <p>
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串
     *
     * @param s 原字符串
     * @return 无重复最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        char[] schart = s.toCharArray();
        int left = 0;
        int right = 0;
        int valid = 0;
        int result = 0;
        while (right < s.length()) {
            char c = schart[right];
            right++;
            if (!window.containsKey(c)) {
                valid++;
            }
            window.put(c, window.getOrDefault(c, 0) + 1);
            System.out.printf("window:[%d,%d)%n", left, right);
            while (window.get(c) > 1) {
                char d = schart[left];
                left++;
                Integer integer = window.computeIfPresent(d, (k, v) -> v - 1);
                if (0 == integer) {
                    valid--;
                    window.remove(d);
                }
            }
            result = Integer.max(result, valid);
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
