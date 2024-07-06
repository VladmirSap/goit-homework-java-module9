package task2;

public interface List<T> {
    void add(T element);

    T get(int index);

    T remove(int index);

    int size();

    void clear();
}
