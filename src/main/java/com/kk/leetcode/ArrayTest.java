package com.kk.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    // 正数增益
    public int maxSubArray1(int[] nums) {
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
    // 分治法

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;

    }

    private int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;
        return max3(maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right),
                maxCrossingSum(nums, left, mid, right));
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    /*    复杂度分析：

        时间复杂度：O(N \log N)O(NlogN)，这里递归的深度是对数级别的，每一层需要遍历一遍数组（或者数组的一半、四分之一）。
        空间复杂度：O(1)O(1)，仅需要常数个空间用于选取最大值。*/
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
        int[] digits = new int[]{9, 9, 9};
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

    /*
        合并两个有序数组
        给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

        说明:

        初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
        示例:

        输入:
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3

        输出: [1,2,2,3,5,6]*/
    @Test
    public void mergeTest() {
        int[] nums1 = new int[]{2, 1, 7, 0, 0, 0};
        int[] nums2 = new int[]{5, 2, 6};
        merge(nums1, 3, nums2, 3);
    }

    // 暴力解法先合并在排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        for (int j = 0; j < nums1.length - 1; j++) {
            for (int i = 0; i < nums1.length - 1 - j; i++) {
                if (nums1[i] > nums1[i + 1]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[i + 1];
                    nums1[i + 1] = temp;
                }
            }
        }
        for (int v : nums1) {
            System.out.print(v + " ");
        }
    }

    // 双指针 从前往后复杂度分析
    //
    //时间复杂度 : O(n + m)O(n+m)。
    //空间复杂度 : O(m)O(m)。
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    // 双指针 从后往前
    // 时间复杂度 : O(n + m)。
    // 空间复杂度 : O(1)。
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /*   杨辉三角
       输入: 5
       输出:
               [
               [1],
               [1,1],
               [1,2,1],
               [1,3,3,1],
               [1,4,6,4,1]
               ]*/
    @Test
    public void generateTest() {
        List<List<Integer>> generate = generate(5);
        generate.forEach(System.out::println);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = result.get(rowNum - 1);
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            result.add(row);

        }
        return result;
    }

}
