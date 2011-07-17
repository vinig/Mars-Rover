package marsrover;

import sun.text.normalizer.IntTrie;

public class Plateau {

    private int[] coordinates = new int[2];

    public void initializePlateau(int x_coordinate, int y_coordinate) {
        this.coordinates[0] = x_coordinate;
        this.coordinates[1] = y_coordinate;
    }

    public int[] getCoordinates() {
        return coordinates;
    }
}
