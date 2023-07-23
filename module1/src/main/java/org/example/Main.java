package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result != null) {
            System.out.println("두 수의 합이 " + target + "인 원소의 인덱스: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("해당하는 조합이 없습니다.");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndexMap.containsKey(complement)) {
                int[] result = {numToIndexMap.get(complement), i};
                return result;
            }
            numToIndexMap.put(nums[i], i);
        }

        return null; // 해당하는 조합이 없는 경우
    }
}