package com.liufr.leetcode._codeleet;

import java.util.HashMap;

/**
 * @author lfr
 * @date 2020/8/17 10:15
 *
 * 146. LRU缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 解题思路：
 * HashMap加双向链表；
 * map存值，链表保存最近读取顺序
 */
public class _146_LRUCache {
    private static class Node {
        public Integer key;
        public Integer value;
        public Node pre;
        public Node next;
        public Node() {
        }
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    Integer size;
    Integer capacity;

    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<Integer, Node>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        }
        mvHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node nodeO = cache.get(key);
        if (nodeO != null) {
            rmNode(nodeO);
        } else if(size.equals(capacity)) {
            rmNode(tail.pre);
        }

        Node nodeN = new Node(key, value);
        addHead(nodeN);
    }

    private void addHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        cache.put(node.key, node);
        size++;
    }

    private void rmNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        cache.remove(node.key);
        size--;
    }

    private void mvHead(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
}
