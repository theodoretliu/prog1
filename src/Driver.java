public class Driver {
    public static void main(String args[]) {
        int[] numVertices = {128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072};

        for (int num : numVertices) {
            double average = 0;
            for (int j = 0; j < 10; j++) {
                Graph g = new Graph(2, num);
                average += g.MST();
            }

            System.out.println("Average MST weight for " + num + " vertices: " + average / 10);
        }
    }
}
