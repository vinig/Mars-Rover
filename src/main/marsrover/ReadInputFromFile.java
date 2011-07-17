package marsrover;

import java.io.*;
import java.util.ArrayList;

public class ReadInputFromFile {

    public ArrayList<String> readFile(String fileName) throws IOException{
        ArrayList<String> fileInputData = new ArrayList<String>();
        String line;
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line= bufferedReader.readLine())!= null){
            fileInputData.add(line);
        }
        return fileInputData;
    }
}
