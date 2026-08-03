package net.kenyang.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int iCapacity;
    int iCurrentSize = 0;
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    private final Node head = new Node();
    private final Node tail = new Node();

    private class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;
    }

    public LRUCache(int capacity) {
        this.iCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    /**
     * move to the tail
     * 
     * @param current
     * @param key
     */
    private void updateToNewestNode(Node current, int key) {
        removeNode(current);
        addToTail(current);
    }

    /**
     * We need to move middleNode to the end, so we need to reconnect the
     * prevNode and nextNode.
     * 
     * @param middleNode
     */
    private void reconnectNode(Node middleNode) {
        removeNode(middleNode);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(Node node) {
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }

    public void set(int key, int value) {

        Node current = map.get(key);
        if (current != null) {
            current.value = value;
            if (current != tail.prev) {
                reconnectNode(current);
                addToTail(current);
            }
        } else {
            current = new Node();
            current.key = key;
            current.value = value;

            if (iCurrentSize >= iCapacity) {
                Node first = head.next;
                map.remove(first.key);
                removeNode(first);
            } else {
                iCurrentSize++;
            }

            map.put(key, current);
            addToTail(current);
        }

        if (head.next == tail) {
            iCurrentSize = 0;
        }
    }

    public int get(int key) {
        Node current = map.get(key);
        if (current == null) {
            return -1;
        }

        if (current != tail.prev) {
            reconnectNode(current);
            addToTail(current);
        }

        return current.value;
    }
}