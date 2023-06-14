package nyjsl.hashtable;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (null == nums || nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int dest = target - cur;
            if (container.containsKey(dest)) {
               result[0] = i;
               result[1] = container.get(dest);
            }else{
                container.put(cur,i);
            }
        }
        return result;
    }
}
