import java.util.Random;

@SuppressWarnings("unchecked")
public class Graph {
    private double[][] mVertices;
    private int mNumVertices;
    private int mDimension;

    public Graph(int dimension, int numVertices) {
        mNumVertices = numVertices;
        mDimension = dimension;

        mVertices = new double[mNumVertices][mDimension];
        Random rand = new Random();

        for (int i = 0; i < mNumVertices; i++) {
            for (int j = 0; j < mDimension; j++) {
                mVertices[i][j] = rand.nextDouble();
            }
        }
    }

    public double MST() {
        double[] distance = new double[mNumVertices];
        boolean[] inMST = new boolean[mNumVertices];
        LinkedNode<Tuple>[] nodePointers = new LinkedNode[mNumVertices];

        PriorityQueue<Tuple> heap = new PriorityQueue<>();

        for (int i = 0; i < mNumVertices; i++) {
            distance[i] = 100; // No distance will be greater than 100 up to 4 dimensions
        }

        distance[0] = 0;
        nodePointers[0] = heap.addValue(new Tuple(0, 0)); // Start at random vertex indexed to 0
        double MSTweight = 0;

        for (int z = 0; z < mNumVertices; z++) {
            Tuple temp = heap.deleteMin(); // Find minimum edge length
//            int min_index = -1;
//            double min = 101;
//            for (int i = 0; i < mNumVertices; i++) {
//                if (distance[i] < min && !inMST[i]) {
//                    min = distance[i];
//                    min_index = i;
//                }
//            }

            MSTweight += distance[temp.getId()];
            inMST[temp.getId()] = true;

            for (int k = 0; k < mNumVertices; k++) {
                if (!inMST[k]) { // Don't add edges that form cycles
                    double tempDistance = 0;

                    for (int l = 0; l < mDimension; l++) {
                        tempDistance += Math.pow(mVertices[temp.getId()][l] - mVertices[k][l], 2); // Calculate distance based on vertex coordinates
                    }

                    tempDistance = Math.sqrt(tempDistance);

                    if (tempDistance < distance[k]) { 
                        distance[k] = tempDistance;

                        if (nodePointers[k] == null)
                            nodePointers[k] = heap.addValue(new Tuple(k, tempDistance));
                        else
                            nodePointers[k].getValue().setDistance(tempDistance);
                    }
                }
            }
        }

        return MSTweight;
    }
}
