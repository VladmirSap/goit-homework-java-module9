package task5;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 8;
    private Node<K, V>[] table;
    private int size;

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        if (key == null) {
            if (nullKeyNode == null) {
                nullKeyNode = new Node<>(null, value);
                size ++;
            } else {
                nullKeyNode.value = value;
            }
            return;
        }

        int index = hash(key);
        Node<K, V> newNode = new Node<>(key, value);

        Node<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;

        }

        if (current == null) {
            if (table[index] == null) {
                table[index] = newNode;

            } else {
                newNode.next = table[index];
                table[index] = newNode;
            } size ++;
        }

        if (size > table.length * 0.75) {
            resizeTable();
        }
    }

    private Node<K, V> nullKeyNode;

    public Object get(K key) {
        if (key == null) {
            if (nullKeyNode != null) {
                return nullKeyNode.value;
            }
            return null;
        }

        int index = hash(key);
        Node<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        if (key == null) {
            if (nullKeyNode != null) {
                nullKeyNode = null;
                size --;
            } return;
        }
        int index = hash(key);
        Node<K, V> prev = null;
        Node<K, V> current = table[index];

        while (current != null) {
            if (current.key == null && key == null || current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    private void resizeTable() {
        Node<K, V>[] newTable = new Node[table.length * 2];
        for (Node<K, V> node : table) {
            while (node != null) {
                Node<K, V> next = node.next;
                int index = hash((K) node.key);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }
        table = newTable;
    }
}
