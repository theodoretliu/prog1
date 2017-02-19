public class Driver {
    public static void main(String args[]) {

        double average = 0;
        for (int i = 0; i < 50; i++) {
            Graph g = new Graph(2, 128);
            average += g.MST();
        }



        System.out.println(average / 50);
    }
}
