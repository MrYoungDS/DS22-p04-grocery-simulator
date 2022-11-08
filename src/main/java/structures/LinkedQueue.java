package structures;

public class LinkedQueue<T> implements QueueInterface<T> {

    private QNode<T> front;

    @Override
    public T dequeue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public QueueInterface<T> enqueue(T elem) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        // use StringBuilder because it's faster and more memory efficient
        StringBuilder result = new StringBuilder();
        result.append("[");
        // start at the front of the list
        QNode<T> copy = this.front;
        // TODO: Write loop that goes through queue and executes the following two lines
        result.append(copy.getElement().toString());
        // move to the next node
        copy = copy.getNext();

        return result.append("]").toString();
    }

}
