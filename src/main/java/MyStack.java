import java.util.EmptyStackException;

public class MyStack<T> {
    private final MyLinkedList<T> list;

    // Constructor to initialize the stack
    public MyStack() {
        list = new MyLinkedList<>();
    }

    // Adds an element to the top of the stack
    public void push(T item) {
        list.addFirst(item);
    }

    // Returns the element at the top of the stack without removing it
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getFirst();
    }

    // Removes and returns the element at the top of the stack
    public T pop() {
        T item = list.getLast();
        list.removeFirst();
        return item;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Returns the size of the stack
    public int size() {
        return list.size();
    }

    // Clears the stack by removing all elements
    public void clear() {
        list.clear();
    }
}
