public class Tuple implements Comparable<Tuple> {
    private int mId;
    private double mDistance;

    public Tuple(int id, double distance) {
        mId = id;
        mDistance = distance;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public double getDistance() {
        return mDistance;
    }

    public void setDistance(double distance) {
        mDistance = distance;
    }

    public int compareTo(Tuple other) {
        if (mDistance < other.getDistance())
            return -1;
        else if (mDistance > other.getDistance())
            return 1;
        else
            return 0;
    }
}
