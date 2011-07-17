package unit;

import marsrover.Rover;
import org.junit.Test;
import marsrover.Plateau;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlateauTest {

    @Test
    public void shouldCreatePlateau(){
        int x_coordinate = 5;
        int y_coordinate = 5;
        Plateau plateau = new Plateau();
        plateau.initializePlateau(x_coordinate, y_coordinate);
        int coordinates[] = plateau.getUpperBoundCoordinates();
        assertThat(coordinates[0], is(x_coordinate));
        assertThat(coordinates[1], is(y_coordinate));
    }

}
