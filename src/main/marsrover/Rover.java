package marsrover;

import java.util.HashMap;

public class Rover {
    private int[] coordinates = new int[2];
    private String direction;
    private int[] upperBoundCoordinatesOfPlateau = new int[2];
    private int[] lowerBoundCoordinatesOfPlateau = new int[2];

    private HashMap<String, String> DIRECTION_MAP_LEFT;
    private HashMap<String, String > DIRECTION_MAP_RIGHT;

    public Rover(int x_coordinate, int y_coordinate, String direction) {
        this.coordinates[0] = x_coordinate;
        this.coordinates[1] = y_coordinate;
        this.direction = direction;
        createHashMap();
    }

    public int[] getCoordinates(){
        return coordinates;
    }

    public String getDirection(){
        return direction;
    }


    private void changeDirection(String newDirection) {
        this.direction = newDirection;
    }

    private void createHashMap(){
        DIRECTION_MAP_LEFT = new HashMap<String, String>();
        DIRECTION_MAP_RIGHT = new HashMap<String, String>();

        DIRECTION_MAP_LEFT.put("N","W");
        DIRECTION_MAP_LEFT.put("W","S");
        DIRECTION_MAP_LEFT.put("S","E");
        DIRECTION_MAP_LEFT.put("E","N");

        DIRECTION_MAP_RIGHT.put("W","N");
        DIRECTION_MAP_RIGHT.put("N","E");
        DIRECTION_MAP_RIGHT.put("E","S");
        DIRECTION_MAP_RIGHT.put("S","W");
    }

    public void readInstructions(String instructions) {
        String singleInstruction;
        for (int index = 0; index < instructions.length(); index++ ){
            checkBounds();
            singleInstruction = instructions.substring(index, index+1).toUpperCase();
            if (singleInstruction.equals("L")){
                turnLeft();
            }else if (singleInstruction.equals("R")){
                turnRight();
            }else if (singleInstruction.equals("M")){
                jumpStep();
            }else {
                throw new RoverException("Please give the proper instructions (L/R/M)");
            }
        }
    }


    public void turnLeft() {
        changeDirection(DIRECTION_MAP_LEFT.get(getDirection()));
    }

    public void turnRight() {
         changeDirection(DIRECTION_MAP_RIGHT.get(getDirection()));
    }

    public void jumpStep() {
        int increment_step = 1;
        int decrement_step = -1;
        if (getDirection().equals("N")){
            changePositionOfRover("Y", increment_step);
        }
        if (getDirection().equals("E")){
            changePositionOfRover("X", increment_step);
        }
        if (getDirection().equals("S")){
            changePositionOfRover("Y", decrement_step);
        }
        if (getDirection().equals("W")){
            changePositionOfRover("X", decrement_step);
        }
    }

    private void changePositionOfRover(String moveInThisDirection, int stepToJump) {
        if (moveInThisDirection.equals("X")){
            this.coordinates[0] = this.coordinates[0] + stepToJump;
            return;
        }
        if (moveInThisDirection.equals("Y")){
            this.coordinates[1] = this.coordinates[1] + stepToJump;
            return;
        }
    }

    public String giveFinalPositionOfRover() {
        int coordinates[] = getCoordinates();
        return (coordinates[0]+" "+coordinates[1]+" "+getDirection());
    }



    public boolean checkBounds(){
        checkXBounds(upperBoundCoordinatesOfPlateau[0],lowerBoundCoordinatesOfPlateau[0]);
        checkYBounds(upperBoundCoordinatesOfPlateau[1],lowerBoundCoordinatesOfPlateau[1]);
        return true;
    }

    private boolean checkYBounds(int upper_y_coordinate, int lower_y_coordinates) {
        if (coordinates[1] > upper_y_coordinate || coordinates[1] < lower_y_coordinates){
            throw new RoverException("Rover is out of Bound in N/S direction");
        }
        return true;
    }

    private boolean checkXBounds(int upper_x_coordinate, int lower_x_coordinates) {
        if (coordinates[0] > upper_x_coordinate || coordinates[0] < lower_x_coordinates ){
            throw new RoverException("Rover is out of Bound in E/W direction");
        }
        return true;
    }

    public void getPlateauCoordinates(Plateau plateau) {
        upperBoundCoordinatesOfPlateau =  plateau.getUpperBoundCoordinates();
        lowerBoundCoordinatesOfPlateau = plateau.getLowerBoundCoordinates();
    }
}
