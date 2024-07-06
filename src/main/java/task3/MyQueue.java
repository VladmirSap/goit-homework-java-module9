package task3;

import java.util.Arrays;

public class MyQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;
    private int capacity;
    private int first;
    private int last;

    public MyQueue() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        first = 0;
        last = -1;
    }

    public void add(T value) {
        if (size == elements.length) {
            resizeElements();
        }
        last = (last + 1) % elements.length;
        elements[last] = value;
        size++;
    }

    public void resizeElements() {
        T[] newArray = (T[]) new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[(first + i) % elements.length];
        }
        elements = newArray;
        first = 0;
        last = size - 1;
    }

    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
        first = 0;
        last = 0;
    }

    // Повертає розмір черги
    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[first];
    }

    public Object poll() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object removed = elements[first];
        elements[first] = null; // Clear the reference
        first = (first + 1) % elements.length;
        size--;
        return removed;
    }
}
