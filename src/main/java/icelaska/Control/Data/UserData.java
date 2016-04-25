package icelaska.Control.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kasa2 on 4/24/2016.
 */
public class UserData {
    private final List<String> coordinates;
    private final String message;
    //private final String image;
    //private final String sound;

    public UserData(String coordinates, String message) {
        this.coordinates = coordinateSetup(coordinates);
        this.message = message;
        //this.image = image;
        //this.sound = sound;
    }

    private List<String> coordinateSetup(String coordinates) {
        //System.out.println(coordinates);
        List<String> coordinate = new ArrayList<>();

        Pattern pattern = Pattern.compile("-?[0-9]*.[0-9]* -?[0-9]*.[0-9]*,?");
        Matcher matcher = pattern.matcher(coordinates);

        while(matcher.find()){
            StringBuffer temp = new StringBuffer(matcher.group());

            int index = temp.indexOf(",");
            if(index > -1){
                temp.deleteCharAt(index);
            }
            index = temp.indexOf(" ");
            temp.setCharAt(index, ',');
            coordinate.add(temp.toString());
        }

        //System.out.println(coordinate);
        return coordinate;
    }

    public List<String> getCoordinates(){
        return coordinates;
    }

    public String getMessage() {
        return message;
    }
}
