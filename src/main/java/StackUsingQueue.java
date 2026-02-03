import java.util.Objects;

public class ArrayQueue<E> implements QueueADT<E> {
    private final E[] data;
    private int front = 0;  // index of the front element
    private int size = 0;   // number of elements in the queue

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        // return current number of elements
        return size;
    }

    @Override
    public boolean isEmpty() {
        // return true if size == 0
        return size == 0;
    }

    @Override
    public E first() {
        // if empty return null; else return data[front]
        if (isEmpty()) return null;
        return data[front];
    }

    @Override
    public void enqueue(E e) {
        Objects.requireNonNull(e, "Null elements are not supported in this assignment.");

        // 1) if full throw IllegalStateException
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }

        // 2) compute available index
        int avail = (front + size) % data.length;

        // 3) store element
        data[avail] = e;

        // 4) increment size
        size++;
    }

    @Override
    public E dequeue() {
        // 1) if empty return null
        if (isEmpty()) return null;

        // 2) store answer
        E answer = data[front];

        // 3) help garbage collection
        data[front] = null;

        // 4) move front
        front = (front + 1) % data.length;

        // 5) decrement size
        size--;

        // 6) return answer
        return answer;
    }

    // Helpful for debugging (not graded)
    int capacity() { return data.length; }
}
