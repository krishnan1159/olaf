package com.google.linkedlist;

import com.google.datastructures.ListNode;

import java.io.IOException;
import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        // Store the result in l1. If l1 is shorter, it needs to be modified correctly
        ListNode result = l1;
        int carry = 0;
        while (l1.next != null && l2.next != null) {
            int addRes = l1.val + l2.val + carry;
            carry = addRes / 10;
            l1.val = addRes % 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2.next == null) {
            // l2 node is shorter or equal to l1.
            int addRes = l1.val + l2.val + carry;
            carry = addRes / 10;
            l1.val = addRes % 10;
        } else {
            // l1 node is shorter than l2.
            int addRes = l1.val + l2.val + carry;
            carry = addRes / 10;
            l1.val = addRes % 10;
            l1.next = l2.next;
            l2.next = null;
        }


        ListNode lastNode = null;
        if (l1.next == null) {
            lastNode = l1;
        }
        l1 = l1.next;
        while (l1 != null && carry > 0) {
            int addRes = l1.val + carry;
            l1.val = addRes % 10;
            carry = addRes / 10;

            if (l1.next == null) {
                lastNode = l1;
            }
            l1 = l1.next;
        }

        if (carry > 0) {
            lastNode.next = new ListNode(carry);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        final int[] l1Inp = new int[]{9};
        final int[] l2Inp = new int[]{9};
        final ListNode l1 = ListNode.generateListFromArray(l1Inp);
        final ListNode l2 = ListNode.generateListFromArray(l2Inp);

        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(" " + res.val);
            res = res.next;
        }
    }
}
