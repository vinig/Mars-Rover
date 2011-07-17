package cucumber.step_definitions;

import cuke4duke.annotation.I18n.EN.*;
import marsrover.ReadInputFromFile;
import org.junit.Assert;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class marsRover_steps {

    @Given("^I enter the end coordinates of Plateau as ([^\"]*)$")
    public void enterCoordinatesOfPlateau(String a){

    }

    @When("^I enter the initial position of the Rover as ([^\"]*)$")
    public void initialPositionOfRover(String direction){

    }

    @When("^I give the instructions for its movement as ([^\"]*)$")
    public void giveInstructions(String instructions){

    }

    @Then("^The Mars Rover should reach position ([^\"]*)$")
    public void reachFinalPosition(String finalOuptut){
        try{
            ReadInputFromFile reader = new ReadInputFromFile();
        ArrayList<String> inputData = reader.readFile("Output.txt");
        assertThat(inputData.get(0),is(finalOuptut));
        }catch (Exception e){}
    }

}