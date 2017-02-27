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
                // Complete graph with uniformly random edge weights between 0 and 1
                GraphRandomEdges g = new GraphRandomEdges(numPoints); 

                average += g.MST();
            }
        } else {
            for (int j = 0; j < numTrials; j++) {
                // Complete graph with each vertex representing a point in a square/cube/hypercube
                Graph g = new Graph(dimension, numPoints); 

                average += g.MST();
            }
        }

        average /= numTrials;

        System.out.println("" + average + " " + numPoints + " " + numTrials + " " + dimension);
    }
}
