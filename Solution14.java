import java.util.*;

/*
 * @Description
 * 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是有效IP地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按任何顺序返回答案。
 *
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *  输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 */


class Solution {
    static final int SEG_COUNT = 4; // IP 地址的段数
    List<String> ans = new ArrayList<>(); // 存放结果的列表
    int[] segments = new int[SEG_COUNT]; // 初始化段数组

    public List<String> restoreIpAddresses(String s) {
        ans.clear();//清空上次ans
        dfs(s, 0, 0); // 调用深度优先搜索
        return ans; // 返回结果

    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer(); // 使用 StringBuffer 构建 IP 地址
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.'); // 添加点
                    }
                }
                ans.add(ipAddr.toString()); // 将结果添加到列表中
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 如果当前数字为 0，这一段 IP 地址只能是 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0; // 修正数组赋值语法
            dfs(s, segId + 1, segStart + 1); // 继续递归
            return;
        }

        // 一般情况，枚举每一种可能性
        int addr = 0; // 当前地址值
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0'); // 将字符转换为数字
            if (addr > 0 && addr <= 255) { // 检查地址是否有效
                segments[segId] = addr; // 保存当前段地址
                dfs(s, segId + 1, segEnd + 1); // 递归查找下一段
            } else {
                break; // 如果地址超过 255，停止继续查找
            }
        }
    }
}
