public class ArrayQueue<E> implements QueueADT<E> {

    private E[] data;
    private int front;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        data = (E[]) new Object[capacity];
        front = 0;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length) {
            throw new IllegalStateException();
        }
        int avail = (front + size) % data.length;
        data[avail] = e;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return answer;
    }

    // For debugging (not graded)
    int capacity() {
        return data.length;
    }
}
