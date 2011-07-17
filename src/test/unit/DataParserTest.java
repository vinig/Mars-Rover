package unit;

import marsrover.DataParser;
import marsrover.ReadInputFromFile;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.when;

public class DataParserTest {

    @MockitoAnnotations.Mock
    private ReadInputFromFile readInputFromFile;

    ArrayList<String> fileContent = new ArrayList<String>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        fileContent.add("5 5");
        fileContent.add("1 2 N");
        fileContent.add("LMLMLMLMM");
        try{
            when(readInputFromFile.readFile("Input.txt")).thenReturn(fileContent);
        }catch (IOException ex){
            System.out.println("Error in reading file");
        }
}

    @Test
    public void shouldParseFileContentForPlateau(){
        DataParser dataParser = new DataParser();
        int coordinatesOfPlateau[] = dataParser.parseDataForPlateau(fileContent);
        assertThat(coordinatesOfPlateau[0], is(5));
        assertThat(coordinatesOfPlateau[1], is(5));
    }

    @Test
    public void shouldParseFileContentForRover(){
        DataParser dataParser = new DataParser();
        int index = 1;
        ArrayList<String> arrayList = dataParser.parseDataForRover(fileContent,index);
        assertThat(arrayList.get(0), is("1"));
        assertThat(arrayList.get(1), is("2"));
        assertThat(arrayList.get(2), is("N"));
        assertThat(arrayList.get(3), is("LMLMLMLMM"));
    }




}
