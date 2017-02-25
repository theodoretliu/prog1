public class Driver {
    public static void main(String args[]) {
        if (args.length != 4) {
            System.out.println("Incorrect number of arguments");
            System.exit(1);
        }

        int flexibility = Integer.parseInt(args[0]);
        int numPoints = Integer.parseInt(args[1]);
        int numTrials = Integer.parseInt(args[2]);
        int dimension = Integer.parseInt(args[3]);
        double average = 0;
        System.out.println("Running...");
        if (dimension == 0) {
            for (int i = 0; i < numTrials; i++) {
                GraphRandomEdges g = new GraphRandomEdges(numPoints);

                average += g.MST();
            }
        } else {
            for (int j = 0; j < numTrials; j++) {
                Graph g = new Graph(dimension, numPoints);

                average += g.MST();
            }
        }

        average /= numTrials;

        System.out.println("" + average + " " + numPoints + " " + numTrials + " " + dimension);
    }
}
