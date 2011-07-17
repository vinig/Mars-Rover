package unit;


import marsrover.Plateau;
import marsrover.Rover;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class RoverTest {

    @MockitoAnnotations.Mock
    private Plateau plateau;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        int upperCoordinatesOfPlateau[] = {5,5};
        int lowerCoordinatesOfPlateau[] = {0,0};
        when(plateau.getUpperBoundCoordinates()).thenReturn(upperCoordinatesOfPlateau);
        when(plateau.getLowerBoundCoordinates()).thenReturn(lowerCoordinatesOfPlateau);
    }

    @Test
    public void shouldInitializeRoverPositionOneTwoNorth() {
        int x_coordinate = 1;
        int y_coordinate = 2;
        String direction = "N";
        Rover rover = new Rover(x_coordinate, y_coordinate, direction);
        int coordinates[] = rover.getCoordinates();
        String roverDirection = rover.getDirection();
        assertThat(coordinates[0], is(x_coordinate));
        assertThat(coordinates[1], is(y_coordinate));
        assertThat(roverDirection, is(direction));
    }

    @Test
    public void turnRoverLeft(){
        Rover rover = new Rover(1, 2, "N");
        rover.turnLeft();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("W"));
    }

    @Test
    public void turnRoverLeftTwice(){
        Rover rover = new Rover(1, 2 ,"N");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("LL");
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("S"));
    }

    @Test
    public void turnRoverLeftThrice(){
        Rover rover = new Rover(1, 2 ,"N");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("LLL");
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("E"));
    }

    @Test
    public void turnRoverRight(){
        Rover rover = new Rover(1, 2 ,"N");
        rover.turnRight();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("E"));
    }

    @Test
    public void turnRoverRightTwice(){
        Rover rover = new Rover(1, 2 ,"N");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("RR");
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("S"));
    }

    @Test
    public void turnRoverRightFourTimes(){
        Rover rover = new Rover(1, 2 ,"N");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("RRRR");
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("N"));
    }

    @Test
    public void makeRoverJumpStep(){
        Rover rover = new Rover(1, 2, "N");
        rover.jumpStep();
        int coordinates[] = rover.getCoordinates();
        assertThat(coordinates[1], is(3));
    }

    @Test
    public void makeRoverJumpTwoSteps(){
        Rover rover = new Rover(1, 2, "N");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("MM");
        int coordinates[] = rover.getCoordinates();
        assertThat(coordinates[1], is(4));
    }

    @Test
    public void makeRoverTurnLeftAndJumpStep(){
        Rover rover = new Rover(1, 2, "N");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("LM");
        int coordinates[] = rover.getCoordinates();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("W"));
        assertThat(coordinates[0], is(0));
    }

    @Test
    public void makeRoverTurnRightAndJumpStep(){
        Rover rover = new Rover(1, 2, "N");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("RM");
        int coordinates[] = rover.getCoordinates();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("E"));
        assertThat(coordinates[0], is(2));
    }

    @Test
    public void makeRoverTurnRightTwiceAndJumpStep(){
        Rover rover = new Rover(1, 2, "N");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("RRM");
        int coordinates[] = rover.getCoordinates();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("S"));
        assertThat(coordinates[1], is(1));
    }

    @Test
    public void giveRoverMultipleInstructions(){
        Rover rover = new Rover(1, 2, "N");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("LMLMLMLMM");
        int coordinates[] = rover.getCoordinates();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("N"));
        assertThat(coordinates[0], is(1));
        assertThat(coordinates[1], is(3));
    }

    @Test
    public void shouldReturnFinalPositionOfRover(){
        Rover rover = new Rover(2, 3, "W");
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions("RMMLMR");
        String finalOutput = rover.giveFinalPositionOfRover();
        assertThat(finalOutput, is("1 5 N"));
    }


}
