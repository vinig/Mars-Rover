package marsrover;

import java.util.ArrayList;

public class DataParser {

    public int[] parseDataForPlateau(ArrayList<String> fileContent){
        String coordinatesOfPlateauInString[] = fileContent.get(0).split(" ");
        int[] coordinatesOfPlateau = new int[2];
        coordinatesOfPlateau[0] = Integer.parseInt(coordinatesOfPlateauInString[0]);
        coordinatesOfPlateau[1] = Integer.parseInt(coordinatesOfPlateauInString[1]);
        return coordinatesOfPlateau;
    }

    public ArrayList<String> parseDataForRover(ArrayList<String> fileContent, int index){
        ArrayList<String> arrayList = new ArrayList<String>(4);
        String informationOnRover[] = fileContent.get(index).split(" ");
        arrayList.add(informationOnRover[0]);
        arrayList.add(informationOnRover[1]);
        arrayList.add(informationOnRover[2]);
        arrayList.add(fileContent.get(index+1));
        return arrayList;
    }



}
