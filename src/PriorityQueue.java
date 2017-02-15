/**
 * Created by theod on 2/15/2017.
 */
public class PriorityQueue<E extends Comparable<E>> {
    private LinkedNode<E> mHead;

    public PriorityQueue() {
        mHead = null;
    }

    public void addValue(E value) {
        mHead = new LinkedNode<E>(value, mHead);
    }

    public E deleteMin() {
        if (mHead == null)
            return null;

        LinkedNode<E> leader = mHead.next();
        LinkedNode<E> crawler = mHead;

        LinkedNode<E> min = mHead;
        LinkedNode<E> min_trailer = null;


        while (leader != null) {
            if (leader.getValue().compareTo(min.getValue()) < 0) {
                min = leader;
                min_trailer = crawler;
            }

            crawler = leader;
            leader = leader.next();
        }

        if (min.next() != null) {
            E temp = min.getValue();
            min.setValue(min.next().getValue());
            min.setNext(min.next().next());

            return temp;
        }

        if (min_trailer == null) {
            E temp = min.getValue();
            mHead = null;

            return temp;
        } else {
            E temp = min.getValue();
            min_trailer.setNext(null);

            return temp;
        }
    }

    public E getMin() {
        if (mHead == null)
            return null;

        LinkedNode<E> crawler = mHead;
        LinkedNode<E> min = mHead;

        while (crawler != null) {
            if (crawler.getValue().compareTo(min.getValue()) < 0)
                min = crawler;

            crawler = crawler.next();
        }

        return min.getValue();
    }
}
