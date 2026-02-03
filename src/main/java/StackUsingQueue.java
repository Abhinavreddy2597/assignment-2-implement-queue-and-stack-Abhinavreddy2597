import java.util.Objects;

public class StackUsingQueue<E> implements StackADT<E> {
    private final QueueADT<E> q;

    public StackUsingQueue(int capacity) {
        this.q = new ArrayQueue<>(capacity);
    }

    @Override
    public int size() {
        return q.size();
    }

    @Override
    public boolean isEmpty() {
        return q.isEmpty();
    }

    @Override
    public E top() {
        return q.first();   // front of queue = top of stack
    }

    @Override
    public void push(E e) {
        Objects.requireNonNull(e, "Null elements are not supported in this assignment.");

        // Step 1: Add new element to the queue
        q.enqueue(e);

        // Step 2: Rotate previous elements behind it
        int rotations = q.size() - 1;
        for (int i = 0; i < rotations; i++) {
            q.enqueue(q.dequeue());
        }
    }

    @Override
    public E pop() {
        return q.dequeue();  // remove front = pop stack
    }
}
