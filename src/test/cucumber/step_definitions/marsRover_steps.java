package cucumber.step_definitions;

import cuke4duke.annotation.I18n.EN.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class marsRover_steps {

    @Given("^I enter the end coordinates of Plateau as ([0-9]+) ([0-9]+)$")
    public void enterCoordinatesOfPlateau(int x_coordinate, int y_coordinates){

    }

    @When("^I enter the initial position of the Rover as ([0-9]+) ([0-9]+) ([^\"]*)$")
    public void initialPositionOfRover(int x_coordinate, int y_coordinate, String direction){

    }

    @When("^I give the instructions for its movement as ([^\"]*)$")
    public void giveInstructions(String instructions){

    }

    @Then("^The Mars Rover should reach position ([0-9]+) ([0-9]+) ([^\"]*)$")
    public void reachFinalPosition(int x_coordinate, int y_coordinate, String direction){

    }

}