package com.google.greedy;

import java.io.IOException;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    private static boolean canJump(int[] nums) {
        int maxIndexToReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndexToReach < i) {
                return false;
            }

            int indexWeCanCover = i + nums[i];
            if (indexWeCanCover > maxIndexToReach) {
                maxIndexToReach = indexWeCanCover;
            }

            if (indexWeCanCover >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        final int[] inp = new int[] {1, 1, 1, 1, 0, 1};
        System.out.println("Res :: " + canJump(inp));
    }
}
