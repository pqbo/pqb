package org.pqb.algorthm;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;

public class algorthm {

    /**
     * 给你一个 数字 字符串数组 nums 和一个 数字 字符串 target ，请你返回 nums[i] + nums[j] （两个字符串连接）结果等于 target 的下标 (i, j) （需满足 i != j）的数目。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int numOfPairs(String[] nums, String target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums.length; j++) {
                if(i!=j && target.equals(nums[i]+nums[j])){
                    ++res;
                }
            }
        }
        return res;
    }

    /**
     * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
     *
     * 例如，下面的二进制手表读取 "3:25" 。
     *
     *
     * （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0) ）
     *
     * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
     *
     * 小时不会以零开头：
     *
     * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
     * 分钟必须由两位数组成，可能会以零开头：
     *
     * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-watch
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param turnedOn
     * @return
     */
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn){
                    ans.add(i+":"+(j>9?j:"0"+j));
                }
            }
        }
        System.out.println(ans.toString());
        return ans;
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,1], k = 3
     * 输出：true
     * 示例 2：
     *
     * 输入：nums = [1,0,1,1], k = 1
     * 输出：true
     * 示例 3：
     *
     * 输入：nums = [1,2,3,1,2,3], k = 2
     * 输出：false
     *  
     *
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * 0 <= k <= 105
     * 通过次数235,179提交次数531,446
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/contains-duplicate-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
          if(i>k){
              set.remove(nums[i-k-1]);
          }
          if(!set.add(nums[i])){
              return true;
          }
        }
        return false;
    }

    /**
     * 58. 最后一个单词的长度
     * 简单
     * 616
     * 相关企业
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "Hello World"
     * 输出：5
     * 解释：最后一个单词是“World”，长度为5。
     * 示例 2：
     *
     * 输入：s = "   fly me   to   the moon  "
     * 输出：4
     * 解释：最后一个单词是“moon”，长度为4。
     * 示例 3：
     *
     * 输入：s = "luffy is still joyboy"
     * 输出：6
     * 解释：最后一个单词是长度为6的“joyboy”。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 仅有英文字母和空格 ' ' 组成
     * s 中至少存在一个单词
     * @param s
     */

    public static int lengthOfLastWord(String s) {
        String[] split = s.split("\\s");
        s= split[split.length-1];
        int length = s.toCharArray().length;
        return length;
    }

    /**
     * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
     *
     * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
     *
     * 仅由小写字母、连字符和/或标点（不含数字）组成。
     * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
     * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
     * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
     *
     * 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：sentence = "cat and  dog"
     * 输出：3
     * 解释：句子中的有效单词是 "cat"、"and" 和 "dog"
     * 示例 2：
     *
     * 输入：sentence = "!this  1-s b8d!"
     * 输出：0
     * 解释：句子中没有有效单词
     * "!this" 不是有效单词，因为它以一个标点开头
     * "1-s" 和 "b8d" 也不是有效单词，因为它们都包含数字
     * 示例 3：
     *
     * 输入：sentence = "alice and  bob are playing stone-game10"
     * 输出：5
     * 解释：句子中的有效单词是 "alice"、"and"、"bob"、"are" 和 "playing"
     * "stone-game10" 不是有效单词，因为它含有数字
     *
     *
     * 提示：
     *
     * 1 <= sentence.length <= 1000
     * sentence 由小写英文字母、数字（0-9）、以及字符（' '、'-'、'!'、'.' 和 ','）组成
     * 句子中至少有 1 个 token
     * @param sentence
     * @return
     */


    public static int countValidWords(String sentence) {
//        TODO 未完成
        int num = 0;

        String[] split = sentence.split("\\s");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            boolean flag = true;
            String str = split[i];
            if("".equals(str)){
                continue;
            }
            for (int j = 0; j < str.length(); j++) {
                if (Character.isDigit(str.charAt(j))) {
                    flag = false;
                }
            }

//            int i1 = str.indexOf("-");
//            int i2 = str.lastIndexOf("-");
//            if(i1==0 && str.length()==1){
//                flag = false;
//            }
//            if(flag && i1 == i2  && i1!=0 && i1<length-1){
//                if(str.substring(i1-1,i1).matches("[a-z]") && str.substring(i1-1,i1).matches("[a-z]")){
//                    flag =true;
//                }else {
//                    continue;
//                }
//            }
             if(flag){
                int i3 = str.indexOf("!");
                int i4 = str.indexOf(".");
                int i5 = str.indexOf(",");
                if((i3>-1&& i4>-1) || (i4>-1 && i5>-1) || (i3>-1 && i5>-1)){
                    continue;
                }
                if((i3>-1 && i3!=str.length()-1) || (i4>-1 && i4!=str.length()-1) || (i5>-1 && i5!=str.length()-1)){
                    continue;
                }

            }
            if(flag){
                ++num;
            }

        }

            return num ;
    }

    /**
     * 242. 有效的字母异位词
     * 简单
     * 827
     * 相关企业
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     *
     * 提示:
     *
     * 1 <= s.length, t.length <= 5 * 104
     * s 和 t 仅包含小写字母
     *
     *
     * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     * @param
     */

    public static void main(String[] args) {
        System.out.println(countValidWords("-"));
    }
}
