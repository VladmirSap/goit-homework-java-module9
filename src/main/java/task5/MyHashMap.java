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
        int index = hash((K) key);
        Node<K, V> newNode = new Node<K, V>(key, value);

        Node<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        newNode.next = table[index];
        table[index] = newNode;
        size++;

        if (size > table.length * 0.75) {
            resizeTable();
        }
    }

    public Object get(K key) {
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            Node<K, V> currentNode = table[i];
            while (currentNode != null) {
                stringBuilder.append(currentNode.key).append(" = ").append(currentNode.value);
                if (i < table.length - 1) {
                    stringBuilder.append(", ");
                }
                currentNode = currentNode.next;
            }

        }
        return stringBuilder.toString();
    }
}
