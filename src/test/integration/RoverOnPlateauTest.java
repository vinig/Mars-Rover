package integration;

import marsrover.Plateau;
import marsrover.Rover;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoverOnPlateauTest {

    @Test
    public void shouldCheckBoundsForRover(){
        int x_coordinate = 5;
        int y_coordinate = 5;
        Plateau plateau = new Plateau();
        plateau.initializePlateau(x_coordinate, y_coordinate);
        Rover rover = new Rover(2, 3, "W");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("RMMLMR");
        String finalOutput = rover.giveFinalPositionOfRover();
        assertThat(finalOutput, is("1 5 N"));
    }
}