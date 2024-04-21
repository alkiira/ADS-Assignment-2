public class MyMinHeap <T extends Comparable<T>> {

    MyArrayList<T> heap = new MyArrayList<>(); // Based on ArrayList

    public MyMinHeap() { // Null constructor
    }

    public void empty() { // clear function
        heap.clear();
    }

    public int size() {
        return heap.size();
    } // size function

    public T getMin() { // first element
        return heap.get(0);
    }

    // Extracts and returns the minimum element in the heap
    public T extractMin() {
        T min = heap.get(0);
        swap(0, size() - 1);
        heap.remove(size() - 1);
        heapify(0);
        return min;
    }
    public void insert(T item) { // inserts item to the end of the heap and puts it to the respective place
        heap.add(item);
        int i = heap.size() - 1;
        heapify(i);
    }

    private void heapify(int i) { // heapify function to maintain the heap property after deletion or insertion
        int left = leftChildOf(i);
        int right = rightChildOf(i);
        int smallest = i;
        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void traverse(int i) { // traverse function to print the heap
        if (i < heap.size()) {
            System.out.println(heap.get(i));
            traverse(leftChildOf(i));
            traverse(rightChildOf(i));
        }
    }

    public int leftChildOf(int i) {
        return 2 * i;
    } // returns left child though math

    public int rightChildOf(int i) {
        return 2 * i + 1;
    } // returns right child through math

    public int parentOf(int i) {
        return i / 2;
    } // returns parent through math

    public void swap(int i, int j) { // swaps two elements
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
