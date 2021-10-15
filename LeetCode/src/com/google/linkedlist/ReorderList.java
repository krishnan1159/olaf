package com.google.linkedlist;

import com.google.datastructures.ListNode;

import java.io.IOException;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = reverseList(head.next);

        if (head.next != null) {
            head.next.next = head;
        }

        head.next = null;

        if (res == null) {
            return head;
        }

        return res;
    }

    private static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowPtr = head, fastPtr = head;

        while(fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        slowPtr.next = reverseList(slowPtr.next);

        ListNode headPtr = head;

        while (slowPtr.next != null && headPtr != slowPtr) {
            ListNode nextHeadPtr = headPtr.next;
            headPtr.next = slowPtr.next;
            ListNode nextSlowPtr = slowPtr.next.next;
            slowPtr.next.next = nextHeadPtr;
            slowPtr.next = nextSlowPtr;
            headPtr = nextHeadPtr;
        }

        return head;
    }

    public static void main(String[] args) throws IOException {
        final int[] l1Inp = new int[]{1,2,3,4,5};
        final ListNode l1 = ListNode.generateListFromArray(l1Inp);

        ListNode res = reorderList(l1);

        while (res != null) {
            System.out.print(" " + res.val);
            res = res.next;
        }
    }
}
