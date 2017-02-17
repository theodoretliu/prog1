import java.util.Random;

class Graph {
    private double[][] mVertices;
    private int mNumVertices;
    private int mDimension;

    Graph(int dimension, int numVertices) {
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

    double MST() {
        double[] distance = new double[mNumVertices];
        boolean[] inMST = new boolean[mNumVertices];

        for (int i = 0; i < mNumVertices; i++) {
            distance[i] = 100;
        }

        distance[0] = 0;

        double MSTweight = 0;

        for (int z = 0; z < mNumVertices; z++) {
            int min_index = -1;
            double min = 101;
            for (int i = 0; i < mNumVertices; i++) {
                if (distance[i] < min && !inMST[i]) {
                    min = distance[i];
                    min_index = i;
                }
            }

            MSTweight += distance[min_index];
            inMST[min_index] = true;

            for (int k = 0; k < mNumVertices; k++) {
                if (!inMST[k]) {
                    double tempDistance = 0;

                    for (int l = 0; l < mDimension; l++) {
                        tempDistance += Math.pow(mVertices[min_index][l] - mVertices[k][l], 2);
                    }

                    tempDistance = Math.sqrt(tempDistance);

                    if (tempDistance < distance[k])
                        distance[k] = tempDistance;
                }
            }
        }

        return MSTweight;
    }
}
