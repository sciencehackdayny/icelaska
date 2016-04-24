package Control.Data;

/**
 * Created by kasa2 on 4/24/2016.
 */
public class UserData {
    private final int[][] coordinates;
    private final String message;
    //private final String image;
    //private final String sound;

    public UserData(String coordinates, String message) {
        this.coordinates = coordinateSetup(coordinates);
        this.message = message;
        //this.image = image;
        //this.sound = sound;
    }

    private int[][] coordinateSetup(String coordinates) {
        //todo implement
        return null;
    }

    public int[][] getCoordinates(){
        return coordinates;
    }

    public String getMessage() {
        return message;
    }
}
