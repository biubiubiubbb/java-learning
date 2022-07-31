package com.qinxi.learn.algorithm.list;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
    }


    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        this.head = new ListNode(0, null);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode node = this.head;
        while (index >= 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if(index > size) {
            return;
        }
        ListNode node = this.head;
        while (index > 0 && node.next != null) {
            node = node.next;
            index--;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = node.next;
        node.next = newNode;
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        ListNode prev = this.head;
        ListNode curr = this.head.next;
        while (index > 0) {
            prev = prev.next;
            curr = curr.next;
            index--;
        }
        prev.next = curr.next;

        this.size--;
    }
}