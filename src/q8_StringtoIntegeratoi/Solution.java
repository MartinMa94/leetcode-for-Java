package q8_StringtoIntegeratoi;

/**
 * @author InterHorse
 * @date 2021-01-26 20:48:42
 *
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查第一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 *
 * 示例 1：
 *
 * 输入：str = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 * 示例 2：
 *
 * 输入：str = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 *             ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 *              ^
 * 第 3 步："   -42"（读入 "42"）
 *                ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 * 示例 3：
 *
 * 输入：str = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 *              ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 * 示例 4：
 *
 * 输入：str = "words and 987"
 * 输出：0
 * 解释：
 * 第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
 *          ^
 * 解析得到整数 0 ，因为没有读入任何数字。
 * 由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0 。
 * 示例 5：
 *
 * 输入：str = "-91283472332"
 * 输出：-2147483648
 * 解释：
 * 第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
 *           ^
 * 第 3 步："-91283472332"（读入 "91283472332"）
 *                      ^
 * 解析得到整数 -91283472332 。
 * 由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -231 = -2147483648 。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 *
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Solution {
    public static int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        StringBuilder resStr = new StringBuilder();
        s = s.trim();
        if (s.equals("")) {
            return 0;
        }
        boolean isMinus = false;
        boolean isSub = false;
        if (s.charAt(0) == '-') {
            isMinus = true;
            isSub = true;
        }else if (s.charAt(0) == '+') {
            isSub = true;
        }
        if (isSub) {
            s = s.substring(1);
        }
        boolean isZero = true;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57) {
                if (s.charAt(i) != '0') {
                    resStr.append(s.charAt(i));
                    isZero = false;
                } else if (s.charAt(i) == '0') {
                    if (!isZero) {
                        resStr.append(s.charAt(i));
                    }
                }
            } else {
                break;
            }
        }
        if (resStr.length() == 0) {
            return 0;
        }
        if (resStr.length() < 10) {
            return isMinus ? -Integer.parseInt(resStr.toString()) : Integer.parseInt(resStr.toString());
        }
        if (resStr.length() > 10) {
            return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (isMinus) {
            if (resStr.toString().compareTo("2147483648") > 0) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.parseInt("-" + resStr.toString());
            }
        } else {
            if (resStr.toString().compareTo("2147483647") > 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.parseInt(resStr.toString());
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("2147483648"));
//        System.out.println(myAtoi("000214748"));
//        System.out.println(myAtoi("+000214748"));
        System.out.println(myAtoi("-2147483648"));
    }
}
