package com.qinxi.learn.algorithm.list;

import java.util.Random;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createSimple(int num){
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        for (int i = 2; i <= num; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        return head;
    }
    public static ListNode createRandom(int num){
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        Random random = new Random(1);
        for (int i = 2; i <= num; i++) {
            listNode.next = new ListNode(Math.abs(random.nextInt() % 10));
            listNode = listNode.next;
        }
        return head;
    }

}