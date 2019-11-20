package com.kk.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ArrayTest {

    /*  两数之和
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

        示例:

        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]

    */
    @Test
    public void twoSumTest() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println("结果---》");
        for (int res : ints) {
            System.out.print(res + " ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*    删除排序数组中的重复项
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

    示例 1:

    给定数组 nums = [1,1,2],

    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

    你不需要考虑数组中超出新长度后面的元素。*/
    @Test
    public void removeDuplicatesTest() {
        int[] nums2 = new int[]{1, 1, 2};
        int i = removeDuplicates(nums2);
        System.out.println("结果 " + i);
    }

    public int removeDuplicates(int[] nums) {
        int before = 0;
        int after = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[before] != nums[after]) {
                before++;
                nums[before] = nums[after];
            }
            after++;
        }
        return before + 1;
    }


    /*   移除元素
         给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

        示例 1:

        给定 nums = [3,2,2,3], val = 3,

        函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

        你不需要考虑数组中超出新长度后面的元素。*/
    @Test
    public void removeElementTest() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println("结果=" + i);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /*   搜索插入位置
        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

        你可以假设数组中无重复元素。

        示例 1:

        输入: [1,3,5,6], 5
        输出: 2
        示例 2:

        输入: [1,3,5,6], 2
        输出: 1
        示例 3:

        输入: [1,3,5,6], 7
        输出: 4
      */
    @Test
    public void searchInsertTest() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        int i = searchInsert(nums, target);
        System.out.println("结果=" + i);
    }

    public int searchInsert(int[] nums, int target) {
        int temp = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                if (num == 0) {
                    temp = i;
                    num++;
                }
            }
            if (target == nums[i]) {
                return i;
            }
        }
        if (num == 0) {
            return nums.length;
        } else {
            return temp;
        }

    }

    /*  最大子序和
        给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
        示例:
        输入: [-2,1,-3,4,-1,2,1,-5,4],
        输出: 6
        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
        进阶:
        如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。*/
    @Test
    public void maxSubArrayTest() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println("结果=" + i);
    }

    public int maxSubArray(int[] nums) {
        int ant = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ant = Math.max(ant, sum);
        }
        return ant;
    }

    /*
     加一
     给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     你可以假设除了整数 0 之外，这个整数不会以零开头。
     示例 1:
     输入: [1,2,3]
     输出: [1,2,4]
     解释: 输入数组表示数字 123。
     示例 2:
     输入: [4,3,2,1]
     输出: [4,3,2,2]
     解释: 输入数组表示数字 4321。*/
    @Test
    public void plusOne() {
    int [] digits = new int[]{9,9,9};
        int[] ints = plusOne(digits);
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
