import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class L2022211993_2_Test {

    Solution solution = new Solution();

    /*
     * 测试目的: 测试有效的 IP 地址生成
     * 测试用例: "25525511135"
     * 期望输出: ["255.255.11.135", "255.255.111.35"]
     */
    @Test
    public void testValidIp1() {
        String s = "25525511135";
        List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
        List<String> result = solution.restoreIpAddresses(s);
        assertEquals(expected, result);
    }

    /*
     * 测试目的: 测试有效的 IP 地址生成，包含多个 0
     * 测试用例: "0000"
     * 期望输出: ["0.0.0.0"]
     */
    @Test
    public void testValidIp2() {
        String s = "0000";
        List<String> expected = Arrays.asList("0.0.0.0");
        List<String> result = solution.restoreIpAddresses(s);
        assertEquals(expected, result);
    }

    /*
     * 测试目的: 测试有效的 IP 地址生成
     * 测试用例: "101023"
     * 期望输出: ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
     */
    @Test
    public void testValidIp3() {
        String s = "101023";
        List<String> expected = Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3");
        List<String> result = solution.restoreIpAddresses(s);
        assertEquals(expected, result);
    }

    /*
     * 测试目的: 测试无效的 IP 地址生成
     * 测试用例: "256256256256"
     * 期望输出: []
     */
    @Test
    public void testInvalidIp() {
        String s = "256256256256";
        List<String> expected = Arrays.asList(); // 无法生成合法 IP
        List<String> result = solution.restoreIpAddresses(s);
        assertEquals(expected, result);
    }




    /*
     * 测试目的: 测试边界值输入
     * 测试用例: "1"
     * 期望输出: []
     */
    @Test
    public void testBoundaryInputTooShort() {
        String s = "1";
        List<String> expected = Arrays.asList(); // 无法生成合法 IP
        List<String> result = solution.restoreIpAddresses(s);
        assertEquals(expected, result);
    }

    /*
     * 测试目的: 测试边界值输入
     * 测试用例: "255255255255"
     * 期望输出: ["255.255.255.255"]
     */
    @Test
    public void testBoundaryInputMaxValue() {
        String s = "255255255255";
        List<String> expected = Arrays.asList("255.255.255.255"); // 最合法的 IP
        List<String> result = solution.restoreIpAddresses(s);
        assertEquals(expected, result);
    }
}
