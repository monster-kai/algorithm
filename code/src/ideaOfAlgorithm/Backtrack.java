package ideaOfAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @data 2020/02/24 - 周一
 */
public class Backtrack {
    /**
     * 遍历子集问题 LEET 78
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(nums, 0, list, sets);
        return sets;
    }
    private static void helper(int[] nums, int n, ArrayList<Integer> list,List<List<Integer>> sets ){
        if(n>=nums.length) {
            sets.add(new ArrayList<Integer>(list)); //不要直接加入list，否则将会是一个本体，不同的引用值，最后结果回等于list的最后一次变动后

            return;
        }else{
            list.add(nums[n]);
            helper(nums, n+1, list, sets);
            list.remove(list.size()-1);
            helper(nums, n+1, list, sets);
        }
    }

    /**
     * 位运算方法，通过二进制表示，对于n个数的数组，2^n种方法
     */
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            int k = (1 << nums.length);
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }
}
