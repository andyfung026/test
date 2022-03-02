package com.greencity.study.javastudy210119;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2021/1/19/019 14:38
 */
public class ListNode {
    private int val;
    private ListNode next;

    private ListNode() {
    }

    private ListNode(int val) {
        this.val = val;
    }

    private ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

