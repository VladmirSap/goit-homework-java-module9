package task4;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(Object value) {
        if (size == elements.length) {
            resizeElement();
        }
        elements[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of size");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i+1];
        }
        elements[size - 1] = null;
        size--;

    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object popped = elements[--size];
        elements[size] = null;
        return popped;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size-1];
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void resizeElement() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
