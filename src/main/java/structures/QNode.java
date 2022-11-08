package structures;

/**
 * A {@link QNode} is an element of a stack that is implemented
 * using a Linked List structure to allow for unbounded size.
 */
class QNode<T>
{

    // TONOTDO: please do not edit this class
    // ...well, you can change the variable names if you like

    public T element;
    public QNode<T> next;

    public QNode(T elem)
    {
        element = elem;
        next = null;
    }

    public T getElement()
    {
        return element;
    }

    public void setElement(T elem)
    {
        element = elem;
    }

    public QNode<T> getNext()
    {
        return next;
    }

    public void setNext(QNode<T> nextNode)
    {
        next = nextNode;
    }
}
