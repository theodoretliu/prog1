class LinkedNode<E extends Comparable<E>> {
    private E mValue;
    private LinkedNode<E> mNext;

    LinkedNode(E value, LinkedNode<E> next) {
        mValue = value;
        mNext = next;
    }

    E getValue() {
        return mValue;
    }

    void setValue(E value) {
        mValue = value;
    }

    LinkedNode<E> next() {
        return mNext;
    }

    void setNext(LinkedNode<E> next) {
        mNext = next;
    }
}
