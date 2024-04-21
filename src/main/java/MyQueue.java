import java.util.EmptyStackException;

public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    // Constructor to initialize the queue
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    // Adds an element to the back of the queue
    public void enqueue(T item) {
        list.addLast(item);
    }

    // Returns the element at the front of the queue without removing it
    public T front() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getFirst();
    }

    // Returns the element at the back of the queue without removing it
    public T back() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getLast();
    }

    // Removes and returns the element at the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Returns the size of the queue
    public int size() {
        return list.size();
    }

    // Clears the queue by removing all elements
    public void clear() {
        list.clear();
    }
}

