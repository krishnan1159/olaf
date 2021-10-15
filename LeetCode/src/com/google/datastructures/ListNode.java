package com.google.datastructures;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode generateListFromArray(int[] input) {
        ListNode headNode = new ListNode(input[0]);
        ListNode prevNode = headNode;
        for (int i = 1; i < input.length; i++) {
            ListNode newNode = new ListNode(input[i]);
            prevNode.next = newNode;
            prevNode = newNode;
        }

        return headNode;
    }
}
