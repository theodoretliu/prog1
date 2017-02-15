/**
 * Created by theod on 2/15/2017.
 */
public class Tuple implements Comparable<Tuple> {
    private int mId;
    private int mDistance;

    public Tuple(int id, int distance) {
        mId = id;
        mDistance = distance;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getDistance() {
        return mDistance;
    }

    public void setDistance(int distance) {
        mDistance = distance;
    }

    public int compareTo(Tuple other) {
        return mDistance - other.getDistance();
    }
}
