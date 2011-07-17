package marsrover;

import java.io.IOException;
import java.util.ArrayList;

public class MarsRover {

    ArrayList<String> fileContent = new ArrayList<String>();

    public static void main(String args[]){
        MarsRover marsRover = new MarsRover();
        marsRover.callReadFromFileFunction("Input.txt");
        marsRover.callParser();
    }

    private void callParser() {
        int coordinatesForPlateau[] = callDataParserForPlateau();
        Plateau plateau = new Plateau();
        plateau.initializePlateau(coordinatesForPlateau[0],coordinatesForPlateau[1]);
        ArrayList<String> informationForPlateau = new ArrayList<String>();
        for (int index = 1; index < fileContent.size(); index=index+2) {
            informationForPlateau = callDataParserForRover(index);
            createRover(plateau, informationForPlateau);
        }
    }

    private void createRover(Plateau plateau, ArrayList<String> informationForPlateau) {
        int x_coordinate= Integer.parseInt(informationForPlateau.get(0));
        int y_coordinate= Integer.parseInt(informationForPlateau.get(1));
        String direction = informationForPlateau.get(2);
        String instructions= informationForPlateau.get(3);

        Rover rover = new Rover(x_coordinate,y_coordinate,direction);
        rover.getPlateauCoordinates(plateau);
        rover.readInstructions(instructions);
        String finalOutput = rover.giveFinalPositionOfRover();
        System.out.println(finalOutput);
    }

    private ArrayList<String> callDataParserForRover(int index) {
        DataParser dataParser = new DataParser();
        return (dataParser.parseDataForRover(fileContent,index));
    }

    private int[] callDataParserForPlateau() {
        DataParser dataParser = new DataParser();
        return (dataParser.parseDataForPlateau(fileContent));
    }

    private void callReadFromFileFunction(String filename) {
        ReadInputFromFile readInputFromFile = new ReadInputFromFile();
        try{
            fileContent = readInputFromFile.readFile(filename);
        }catch(IOException ex){
            System.out.println("Error in Reading the file");
        }
    }



}
