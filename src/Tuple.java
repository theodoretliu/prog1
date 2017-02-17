/**
 * Created by theod on 2/15/2017.
 */
public class Tuple implements Compare<Tuple> {
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

    public double compareTo(Tuple other) {
        return mDistance - other.getDistance();
    }
}
