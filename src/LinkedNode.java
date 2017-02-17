 public class LinkedNode<E extends Compare<E>> {
    private E mValue;
    private LinkedNode<E> mNext;

    public LinkedNode(E value, LinkedNode<E> next) {
        mValue = value;
        mNext = next;
    }

    public E getValue() {
        return mValue;
    }

    public void setValue(E value) {
        mValue = value;
    }

    public LinkedNode<E> next() {
        return mNext;
    }

    public void setNext(LinkedNode<E> next) {
        mNext = next;
    }
}
