import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    // Inner class representing a node in the linked list
    private class MyNode {
        T data; // Data stored in the node
        MyNode next; // Reference to the next node
        MyNode prev; // Reference to the previous node

        MyNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode head; // Reference to the first node in the list
    private MyNode tail; // Reference to the last node in the list
    private int size; // Number of elements in the linked list

    // Constructs an empty linked list
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Appends the specified element to the end of this list
    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    // Replaces the element at the specified position in this list with the specified element
    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    // Inserts the specified element at the specified position in this list
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size) {
            add(item);
            return;
        }
        MyNode newNode = new MyNode(item);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            MyNode prevNode = getNode(index - 1);
            MyNode nextNode = prevNode.next;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            prevNode.next = newNode;
            nextNode.prev = newNode;
        }
        size++;
    }

    // Inserts the specified element at the beginning of this list
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Appends the specified element to the end of this list
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Returns the element at the specified position in this list
    @Override
    public T get(int index) {
        MyNode node = getNode(index);
        return node.data;
    }

    // Returns the first element in this list
    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    // Returns the last element in this list
    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    // Removes the element at the specified position in this list
    @Override
    public void remove(int index) {
        MyNode nodeToRemove = getNode(index);
        if (index == 0) {
            head = nodeToRemove.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (index == size - 1) {
            tail = nodeToRemove.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            MyNode prevNode = nodeToRemove.prev;
            MyNode nextNode = nodeToRemove.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
    }

    // Removes the first element from this list
    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        remove(0);
    }

    // Removes the last element from this list
    @Override
    public void removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        remove(size - 1);
    }

    // Returns the node at the specified index
    private MyNode getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Returns the number of elements in this list
    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Returns an iterator over the elements in this list in proper sequence
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    // Inner class for iterator implementation
    private class MyIterator implements Iterator<T> {
        private MyNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    // Returns true if this list contains the specified element
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Returns an array containing all of the elements in this list in proper sequence
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    // Removes all of the elements from this list
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Sorts this list in ascending order
    @Override
    public void sort() {
        throw new UnsupportedOperationException("Sorting is not supported for LinkedList");
    }
}

