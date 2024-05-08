public interface IImageSegmenter {
    void processPixels(IPixel[][] pixels);

    int getNumberOfClusters();

    int[][] getClusterInfo();

    int[] getClusterSizes();

    int getCluster(int y, int x);

    int getClusterSize(int clusterId);
}
