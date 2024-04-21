public class Main {
    public static void main(String[] args) {
        // Testing MyArrayList
        System.out.println("Testing MyArrayList:");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("Size of ArrayList: " + arrayList.size()); // Should print: 3

        // Testing MyLinkedList
        System.out.println("\nTesting MyLinkedList:");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(100);
        linkedList.add(200);
        linkedList.add(300);
        System.out.println("Size of LinkedList: " + linkedList.size()); // Should print: 3

        // Testing MyStack
        System.out.println("\nTesting MyStack:");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top of Stack: " + stack.top()); // Should print: 3

        // Testing MyQueue
        System.out.println("\nTesting MyQueue:");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(11);
        queue.enqueue(22);
        queue.enqueue(33);
        System.out.println("Front of Queue: " + queue.front()); // Should print: 11

        // Testing MyMinHeap
        System.out.println("\nTesting MyMinHeap:");
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(2);
        System.out.println("Min element of MinHeap: " + minHeap.getMin()); // Should print: 2
    }
}
