package com.google.linkedlist;

import com.google.datastructures.ListNode;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNode {

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode slowPtr = head, fastPtr = head;
        int numNodesVisited = 1, totalNodes = 0; // 1 indicates the headNode visited.
        while(fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            numNodesVisited += 1;
        }

        if (fastPtr.next == null) {
            totalNodes = numNodesVisited * 2 - 1;
        } else {
            totalNodes = numNodesVisited * 2;
        }

        int nodeToDelete = totalNodes - n + 1;

        ListNode traversor;
        if ( nodeToDelete > numNodesVisited ) {
            traversor = slowPtr; // traversor will be in middle
        } else {
            traversor = head;
            numNodesVisited = 1;
        }

        if (nodeToDelete == 1) {
            return traversor.next;
        }

        while (nodeToDelete > (numNodesVisited + 1)) {
            traversor = traversor.next;
            numNodesVisited += 1;
        }

        traversor.next = traversor.next.next;

        return head;
    }

    public static void main(String[] args) throws IOException {
        final int[] l1Inp = new int[]{1,2,3};
        final ListNode l1 = ListNode.generateListFromArray(l1Inp);

        ListNode res = removeNthFromEnd(l1, 3);
        while (res != null) {
            System.out.print(" " + res.val);
            res = res.next;
        }
    }
}
