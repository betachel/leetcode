package com.beta.study.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shiqiu
 * @date 2022/04/18
 */
public class LRU {

    private Map<String, Object> dataMap = new LinkedHashMap<>();

    private Map<String, Node> table;

    private Node head;
    private Node tail;

    private int size;

    private class Node {
        private String key;
        private Object value;
        private Node next;
        private Node prev;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public LRU(int size) {
        table = new HashMap<>(size);
        this.size = size;
    }

    public void put(String key, Object value) {
        if (null == key || null == value) {return;}
        Node node = new Node();
        node.setKey(key);
        node.setValue(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        table.put(key, node);

    }

    public Object get(String key) {
        if (null == key) {
            return null;
        }
        Node node = table.get(key);

        if (node == null) {
            return null;
        }
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = head;
        head.prev = node;

        head = node;

        return node.getValue();

    }

}
