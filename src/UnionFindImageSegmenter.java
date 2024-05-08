import java.util.HashMap;
import java.util.Map;

public class UnionFindImageSegmenter implements IImageSegmenter {
    private int width;
    private int height;
    private int[] parent;
    private int[] size;
    private int nClusters;
    private int[][] clusterInfo; // mapping of pixel to cluster ID
    private int[] clusterSizes; // mapping of cluster ID to cluster size

    public UnionFindImageSegmenter(int height, int width) {
        this.height = height;
        this.width = width;

        parent = new int[height * width];
        size = new int[height * width];
        nClusters = height * width;

        clusterInfo = new int[height][width];
        clusterSizes = null;
    }

    private int convertToId(int y, int x) {
        return y * width + x;
    }

    private void init() {
        // initializing parent and size array
        for (int i = 0; i < height * width; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int y, int x) {
        // finding root pixel
        int cur = convertToId(y, x);
        int root = cur;
        while (root != parent[root]) {
            root = parent[root];
        }
        // path compression (setting parent of all pixels in path to root)
        while (cur != root) {
            int nextCur = parent[cur];
            parent[cur] = root;
            cur = nextCur;
        }
        return root;
    }

    private void union(int y1, int x1, int y2, int x2) {
        // finding root of both pixels
        int root1 = find(y1, x1);
        int root2 = find(y2, x2);

        // if not already in the same set, then union by size
        if (root1 != root2) {
            int parentId = size[root1] < size[root2] ? root2 : root1;
            int childId = size[root1] < size[root2] ? root1 : root2;
            parent[childId] = parentId;
            size[parentId] += size[childId];

            // decrement the number of total clusters
            nClusters--;
        }
    }

    @Override
    public void processPixels(IPixel[][] pixels) {
        final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // initialize
        init();

        // cluster
        // iterate through all pixels
        // for each pixel, union with neighboring pixel if same color
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                boolean isWhite = pixels[y][x].isWhite();
                for (int i = 0; i < dirs.length; i++) {
                    int nextY = y + dirs[i][0];
                    int nextX = x + dirs[i][1];

                    // if out of bounds, continue
                    if (nextY < 0 || nextY >= height) {
                        continue;
                    }
                    if (nextX < 0 || nextX >= width) {
                        continue;
                    }

                    boolean isNeighborWhite = pixels[nextY][nextX].isWhite();

                    if (isWhite == isNeighborWhite) {
                        union(y, x, nextY, nextX);
                    }
                }
            }
        }

        // post-process
        processResult();
    }

    private void processResult() {
        int curClusterCnt = 0;
        Map<Integer, Integer> rootToClusterIdMap = new HashMap<>();
        clusterSizes = new int[nClusters];

        // each cluster is associated with a unique ID
        // iterate through pixel and store pixel's cluster ID in clusterInfo
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int root = find(y, x);

                if (rootToClusterIdMap.containsKey(root)) {
                    clusterInfo[y][x] = rootToClusterIdMap.get(root);
                } else {
                    rootToClusterIdMap.put(root, curClusterCnt);
                    clusterSizes[curClusterCnt] = size[root];
                    curClusterCnt++;
                }
            }
        }
    }

    @Override
    public int getNumberOfClusters() {
        return nClusters;
    }

    @Override
    public int[][] getClusterInfo() {
        return clusterInfo;
    }

    @Override
    public int[] getClusterSizes() {
        return clusterSizes;
    }

    @Override
    public int getCluster(int y, int x) {
        return clusterInfo[y][x];
    }

    @Override
    public int getClusterSize(int clusterId) {
        return clusterSizes[clusterId];
    }
}
