package unit;

import marsrover.Rover;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoverTest {

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
        rover.readInstructions("LL");
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("S"));
    }

    @Test
    public void turnRoverLeftThrice(){
        Rover rover = new Rover(1, 2 ,"N");
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
        rover.readInstructions("RR");
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("S"));
    }

    @Test
    public void turnRoverRightFourTimes(){
        Rover rover = new Rover(1, 2 ,"N");
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
        rover.readInstructions("MM");
        int coordinates[] = rover.getCoordinates();
        assertThat(coordinates[1], is(4));
    }

    @Test
    public void makeRoverTurnLeftAndJumpStep(){
        Rover rover = new Rover(1, 2, "N");
        rover.readInstructions("LM");
        int coordinates[] = rover.getCoordinates();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("W"));
        assertThat(coordinates[0], is(0));
    }

    @Test
    public void makeRoverTurnRightAndJumpStep(){
        Rover rover = new Rover(1, 2, "N");
        rover.readInstructions("RM");
        int coordinates[] = rover.getCoordinates();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("E"));
        assertThat(coordinates[0], is(2));
    }

    @Test
    public void makeRoverTurnRightTwiceAndJumpStep(){
        Rover rover = new Rover(1, 2, "N");
        rover.readInstructions("RRM");
        int coordinates[] = rover.getCoordinates();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("S"));
        assertThat(coordinates[1], is(1));
    }

    @Test
    public void giveRoverMultipleInstructions(){
        Rover rover = new Rover(1, 2, "N");
        rover.readInstructions("LMLMLMLMM");
        int coordinates[] = rover.getCoordinates();
        String roverDirection = rover.getDirection();
        assertThat(roverDirection, is("N"));
        assertThat(coordinates[0], is(1));
        assertThat(coordinates[1], is(3));
    }

    @Test
    public void giveRoverMultipleInstructionsAndGetFinalOutput(){
        Rover rover = new Rover(2, 3, "W");
        rover.readInstructions("RMMLMRMM");
        String finalOutput = rover.getFinalOutput();
        assertThat(finalOutput, is("1 7 N"));
    }

}
