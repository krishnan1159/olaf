package com.google.linkedlist;

import com.google.datastructures.ListNode;

import java.io.IOException;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {
    private static ListNode detectCycle(ListNode head) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        final int[] inp = new int[]{1, 1, 1, 1, 0, 1};
        ListNode loopStartNode = null, lastNode = null;
        final ListNode startNode = ListNode.generateListFromArray(inp);

        ListNode nodeIterator = startNode;
        int loopPos = 3;
        int startPos = 0;
        while (nodeIterator != null) {
            if (startPos == loopPos - 1) {
                loopStartNode = nodeIterator;
            }
            if (nodeIterator.next == null) {
                lastNode = nodeIterator;
            }

            startPos++;
            nodeIterator = nodeIterator.next;
        }

        if (loopStartNode != null)
            lastNode.next = loopStartNode;


        System.out.println("Res :: " + detectCycle(startNode));
    }
}
