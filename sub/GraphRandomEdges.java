import java.util.Random;

@SuppressWarnings("unchecked")
public class GraphRandomEdges {
    private int mNumVertices;

    public GraphRandomEdges(int numVertices) {
        mNumVertices = numVertices;
    }

    public double MST() {
        Random rand = new Random();
        double[] distance = new double[mNumVertices];
        boolean[] inMST = new boolean[mNumVertices];
        LinkedNode<Tuple>[] nodePointers = new LinkedNode[mNumVertices];

        PriorityQueue<Tuple> heap = new PriorityQueue<>();

        for (int i = 0; i < mNumVertices; i++) {
            distance[i] = 100; // No distance will be greater than 100
        }

        distance[0] = 0;
        nodePointers[0] = heap.addValue(new Tuple(0, 0)); // Start at random vertex indexed to 0
        double MSTweight = 0;

        for (int z = 0; z < mNumVertices; z++) {
            Tuple temp = heap.deleteMin(); // Find minimum edge length

            MSTweight += distance[temp.getId()];
            inMST[temp.getId()] = true;

            for (int k = 0; k < mNumVertices; k++) {
                if (!inMST[k]) { // Don't add edges that form cycles
                    double tempDistance = rand.nextDouble(); // Since the edge won't be visitged more than once, the random edge weighrt can be calculated "on the fly"

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