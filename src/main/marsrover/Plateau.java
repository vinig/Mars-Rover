package marsrover;

public class Plateau {

    private int[] upperBoundCoordinates = new int[2];
    private int[] lowerBoundCoordinates = {0, 0};

    public void initializePlateau(int x_coordinate, int y_coordinate) {
        this.upperBoundCoordinates[0] = x_coordinate;
        this.upperBoundCoordinates[1] = y_coordinate;
    }

    public int[] getUpperBoundCoordinates() {
        return this.upperBoundCoordinates;
    }

    public int[] getLowerBoundCoordinates() {
        return this.lowerBoundCoordinates;
    }
}
