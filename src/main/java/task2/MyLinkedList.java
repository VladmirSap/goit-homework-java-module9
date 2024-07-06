package task2;

import java.util.Objects;

public class MyLinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        T val;
        Node<T> next;
        public Node(T val) {
            this.val = val;
        }
    }

    @Override
    public void add(T val) {
        Node<T> newNode = new Node<>(val);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size ++;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).val;
    }
    //
    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedVal;
        if (index == 0) {
            removedVal = first.val;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removedVal = prev.next.val;
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
        }
        size --;
        return removedVal;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
