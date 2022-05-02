package com.beta.study.leetcode;

import java.util.HashMap;
import java.util.Map;

import sun.misc.LRUCache;

/**
 * @author shiqiu
 * @date 2022/05/02
 */
public class _146_LRUCache {
    /**
     * 头结点，注意是虚拟头结点，真正的元素是其next结点 这么多的好处就是在结点增删的时候方便操作
     */
    private Node head;
    /**
     * 尾结点，注意是虚拟尾结点，真正的元素是其prev结点
     */
    private Node tail;
    private Map<Integer, Node> table;
    private int capacity;
    private int size;

    public int get(int key) {
        Node node = table == null ? null : table.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = table == null ? null : table.get(key);
        if (node == null) {
            node = new Node(key, value, null, null);

            if (size + 1 > capacity) {
                removeNode(tail.prev);
            }
            addToHead(node);

        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        table.put(node.key, node);
        size++;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.next == tail) {
            tail.prev = node.prev;
            Node prev = node.prev;
            prev.next = tail;
        } else {
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
        }
        table.remove(node.key);
        size--;
    }

    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        table = new HashMap<>(capacity);
        head = new Node();
        head.prev = null;
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public _146_LRUCache() {}

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int key, int value, Node next, Node prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        _146_LRUCache lRUCache = new _146_LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
