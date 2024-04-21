import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr; // Buffer to store elements of MyArrayList.
    private int size; // Number of elements in MyArrayList.
    private static final int DEFAULT_CAPACITY = 10; // Default initial capacity of MyArrayList.

    // Constructs an empty list with the specified initial capacity.
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        arr = new Object[initialCapacity];
    }

    // Constructs an empty list with an initial capacity of ten.
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
        size = 0;
    }

    // Increases the capacity of this MyArrayList instance to accommodate more elements.
    private void increaseCapacity() {
        Object[] temp = new Object[arr.length * 2];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }

    // Checks if the given index is within the bounds of the list.
    private void checkBounds(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // Appends the specified element to the end of this list.
    @Override
    public void add(T item) {
        if (size == arr.length)
            increaseCapacity();
        arr[size++] = item;
    }

    // Replaces the element at the specified position in this list with the specified element.
    @Override
    public void set(int index, T item) {
        checkBounds(index);
        arr[index] = item;
    }

    // Inserts the specified element at the specified position in this list.
    @Override
    public void add(int index, T item) {
        checkBounds(index);
        if (size == arr.length)
            increaseCapacity();
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
    }

    // Inserts the specified element at the beginning of this list.
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Appends the specified element to the end of this list.
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Returns the element at the specified position in this list.
    @Override
    public T get(int index) {
        checkBounds(index);
        return (T) arr[index];
    }

    // Returns the first element in this list.
    @Override
    public T getFirst() {
        return get(0);
    }

    // Returns the last element in this list.
    @Override
    public T getLast() {
        return get(size - 1);
    }

    // Removes the element at the specified position in this list.
    @Override
    public void remove(int index) {
        checkBounds(index);
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        arr[--size] = null;
    }

    // Removes the first element from this list.
    @Override
    public void removeFirst() {
        remove(0);
    }

    // Removes the last element from this list.
    @Override
    public void removeLast() {
        remove(size - 1);
    }

    // Sorts this list in ascending order.
    @Override
    public void sort() {
        // Implement sorting algorithm (e.g., bubble sort, quick sort, etc.)
    }

    // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object))
                return i;
        }
        return -1;
    }

    // Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(object))
                return i;
        }
        return -1;
    }

    // Returns true if this list contains the specified element.
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Returns an array containing all of the elements in this list in proper sequence.
    @Override
    public Object[] toArray() {
        Object[] copy = new Object[size];
        System.arraycopy(arr, 0, copy, 0, size);
        return copy;
    }

    // Removes all of the elements from this list.
    @Override
    public void clear() {
        arr = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Returns the number of elements in this list.
    @Override
    public int size() {
        return size;
    }

    // Returns an iterator over the elements in this list in proper sequence.
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    // An iterator over the elements in this list in proper sequence.
    private class MyIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return (T) arr[index++];
        }
    }
}
