package unit;

import marsrover.ReadInputFromFile;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReadInputFromFileTest {

    @Test
    public void shouldReadInputFromFile() throws IOException {
        ReadInputFromFile reader = new ReadInputFromFile();
        ArrayList<String> inputData = reader.readFile("Input.txt");
        assertThat(inputData.get(0),is("5 5"));
        assertThat(inputData.get(1),is("1 2 N"));
        assertThat(inputData.get(2),is("LMLMLMLMM"));
    }

}
