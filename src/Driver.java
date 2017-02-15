/**
 * Created by theod on 2/15/2017.
 */
public class Driver {
    public static void main(String args[]) {
        PriorityQueue<Integer> test = new PriorityQueue<>();

        test.addValue(1);
        test.addValue(-5);
        test.addValue(6);

        for (int i = 0; i < 100; i++)
            test.addValue(i);

        for (int j = -4; j > -19; j--)
            test.addValue(j);

        Integer temp = null;
        while ((temp = test.deleteMin()) != null)
            System.out.println(temp);
    }
}
